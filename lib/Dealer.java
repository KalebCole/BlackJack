package lib;

/**
 * The Dealer within a game of BlackJack
 * 
 * <p>
 * This class simulates the actions and attributes of a dealer in a game of BlackJack including dealing cards,
 * reshuffling the deck, and the dealer's stash
 * </p>
 * @author Kaleb Cole
 */
public class Dealer extends Player{
    private Deck deck;

    /**
     * One-arg constructor for Dealer
     * @param stash Stash value of the dealer
     */
    Dealer(int stash){
        super("Dealer", stash);
        this.deck = new Deck();
    }

    /**
     * Deals the first card from the deck and removes it
     * @return the card being dealt
     */
    public Card deal(){
        return deck.deal();
    }

    /**
     * Resets the Deck to be brand new, shuffled, and full
     */
    public void resetDeck(){
        this.deck = new Deck();
    }
}