import java.util.Scanner;

public class CommandUi{
	Scanner scan = new Scanner(System.in);
	GameEngine engine;
	public CommandUi(){
		engine = new GameEngine();
		System.out.println("Welcome to BlackJack.");
		while(true){
			engine.startGame();	
			int bet;
			do{
				System.out.println("You have " + engine.getPot() + " pieces.");
				System.out.print("Place your wager: ");
				bet = scan.nextInt();
			}while(!engine.setWager(bet));
			for(Card a : engine.getPlayerHand()){
				System.out.print(a.print() + " ");
			}
			System.out.println();
			System.out.print("Hit or stay? ");
			String ans = scan.nextLine();
			ans = scan.nextLine();
			while(ans.toLowerCase().equals("hit")){
				engine.playerDeal();
				for(Card a : engine.getPlayerHand()){
					System.out.print(a.print() + " ");
				}
				System.out.println();
				if(engine.calPlayerHand() > 21) break;
				System.out.print("Hit or stay? ");
				ans = scan.nextLine();
			}
			engine.dealerPlays();
			System.out.println("---------------");
			System.out.println("Your hand: " + engine.calPlayerHand());
			for(Card a : engine.getPlayerHand()){
				System.out.print(a.print() + " ");
			}
			System.out.println();
			System.out.println("---------------");
			System.out.println("Dealer's hand: " + engine.calDealerHand());
			for(Card a : engine.getDealerHand()){
				System.out.print(a.print() + " ");
			}
			System.out.println();
			System.out.println("---------------");
			if(engine.isPlayerWin()){
				System.out.println("Congratulations, you win!");
				engine.payoutPlayer();	
			} else {
				System.out.println("Suck it up, you lost!");
			}
			if(engine.getPot() <= 0){
				System.out.println("You're out of money, get out!");
				break;
			}
		}
	}
}
