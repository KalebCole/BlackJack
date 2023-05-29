package lib;
/**
    The entire deck within the BlackJack game
    <p>
    This class simulates a deck of cards: including dealing the cards,
    the size of the deck, and the properties of every card
    </p>
    @author Kaleb Cole
*/

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<>();
    
    /**
     * No-arg constructor that creates a deck of cards and shuffles them
     */
    public Deck(){
        Card c = new Card(null, 0, false, null);
        for(int i = 2; i < 15; i++){
            for(Suit suit : Suit.values()){
            
            if (i < 11){
                c = new Card(suit, i, true, Integer.toString(i)); 
            }
            else if (i == 11){
                c = new Card(suit, 10, true, "Jack"); 
            }
            else if (i == 12){
                c = new Card(suit, 10, true, "Queen");
            }
            else if (i==13){
                c = new Card(suit, 10, true, "King");
            }
            else if (i==14){
                c = new Card(suit, 11, true, "Ace");
            }
            
            cards.add(c);
            }
        }
        Collections.shuffle(cards);
    }
 

    /**
     * Deals the first card and removes it from the deck
     */
    public Card deal(){ 
        return cards.remove(0);
    }

    /**
     * Gets the cards remaining in deck
     * @return the size of the deck
     */
    public int cardsLeftInDeck(){
        return cards.size(); 
    }


    @Override
    public String toString(){
        
        StringBuilder allCards = new StringBuilder(); 
        for(int i=0; i<cards.size(); i++){ 
            allCards.append(cards.get(i) + "/n"); 
        }
        return allCards.toString();
    }

}
