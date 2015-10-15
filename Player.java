public class Player{
	String name;
	int id;
	int wager, total;
	public Player(String who, int num){
		name = who;
		id = num;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public void buyIn(int amount){
		total = amount;
	}
	public boolean setWager(int wage){
		if(wage > total){
			return false;
		} else {
			wager = wage;
			total -= wager;
			return true;
		}
	}
	public int getWager(){
		return wager;
	}
	public int getTotal(){
		return total;
	}
}
