public class Shuffle {
	public static void main(String[] args) {
		int[] deck = new int[52];
		String[] suits = { "s", "h", "d", "c" };
		String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10","J", "Q", "K" };

		// This loop initializes the cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}

		// Suffles the deck
		for (int i = 0; i < deck.length; i++) {
			int index = (int) (Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		// Displays randomized cards

		for (int i = 0;i<52; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			System.out.println(rank + "" + suit);
			}
			
		
		}
	}

