public class GameLogic{
	GameEngine engine;
	public GameLogic(Ui inout){
		engine = new GameEngine();
		inout.setMessage("Welcome to BlackJack.");
		while(true){
			engine.startGame();
			int bet;
			do{
				inout.setMessage("You have " + engine.getPot() + " pieces. \nPlace your wager: ");
				bet = inout.getWager();
			}while(!engine.setWager(bet));
			inout.displayHand(engine.getPlayerHand());
			inout.setMessage("Hit or stay? ");
			String response = inout.getResponse();
			response = inout.getResponse();
			while(response.equals("hit")){
				engine.playerDeal();
				inout.displayHand(engine.getPlayerHand());
				if(engine.calPlayerHand() > 21) break;
				inout.setMessage("Hit or stay? ");
				response = inout.getResponse();
			}
			engine.dealerPlays();
			inout.setMessage("Dealer hand: ");
			inout.displayHand(engine.getDealerHand());
			inout.setMessage("" + engine.calDealerHand() + "\n");
			inout.setMessage("Player hand: ");
			inout.displayHand(engine.getPlayerHand());
			inout.setMessage("" + engine.calPlayerHand() + "\n");
			if(engine.isPlayerWin()){
				inout.setMessage("Congratulations, you win!\n");
				engine.payoutPlayer();
			}else {
				inout.setMessage("Suck it up, you lost!\n");
			}
			if(engine.getPot() <= 0){
				inout.setMessage("You're out of money, get out!\n");
				break;
			}
		}
	}
}
