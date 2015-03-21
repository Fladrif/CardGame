public class GameEngine{
	Deck deck;
	Hand dealer, hand1;
	int pot, wager;
	int PRIZE_PAYOUT = 2;
	public GameEngine(){
		pot = 50;
		wager = 0;
		deck = new Deck();
		deck.shuffle();
	}
	/*
	total = 0

	for (Card card : hand.showHand()) {
      total = total + card.getValue()
	}
	*/
	private int calHand(Hand hand){
		int total = 0, ace = 0;
		for(Card card : hand.showHand()){
			if(card.getValue().equals("2")) total += 2;
			else if(card.getValue().equals("3")) total += 3;
			else if(card.getValue().equals("4")) total += 4;
			else if(card.getValue().equals("5")) total += 5;
			else if(card.getValue().equals("6")) total += 6;
			else if(card.getValue().equals("7")) total += 7;
			else if(card.getValue().equals("8")) total += 8;
			else if(card.getValue().equals("9")) total += 9;
			else if(card.getValue().equals("A")){
				total += 1;
				ace ++;
			}
			else total += 10;
		}
		while(ace > 0){
			if((total + 10) <= 21){
				total += 10;
			}
			ace --;
		}
		return total;
	}
	public void dealerPlays(){
		while(calHand(dealer) < 17){
			dealer.addCard(deck.deal());
		}
	}
	public void startGame(){
		if(deck.deckSize() < (4*3)){
			deck = new Deck();
			deck.shuffle();
		}
		hand1 = new Hand();
		dealer = new Hand();
		//NUMBER_OF_CARDS_TO_DEAL_INITIALLY = 2
		//for (i=0; i<NUM...; i++) {
		hand1.addCard(deck.deal());
		dealer.addCard(deck.deal());
		hand1.addCard(deck.deal());
		dealer.addCard(deck.deal());
	}
	public void playerDeal(){
		hand1.addCard(deck.deal());
	}
	public int calPlayerHand(){
		return calHand(hand1);
	}
	public int calDealerHand(){
		return calHand(dealer);
	}
	public Card[] getPlayerHand(){
		return hand1.showHand();
	}
	public Card[] getDealerHand(){
		return dealer.showHand();
	}

	public boolean isPlayerWin(){
		if(calHand(hand1) <= 21 && calHand(dealer) <= 21){
			if(calHand(hand1) > calHand(dealer)){
				return true;
			} else {
				return false;
			}
		} else if (calHand(hand1) <= 21 && calHand(dealer) > 21){
			return true;
		} else {
			return false;
		}
	}
	public boolean setWager(int bet){
		wager = bet;
		if(bet > pot){
			return false;
		} else {
			pot -= bet;
			return true;
		}
	}
	public int getPot(){
		return pot;
	}
	public boolean payoutPlayer(){
		pot = pot + (PRIZE_PAYOUT * wager);
		return true;
	}
}
