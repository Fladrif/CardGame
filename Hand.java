public class Hand{
	Card[] hand;
	public Hand(){
		hand = new Card[0];
	}
	public void addCard(Card card){
		Card[] temp = new Card[hand.length + 1];
		for(int i = 0; i < hand.length; i++){
			temp[i] = hand[i];
		}
		temp[hand.length] = card;
		hand = temp;
	}
	public Card[] showHand(){
		return hand;
	}
	public int handSize(){
		return hand.length;
	}
}
