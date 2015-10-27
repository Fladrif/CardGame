import java.util.*;

public class GameEngine{
	Deck deck;
	//Hand dealer, hand1;
	Hand playerHand;
	LinkedList<Hand> hand;
	//Declaring Player variables
	Player dealer;
	Player[] player;
	Iterator<Hand> filterate;
	//int pot, wager;
	int PRIZE_PAYOUT = 2;

	public GameEngine(){
		//pot = 50;
		//wager = 0;
		deck = new Deck();
		deck.shuffle();
		dealer = new Player("Dealer", 111);
	}

	//Needs to find and return (next?) hand from 'hand' given
	//the player's ID number
	private void makeFilterate(int playerId){
		filterate = hand.stream().filter((hands) -> hands.getPlayerId() == playerId).iterate();
	}
	
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
	/*
		Need to redo dealerPlays() so that the now defunct dealer
		calls new 'hand' variable and finds the correct hand
		that belongs to the dealer through Hand.getPlayerId()

		*May need to investiage using Predicate, or will need
		to end up writing a function that will perform the search
		and return correct index location of the hand.
	*/
	public void dealerPlays(){
		makeFilterate(0111);
		Hand handHold = filterate.next();
		while(calHand(handHold) < 17){
			handHold.addCard(deck.deal());
		}
	/*
		while(calHand(dealer) < 17){
			dealer.addCard(deck.deal());
		}
	*/
	}

	public void startGame(Player[] players){
		//taking which players are participating
		player = players;

		//checks if deck has enough cards to play (3 x # players)
		//if not, will create new deck and shuffle up
		if(deck.deckSize() < ((player.length + 1) * 3)){
			deck = new Deck();
			deck.shuffle();
		}

		//add Player's hands to linkedlist
		hand.clear();
		hand.add(new Hand(dealer.getId()));
		for(Player p : player){
			hand.add(new Hand(p.getId()));
		}

		//Dealing cards to each player
		for(int i = 0; i < 2; i++){
			ListIterator<Hand> iterate = hand.listIterator();
			while(iterate.hasNext()){
				iterate.next().addCard(deck.deal());
			}
		}

		/* Old method to instantiate hands and deal

		hand1 = new Hand();
		dealer = new Hand();
		hand1.addCard(deck.deal());
		dealer.addCard(deck.deal());
		hand1.addCard(deck.deal());
		dealer.addCard(deck.deal());
		*/
	}

	/*
		Need to fix all the deal and calculate hands so that the
		correct hand can be pulled out of the list via index

		Create 1 more function that will iterate through a player's
		hand, returning bool if there is another hand or not
	*/
	public boolean nextHand(){
		boolean flag = filterate.hasNext();
		if(flag) playerHand = filterate.next();
		return flag;
	}

	//Gets and returns first hand of given player in the list
	public Hand getHand(int playerId){
		return hand.stream().filter((hands) -> hands.getPlayerId() == playerId).toArray()[0];
	}

	public void playerDeal(){
		playerHand.addCard(deck.deal());
	}
	public int calPlayerHand(){
		return calHand(playerHand);
	}
	/*
	public int calDealerHand(){
		return calHand(playerHand);
	}
	*/
	public Card[] getPlayerHand(){
		return playerHand.showHand();
	}
	/*
	public Card[] getDealerHand(){
		return playerHand.showHand();
	}
	*/

	public boolean isPlayerWin(){
		if(calHand(playerHand) <= 21 && calHand(getHand(dealer.getId())) <= 21){
			if(calHand(playerHand) > calHand(getHand(dealer.getId()))){
				return true;
			} else {
				return false;
			}
		} else if (calHand(playerHand) <= 21 && calHand(gethand(dealer.getId())) > 21){
			return true;
		} else {
			return false;
		}
	}
	public boolean setWager(int bet, Player person){
		/*
		wager = bet;
		if(bet > pot){
			return false;
		} else {
			pot -= bet;
			return true;
		}
		*/
		
		return person.setWager(bet);
	}
	public int getPot(Player person){
		return person.getTotal();
	}
	public boolean payoutPlayer(Player person){
		//pot = pot + (PRIZE_PAYOUT * wager);
		person.setTotal(person.getTotal() + (PRIZE_PAYOUT * person.getWager()));
		return true;
	}
}
