

public class Card {
	
	public enum Suit {
		
		// represents each card suit 
		Clubs, Diamonds, Spades, Hearts,
		
	}
	
	private Suit suit;// one of the suits from the suit class
	private int val;// numerical value of the card jack-king are 11-13

	// card constructor
	public Card(Suit x, int y) {
		this.suit = x;// suit is the suit of the card in question
		this.val = y;// numerical value of the card
	}

	// returns the card value

	public int getVal() {
		return this.val;
	}

	/*
	 * toString gives the value of the card in the form of a string returns the
	 * string with suit of card and it's suit
	 */

	public String toString() {
		String face;
		switch (this.val) {
		case 2:
			face = "Two";
			break;
		case 3:
			face = "Three";
			break;
		case 4:
			face = "Four";
			break;
		case 5:
			face = "Five";
			break;
		case 6:
			face = "Six";
			break;
		case 7:
			face = "Seven";
			break;
		case 8:
			face = "Eight";
			break;
		case 9:
			face = "Nine";
			break;
		case 10:
			face = "Ten";
			break;
		case 11:
			face = "Jack";
			break;
		case 12:
			face = "Queen";
			break;
		case 13:
			face = "King";
			break;
		case 1:
			face = "Ace";
			break;
		default:
			face = "Error";
		}
		return face + " of " + suit.toString();
	}
}