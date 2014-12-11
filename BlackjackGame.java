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
		boolean done = false;
		int size;
		System.out.println("\t Blackjack \n----------------------------------\n");
		System.out.println("How many players are playing (1-4)?");
		size = keyboard.nextInt();

		System.out.println("\nEach player starts with $100\n");

		// initializes each player
		Player[] players = new Player[size];

		for (int i = 0; i < players.length; i++) {
			String name = "Player " + (i + 1);
			players[i] = new Player(name);
		}

		do {

			Player dealer = new Player("Dealer");

			for (int i = 0; i < players.length; i++) {

				// clears the players hands
				players[i].noCards();

				do {

					// asks for bet
					System.out.println("How much would " + players[i].getName()
							+ " you like to bet?");
					System.out.println(players[i].getName() + " has $"
							+ players[i].getMoney());
					players[i].setBet(keyboard.nextInt());

					if (players[i].getBet() <= 0
							|| players[i].getBet() > players[i].getMoney()) {

						System.out.println("Invalid bet. Try again");

					}

				} while (players[i].getBet() <= 0
						|| players[i].getBet() > players[i].getMoney());
			}

			// sets the number of deck and shuffles deck if true
			Deck theDeck = new Deck(3, true);

			System.out.println("\n");
			System.out.println("Cards dealt\n");

			dealer.addCard(theDeck.nextDeal());
			dealer.addCard(theDeck.nextDeal());
			dealer.print(false);
			System.out.println("----------------------------");

			// deals two cards
			for (int i = 0; i < players.length; i++) {

				players[i].addCard(theDeck.nextDeal());
				players[i].addCard(theDeck.nextDeal());
				players[i].print(true);

				System.out.println("----------------------------");
			}

			boolean dealerDone = false;

			String str = null;

			for (int i = 0; i < players.length; i++) {

				players[i].setIsStaying(false);

				while (!players[i].isStaying()) {
					System.out
							.println("\nWould "
									+ players[i].getName()
									+ " like to Hit or Stay?:(Use H for hit, S for stay) ");

					str = keyboard.next();

					System.out.println();

					// if players hits
					if (str.compareToIgnoreCase("H") == 0) {
						players[i].setIsStaying(!players[i].addCard(theDeck
								.nextDeal()));
						players[i].print(true);
					} else if (str.compareToIgnoreCase("S") == 0) {
						players[i].setIsStaying(true);
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
						dealer.print(false); // shows only one card
					} else {
						dealerDone = true;
						System.out.println("---------------------------- "
								+ "\n\n\n");
					}
				}
				System.out.println();
			}

			dealer.print(true);

			System.out.println("----------------------------\n");

			// prints final hands

			for (int i = 0; i < players.length; i++) {

				players[i].print(true);

				int playersSum = players[i].getSum();

				int dealerSum = dealer.getSum();

				System.out.println(playersSum + " " + dealerSum);

				if ((playersSum > dealerSum && playersSum <= 21)
						|| (dealerSum > 21 && playersSum <= 21)) {
					System.out.println("Player Wins!");

					players[i].winMoney();

					System.out.println("Now you have: $"
							+ players[i].getMoney() + "!");

				}
				if ((playersSum > 21)
						|| (playersSum < dealerSum && dealerSum <= 21)) {

					System.out.println("Dealer beat " + players[i].getName());
					if (playersSum > 21) {
						System.out.println("You busted");
					}

					players[i].loseMoney();

					System.out.println("Now you have: $"
							+ players[i].getMoney() + "!");
				}
				if (playersSum == dealerSum && playersSum <= 21) {

					System.out.println("It's a draw");

					System.out.println("You still have:  $"
							+ players[i].getMoney());
				}

				if (players[i].getMoney() <= 0) {

					players[i].setDonePlaying(true);

					System.out.println("Player " + (i + 1)
							+ " cannot play anymore.");

				}
				System.out.println("----------------------------\n");
			}
			for (int i = 0; i < players.length; i++) {
				if (players[i].getMoney() <= 0){
					done = true;
				}
			}

			if (done != true) {
				System.out.println("Keep Playing (P) or exit (X)");
				choice = keyboard.next();
				if (choice.compareToIgnoreCase("P") == 0) {
					done = false;
				} else if (choice.compareToIgnoreCase("X") == 0) {
					done = true;
				} else {
					System.out.println("Invalid key");
				}
			}
			
		} while (done != true);

		// closes keyboard scanner
		keyboard.close();

	}
}