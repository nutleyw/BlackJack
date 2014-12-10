public class Player {

	private String name;// player name
	private boolean donePlaying = false;
	private boolean isStaying = false;
	private int money=100;
	private int bet;
	private Card[] hand = new Card[10];// cards in hand
	private int numberOfCards;// amount of cards in hand

	// constructor for player
	public Player(String x) {
		this.name = x;
		this.noCards();// no cards in the players hand
	}

	// reset the player's hand
	public void noCards() {
		for (int i = 0; i < 10; i++) {
			this.hand[i] = null;
		}
		this.numberOfCards = 0;
	}

	// adds a card to player's hand
	public boolean addCard(Card c) // c is the card to be added
	{
		// prints an error if already reached max cards
		if (this.numberOfCards == 10) {
			System.err.printf("%s's already has 10 cards.; "
					+ "no more cards can be added\n", this.name);
			System.exit(1);
		}
		// puts new card in next open slot, increments number of cards
		this.hand[this.numberOfCards] = c;
		this.numberOfCards++;
		return (this.getSum() <= 21);
	}

	public int getSum()// gets the sum of the cards in the players hand
	{
		int valOfHand = 0;
		int cardNumber;
		int totalAces = 0;
		for (int c = 0; c < this.numberOfCards; c++) {
			// gets number value for current card
			cardNumber = this.hand[c].getVal();
			if (cardNumber == 1) // if ace
			{
				totalAces++;
				valOfHand += 11;
			} else if (cardNumber > 10)// if face card
			{
				valOfHand += 10;
			} else {
				valOfHand += cardNumber;
			}
		}
		// if hand value goes over 21 set value of aces to 1
		while (valOfHand > 21 && totalAces > 0) {
			valOfHand -= 10;
			totalAces--;
		}
		return valOfHand;
	}

	// prints card in player's hand
	public void print(boolean dealerFirstCard)// whether to show card or keep it
												// hidden
	{
		System.out.printf("%s's cards:\n", this.name);
		for (int i = 0; i < this.numberOfCards; i++) {
			if (i == 0 && !dealerFirstCard) {
				System.out.println("[?]");
			} else {
				System.out.println(this.hand[i].toString());
			}
		}
	}
	public int getMoney()
	{
		return money;
	}
	public void winMoney(){
		
		money+=bet;
		
		bet=0;//sets the bet back to zero for the next round
	}
	public void loseMoney(){
		money-=bet;
		
		bet=0;//sets the bet back to zero for the next round
	}
	
	public void setBet(int b){
		bet = b;
	}
	public int getBet()
	{
		return bet;
	}
	
	public boolean isDonePlaying() {
		return donePlaying;
	}
	
	public void setDonePlaying( boolean done ){
		donePlaying = done;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isStaying(){
		return isStaying;
	}
	public void setIsStaying( boolean stay ){
		isStaying = stay;
		
	}
}