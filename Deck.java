import java.util.Random;

public class Deck {
	private Card[] card; // arrays of all the cards in the deck
	private int total;// total number of cards in the deck

	// constructor with 1 deck, no shuffling
	public Deck() {
		this(1, false);
	}

	public Deck(int decks, boolean shuf) {
		this.total = decks * 52;
		this.card = new Card[this.total];
		int count = 0;
		for (int x = 0; x < decks; x++) {
			for (int y = 0; y < 4; y++) {
				for (int z = 1; z <= 13; z++) {
					this.card[count] = new Card(Card.Suit.values()[y], z);
					count++;
				}
			}
		}
		if (shuf) {
			this.shuffleDeck();// shuffles deck if deck needs shuffling
		}
	}

	// randomizer to simulate shuffling of cards
	public void shuffleDeck() {

		Random x = new Random();// random number generator
		Card n;
		int y;
		for (int i = 0; i < this.total; i++) {
			y = x.nextInt(this.total);
			n = this.card[i];
			this.card[i] = this.card[y];
			this.card[y] = n;
		}
	}

	// deals card on the top of the deck
	public Card nextDeal() {
		// gets first card, top of the deck
		Card first = this.card[0];
		for (int x = 1; x < this.total; x++) {
			this.card[x - 1] = this.card[x];
		}
		this.card[this.total - 1] = null;
		this.total--;
		return first;
	}

	// prints the first card in the deck
	// int number is the top of deck to print
	public void print(int number) {
		for (int c = 0; c < number; c++) {
			System.out.printf("%3d/%d %s\n", c + 1, this.total,
					this.card[c].toString());
		}
		System.out.printf("\t[%d others]\n", this.total - number);
	}
}