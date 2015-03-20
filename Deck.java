public class Deck {

	Randomizer rand;
	Card[] NewDeck = new Card[52];
	public Deck(){
		for(int i = 0; i < 52; i++){
			if(i/13 == 0){
				if (i%13 == 9) NewDeck[i] = new Card("J", "s");
				else if (i%13 == 10) NewDeck[i] = new Card("Q", "s");
				else if (i%13 == 11) NewDeck[i] = new Card("K", "s");
				else if (i%13 == 12) NewDeck[i] = new Card("A", "s");
				else NewDeck[i] = new Card(Integer.toString(i % 13 + 2), "s");
			} else if(i/13 == 1){
				if (i%13 == 9) NewDeck[i] = new Card("J", "c");
				else if (i%13 == 10) NewDeck[i] = new Card("Q", "c");
				else if (i%13 == 11) NewDeck[i] = new Card("K", "c");
				else if (i%13 == 12) NewDeck[i] = new Card("A", "c");
				else NewDeck[i] = new Card(Integer.toString(i % 13 + 2), "c");
			} else if (i / 13 == 2) {
				if (i%13 == 9) NewDeck[i] = new Card("J", "d");
				else if (i%13 == 10) NewDeck[i] = new Card("Q", "d");
				else if (i%13 == 11) NewDeck[i] = new Card("K", "d");
				else if (i%13 == 12) NewDeck[i] = new Card("A", "d");
				else NewDeck[i] = new Card(Integer.toString(i % 13 + 2), "d");
			} else if (i / 13 == 3) {
				if (i%13 == 9) NewDeck[i] = new Card("J", "h");
				else if (i%13 == 10) NewDeck[i] = new Card("Q", "h");
				else if (i%13 == 11) NewDeck[i] = new Card("K", "h");
				else if (i%13 == 12) NewDeck[i] = new Card("A", "h");
				else NewDeck[i] = new Card(Integer.toString(i % 13 + 2), "h");
			}
		}
	}
	public void shuffle(){
		int times = 100;
		while(times > 0){
			Card[] shufflePile = new Card[56];
			int pile1=0, pile2=8, pile3=16, pile4=24, pile5=32, pile6=40, pile7=48;
			rand = new Randomizer(pile1, pile2, pile3, pile4, pile5, pile6, pile7);
			pile1 = rand.returnNum1();
			pile2 = rand.returnNum2();
			pile3 = rand.returnNum3();
			pile4 = rand.returnNum4();
			pile5 = rand.returnNum5();
			pile6 = rand.returnNum6();
			pile7 = rand.returnNum7();
			for(int i = 0; i < 52; i++){
				if (i % 7 == 0){
					shufflePile[pile1] = NewDeck[i];
					pile1++;
				} else if (i % 7 == 1) {
					shufflePile[pile2] = NewDeck[i];
					pile2++;
				} else if (i % 7 == 2) {
					shufflePile[pile3] = NewDeck[i];
					pile3++;
				} else if (i % 7 == 3) {
					shufflePile[pile4] = NewDeck[i];
					pile4++;
				} else if (i % 7 == 4) {
					shufflePile[pile5] = NewDeck[i];
					pile5++;
				} else if (i % 7 == 5) {
					shufflePile[pile6] = NewDeck[i];
					pile6++;
				} else if (i % 7 == 6) {
					shufflePile[pile7] = NewDeck[i];
					pile7++;
				}
			}
			int deckPos = 0;
			for(int i = 0; i < shufflePile.length; i++){
				if(shufflePile[i] != null) {
					NewDeck[deckPos] = shufflePile[i];
					deckPos++;
				}
			}
			times--;
		}
	}
	public Card deal(){
		Card card = NewDeck[0];
		Card[] subDeck = new Card[NewDeck.length - 1];
		for(int i = 0; i < subDeck.length; i++){
			subDeck[i] = NewDeck[i+1];
		}
		NewDeck = subDeck;
		return card;
	}
	public Card[] returnDeck(){
		return NewDeck;
	}
	public int deckSize(){
		return NewDeck.length;
	}
}
