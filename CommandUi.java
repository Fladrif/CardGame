import java.util.Scanner;

public class CommandUi implements Ui{
	Scanner scan = new Scanner(System.in);
	public CommandUi(){
		GameLogic logic = new GameLogic(this);
	}
	public void setMessage(String message){
		System.out.print(message);
	}
	public String getResponse(){
		String response = scan.nextLine();
		return response;
	}
	public void displayHand(String name, Card[] hand, int value){
		System.out.println(name + ":");
		for(Card a : hand){
			System.out.print(a.print() + " ");
		}
		System.out.println("::" + value);
	}
	public int getWager(){
		int wager = scan.nextInt();
		return wager;
	}
}
