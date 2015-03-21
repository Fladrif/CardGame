import java.util.Scanner;

public class CommandUi implements Ui{
	Scanner scan = new Scanner(System.in);
	public CommandUi(){
		GameLogic logic = new GameLogic(this);
	}
	public void setMessage(String message){
		System.out.println(message);
	}
	public String getResponse(){
		String response = scan.nextLine();
		return response;
	}
	public void displayHand(Hand hand){
		for(Card a : hand.showHand().showHand()){
			System.out.print(a + " ");
		}
		System.out.println();
	}
	public int getWager(int bet){
		int wager = scan.getNextInt();
		return wager;
	}
}
