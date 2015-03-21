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
			inout.setMessage("Hit or stay?");
			while(inout.getResponse().equals("hit")){
				engine.playerDeal();
				inout.displayHand(engine.getPlayerHand());
				if(engine.calPlayerHand() > 21) break;
				inout.setMessage("Hit or stay?");
			}
			engine.dealerPlays();
			inout.displayHand(engine.getDealerHand());
			inout.displayHand(engine.getPlayerHand());
			if(engine.isPlayerWin()){
				inout.setMessage("Congratulations, you win!");
				engine.payoutPlayer();
			}else {
				inout.setMessage("Suck it up, you lost!");
			}
			if(engine.getPot() <= 0){
				inout.setMessage("You're out of money, get out!");
				break;
			}
		}
	}
}
