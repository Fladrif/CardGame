public class Card{
	String value;
	String suit;
	public Card(String valueof, String suitof){
		value = valueof;
		suit = suitof;
	}
	public String print(){
		return (suit + value);
	}
	public String getValue(){
		return value;
	}
	public String getSuit(){
		return suit;
	}
}
