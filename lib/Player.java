package lib;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.Thread;

/**
 * The Player of a BlackJack game
 * <p>
 * This class simulates the actions and attributes of a player of a game of
 * BlackJack including their hand of cards, their score, their stash, and their
 * name
 * </p>
 * 
 * @author Kaleb Cole
 */

public class Player {
	public String name;
	private int stash;
	private ArrayList<Card> hand = new ArrayList<>();

	/**
	 * Default constructor
	 */
	Player() {
		this.name = "Player";
		this.stash = 500;
	}

	/**
	 * 
	 * @param name  of the player
	 * @param stash of the player
	 * @throws Exception
	 */
	Player(String name, int stash) {
		this.name = name;
		try {
			setStash(stash);
		} catch (InputMismatchException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param card     received by the player
	 * @param isFaceUp bool for if the card is shown to the player
	 */
	public void receiveCard(Card card, boolean isFaceUp) {
		if (isFaceUp)
			card.show();
		else
			card.hide();
		hand.add(card);
	}

	/**
	 * 
	 * @param stash of the player
	 * @throws Exception
	 */
	public void setStash(int stash) throws InputMismatchException {
		if (stash >= 0) {
			this.stash = stash;
		} else {
			throw new InputMismatchException();
		}
	}

	/**
	 * 
	 * @return player's stash
	 */
	public int getStash() {
		return stash;
	}

	/**
	 * remove all the cards in the hand arraylist
	 */
	public void clearHand() {
		hand.clear();
	}

	/**
	 * Adds the values of the cards in the player's hand to their score
	 * @return the player's score from their cards
	 */
	public int scoreHand() {
		int score = 0;
		//if the player has a blackjack on their first 2 cards
		if (hand.size() == 2) {
			for (int i = 0; i < 2; i++) {
				score += hand.get(i).getValue();
			}
			if (score == 21) {
				showAllCards();
				return score;
			}
		}
		//for every other case
		score = 0;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).isVisible()) {
				score += hand.get(i).getValue();
			}
		}
		if (score > 21) {
			for (int j = 0; j < hand.size(); j++) {
				// if card is an ace
				if (hand.get(j).getValue() == 11)
					score -= 10;
				if (score <= 21)
					break;
			}
		}
		return score;
	}

	/**
	 * Show all the cards in the player's hand
	 */
	public void showAllCards() {
		for (Card card : hand) {
			card.show();
		}
	}

	/**
	 * Printsa all the cards in the player's hand
	 * 
	 */
	public void printAllCards(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("\n%s's hand \n", this.name);
		for (Card card : hand) {
			System.out.printf("%d of %s\n", card.getValue(), card.getSuit());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (name + " has $" + stash + "\n Score: " + scoreHand());
	}

}
