package lib;
/**
    The individual card within the BlackJack game
    <p>
    This class simulates a card and gives it the suit, value, card name,
    and if it's facing up or down properties
    </p>
    @author Kaleb Cole
*/


public class Card {
    private Suit suit;
    private int value;
    private boolean visible;
    private String name;

    /**
     * 4-arg constructor
     * @param Suit of the card
     * @param Value Value of the card
     * @param Visibility of the card
     * @param Name of the card
     */
    public Card(Suit suit, int value, boolean visible, String name){
        this.suit = suit;
        this.value = value;
        this.visible = visible;
        this.name = name;
    }

    
    /**
     * Getter method for the suit
     * @return the Suit of the card
     */
    public Suit getSuit(){
        return suit;
    }
    /**
     * Getter method for the value
     * @return the Value of the card
     */
    public int getValue(){
        return value;
    }
    /**
     * Getter method for the visibility
     * @return the visibility of the card
     */
    public boolean isVisible(){
        return visible;
    }
    /**
     * Getter method for the name
     * @return the name of the card
     */
    public String getName(){
        return name;
    }
    /**
     * Show the card properties
     * @return void, sets visibility to true
     */
    public void show(){
        visible = true;
    }
    /**
     * Hides the card properties
     * @return void, sets visibility to false
     */
    public void hide(){
        visible = false;
    }

    @Override
    public String toString(){
        if(isVisible() == true)
        return name + "of" + suit.name(); 
        else{
            return "Hidden Card"; 
        }
    }
}
