interface Ui{
	public void setMessage(String message);
	public String getResponse();
	public void displayHand(String name, Card[] hand, int value);
	public int getWager();
	public void displayPot(int pot);
}
