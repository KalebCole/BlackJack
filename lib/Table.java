package lib;

import java.util.Scanner;

public class Table {
    private Player player;
    private Dealer dealer;
    private int pot;
    private Scanner sc = new Scanner(System.in);


    /**
     * No-arg constructor for the table of the BlackJack game
     */
    public Table(){
        this.player = new Player();
        this.dealer = new Dealer(player.getStash()*5);
    }
    /**
     * 3-arg constructor for the table of the BlackJack game
     * @param player is the user
     * @param dealer is the dealer of the game
     * @param pot is the pot of the table
     */
    public Table(Player player, Dealer dealer, int pot){
        this.player = player;
        this.dealer = dealer;
        dealer.setStash(player.getStash()*5); //give dealer 5x the money of the player        
    }

    /**
     * Getter for player var
     * @return player
     */
    public Player getPlayer(){
        return player;
    }
    /**
     * Setter for player var
     * @param player of the game
     */
    public void setPlayer(Player player){
        this.player = player;
    }
    /**
     * Getter for dealer var
     * @return dealer
     */
    public Dealer getDealer(){
        return dealer;
    }
    /**
     * Setter for dealer var
     * @param dealer of the game
     */
    public void setDealer(Dealer dealer){
        this.dealer = dealer;
    }
    /**
     * Getter for the pot of the game
     * @return pot
     */
    public int getPot(){
        return pot;
    }
    /**
     * Setter for the pot of the game
     * @param pot on the table
     */
    public void setPot(int pot){
        this.pot = pot;
    }


    public int getStashes(){
        int stash = 0;
        do{
            System.out.print("Enter the money you brought to the casino: ");
            try {
                stash = sc.nextInt();
                if(stash<0) System.out.println("Can't have negative money");
            } catch (Exception e) {
                System.out.println("Invalid amount");
                stash = -1;
            }
            
        } while(stash < 0);
        return stash;
    }
    /**
     * Using the bet from the player, deduct from their stash and add to the pot
     * @param bet the amount the player puts down
     */
    public void setBet(int bet){
        if(player.getStash()>bet){
            player.setStash(player.getStash() - bet);
            setPot(getPot() + bet);
        }
        else{
            System.out.println("Going all in!");
            setPot(getPot()+player.getStash());
            player.setStash(0);            
        }
    }
    /**
     * Gets the bet from the player and returns it
     * @return the player's bet
     */
    public int getBets(){
        int bet = 0;
        do{
            System.out.print("Please place your bet(up to $"+ player.getStash()+", enter -1 to exit the game): ");
            try {
                bet = sc.nextInt();
                if(bet>player.getStash()) System.out.println("you're too broke for that");
                else if(bet == -1){
                    break;
                }
                else if(bet<0) System.out.println("you can't bet a negative amount");
            } catch (Exception e) {
               System.out.println("Invalid bet");
               bet = -10; //bet is invalid, run through loop again
            }
            
           
        }while(bet > player.getStash() || bet < 0); 
        return bet;
    }

    /**
     * Determines the winner of the game
     *
     */
    public void scoreGame(int bet){
        System.out.println("_____________________\n"+player.toString());
        System.out.println(dealer.toString());
        if(player.scoreHand()> 21){
            System.out.println("You busted!");
            dealer.setStash(dealer.getStash()+this.pot);
        }
        else if(player.scoreHand() == 21 && player.scoreHand() > dealer.scoreHand()){
            System.out.println("You win!");
            player.setStash(player.getStash()+this.pot);
        }
        else if(player.scoreHand() == dealer.scoreHand()){
            System.out.println("Push");
            player.setStash(player.getStash()+bet);
            dealer.setStash(dealer.getStash()+this.pot-bet);
        }
        else if(dealer.scoreHand() > player.scoreHand() && dealer.scoreHand() <=21){
            System.out.println("Dealer wins!");
            dealer.setStash(dealer.getStash()+this.pot);
        }
        else{
            System.out.println("Dealer busted, You win!");
            player.setStash(player.getStash()+this.pot);
        }
        this.pot = 0;
        System.out.println("_____________________\n");
    }


    /**
     * Method for Game Logic
     * 
     */
    public void play(){
        int stash = getStashes();
        player.setStash(stash);
        dealer.setStash(stash*5);
        boolean exit = false;
        while(!exit){
            //reset the scores & hands
            dealer.resetDeck();
            player.clearHand();
            dealer.clearHand();
            int bet = getBets(); 
            if(bet == -1) {//if user enters -1, exit game
                exit = true; 
                return;
            }
            setBet(bet); //update player stash and the pot with the current bet

            if(dealer.getStash() > bet){
                setPot(getPot()+bet);
                dealer.setStash(dealer.getStash()-bet); //if the dealer can match, adjust their stash and double the pot
            }
            else{ // dealer has just enough funds or doesn't have the funds to match the bet
                System.out.println("The dealer is going all in");
                setPot(getPot()+dealer.getStash());
                dealer.setStash(0);            
            }

            //onto the logic of the game
            for (int i = 0; i < 2; i++) {
                Card card = dealer.deal();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.printf("Player receives: %d of %s\n", card.getValue(), card.getSuit());
                player.receiveCard(card, true);
                Card card2 = dealer.deal();
            if(i==0){
                dealer.receiveCard(card2, false); //first card for dealer is hidden
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Dealer receives: ?");  
            } 
            else{
                dealer.receiveCard(card2, true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.printf("Dealer receives: %d of %s\n", card.getValue(), card.getSuit());
            } 
            }
            System.out.println("\n"+player.toString() + "\n" + dealer.toString()+ "\n");
        

            int hitOrStay = 0;
            if(player.scoreHand() == 21){
                System.out.println("You got a BlackJack!");
            }
            else if(dealer.scoreHand() == 21){
                System.out.println("Dealer got a BlackJack!");
            }
            else{
                //ask the player if they want to hit or stay
                do{
                System.out.print("Hit or Stay? (\"1\" to hit or \"2\" to stay): ");
                hitOrStay = sc.nextInt();
                if(hitOrStay == 1){
                    Card card = dealer.deal();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("Player receives: %d of %s\n", card.getValue(), card.getSuit());
                    player.receiveCard(card, true);
                    System.out.println(player.toString());
                    
                    if(player.scoreHand() > 21){ 
                        System.out.println("You busted!");
                        break;
                    }
                }
                else if (hitOrStay!=1 && hitOrStay!=2){ //invalid answer, ask the question again
                    System.out.println("invalid");
                }
                }while(hitOrStay==1 && hitOrStay!=2 && player.scoreHand() <= 21); //while they choose to hit and score is less than 21

                if(hitOrStay == 2){ //if they stay
                    dealer.showAllCards();
                    while(dealer.scoreHand() <= 17){ //add to the dealer's hand until it becomes greater than 17
                    Card card = dealer.deal();
                    System.out.printf("Dealer receives:  %d of %s\n", card.getValue(), card.getSuit());
                    dealer.receiveCard(card, true); 
                    System.out.println("Dealer Score: "+dealer.scoreHand());
                    }
                }
                player.showAllCards();
                dealer.showAllCards();
                player.printAllCards();
                dealer.printAllCards();
            }
            scoreGame(bet);
    }
        
    }

    


}
