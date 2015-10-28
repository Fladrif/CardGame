public class GameLogic{
	GameEngine engine;

	//Normally would get player array from constructor arg
	//instead of instantiating inside 
	public GameLogic(Ui inout){
		engine = new GameEngine();

		//Temporary before implementing client/server
		Player[] players = new Player[1];
		players[0] = new Player("You", 1);
		players[0].setTotal(100);

		inout.setMessage("Welcome to BlackJack.");

		//Start loop for entire game
		while(true){
			engine.startGame(players);
			int bet;

			//start loop to take in valid bet
			do{
				inout.displayPot(engine.getPot(players[0]));
				bet = inout.getWager();
			}while(!engine.setWager(bet, players[0]));

			engine.makeFilterate(players[0].getId());
			engine.nextHand();

			inout.displayHand("Player", engine.getPlayerHand(), engine.calPlayerHand());
			inout.setMessage("Hit or stay? ");
			String response = inout.getResponse();

			//start loop for gameplay for player
			while(response.equals("hit")){
				engine.playerDeal();
				inout.displayHand("Player", engine.getPlayerHand(), engine.calPlayerHand());
				if(engine.calPlayerHand() > 21) break;
				inout.setMessage("Hit or stay? ");
				response = inout.getResponse();
			}

			//runs dealer's play
			engine.dealerPlays();

			inout.displayHand("Dealer", engine.getDealerHand(), engine.calDealerHand());
			inout.displayHand("Player", engine.getPlayerHand(), engine.calPlayerHand());

			//Do end game winnings calculations and message
			if(engine.isPlayerWin()){
				inout.setMessage("Congratulations, you win!\n");
				engine.payoutPlayer(players[0]);
			}else {
				inout.setMessage("Suck it up, you lost!\n");
			}
			if(engine.getPot(players[0]) <= 0){
				inout.setMessage("You're out of money, get out!\n");
				break;
			}
		}
	}
}
