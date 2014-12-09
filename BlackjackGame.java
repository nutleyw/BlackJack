/*
 * BlackjackGame.java
 * 
 * by Vincent Renzi, Brett Glendye, Wesley Nutley
 * 
 * 
 * 
 * 
 */
import java.util.Scanner;

public class BlackjackGame {
	public static void main(String[] args) {

		
		Scanner keyboard = new Scanner(System.in);
		
		String choice;
		boolean x;
		
		do {
			x = false;
			System.out.println("Play? (P) or exit (X)");
			choice = keyboard.next();
			if (choice.compareToIgnoreCase("X") == 0) {
				x = true;
			}
			if (choice.compareToIgnoreCase("P") == 0) {

				//sets the number of deck and shuffles deck if true
				Deck theDeck = new Deck(3, true);

				// initialized player objects
				Player playerOne = new Player("Player1");
				Player dealer = new Player("Dealer");

				// deals two cards
				playerOne.addCard(theDeck.nextDeal());
				dealer.addCard(theDeck.nextDeal());
				playerOne.addCard(theDeck.nextDeal());
				dealer.addCard(theDeck.nextDeal());

				// prints out the initial hands
				System.out.println("Cards dealt\n");
				playerOne.print(true);
				dealer.print(false);
				System.out.println("\n");

				// checks when player and dealer finish hitting
				boolean playerOneDone = false;
				boolean dealerDone = false;
				String str = null;
				while (!playerOneDone) {
					// player 1's turn
					if (!playerOneDone) {
						System.out
								.println("Would you like to Hit or Stay?:(Use H for hit, S for stay) ");
						str = keyboard.next();
						System.out.println();
						// if players hits
						if (str.compareToIgnoreCase("H") == 0) {
							playerOneDone = !playerOne.addCard(theDeck
									.nextDeal());
							playerOne.print(true);
						} else if (str.compareToIgnoreCase("S") == 0) {
							playerOneDone = true;
						} else {
							System.out.println("Invalid symbol");
							continue;
						}

					}
				}
				while (!dealerDone) {

					// dealers turn
					if (!dealerDone) {
						if (dealer.getSum() < 17) {
							System.out.println("Dealer automatically hits\n");
							dealerDone = !dealer.addCard(theDeck.nextDeal());
							dealer.print(false);
						} else {
							System.out.println("Dealer automatically stays");
							dealerDone = true;
						}
					}
					System.out.println();
				}
				// prints final hands
				playerOne.print(true);
				dealer.print(true);
				int playerOneSum = playerOne.getSum();
				int dealerSum = dealer.getSum();
				System.out.println(playerOneSum + " " + dealerSum);
				if ((playerOneSum > dealerSum && playerOneSum <= 21)
						|| (dealerSum > 21 && playerOneSum <= 21)) {
					System.out.println("Player one Wins!");
				}
				if ((playerOneSum > 21 && dealerSum <= 21)
						|| (playerOneSum < dealerSum && dealerSum <= 21)) {
					System.out.println("Dealer Wins");
				}
				if (playerOneSum == dealerSum && playerOneSum <= 21) {
					System.out.println("It's a draw");
				}
			}
		} while (x != true);
		// closes keyboard scanner
		keyboard.close();

	}
}