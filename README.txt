# Blackjack Game

This is a console-based implementation of the classic card game Blackjack, developed in Java. The game allows players to play against the computer dealer and aims to reach a hand value as close to 21 as possible without exceeding it.

## Game Rules
1. The game is played with a standard deck of 52 cards.
2. Numbered cards (2-10) are worth their face value, face cards (Jack, Queen, King) are worth 10, and the Ace can be worth either 1 or 11, depending on the value of other cards in the hand.
3. There is only 1 player and 1 dealer
4. At the beginning of each round, the player and the dealer are dealt two cards each. The player's cards are visible, but only one of the dealer's cards is visible to the player.
5. The player plays first and has two options:
   - **Hit**: Request an additional card to improve the hand's value.
   - **Stand**: Decide to stop receiving cards and end their turn.
6. If the player's hand exceeds 21, they go "bust," and the dealer wins the round automatically.
7. After the player's turn, the dealer plays. The dealer must follow a fixed strategy: hit until their hand value is 17 or higher.
8. If the dealer's hand exceeds 21, the player wins the round.
9. If neither the player nor the dealer busts, the hand with the highest value, not exceeding 21, wins the round. If both hands have the same value, it is a tie.
10. The game continues with new rounds until the player decides to quit.

## How to Play
1. The game is played in the console/terminal.
2. Run the `Application.java` file to start the game.
3. Follow the on-screen instructions to play.
4. Use the keyboard to enter your choices (e.g., '1' for hit, '2' for stand).
5. The game will display the current state of the game and the outcome of each round.
6. At the end of each round, you can choose to continue playing or quit the game.
- To quit the game, enter '-1'

## Implementation Details
The game is developed using Java and follows object-oriented principles. Here is an overview of the main classes and their responsibilities:

- `Card`: Represents a playing card with a rank and a suit.
- `Deck`: Manages the deck of cards, including shuffling and dealing cards.
- `Player`: Manages the player's actions and interacts with the user.
- `Dealer`: Manages the dealer's actions and implements the dealer's strategy.
- - Inherits from the Player class
- `Table`: Simulates a table of BlackJack with 1 player and 1 dealer, including managing rounds and displaying the game state.
- `Application`: Runs the program

## Requirements
- Java Development Kit (JDK) version 8 or later.

## Usage
1. Download or clone the repository to your local machine.
2. Compile the Java files using the command: `javac Application.java`.
3. Run the game using the command: `java Application`.

## Future Improvements
- Implement a graphical user interface (GUI) version of the game.
- Add support for multiple players.
- Include more advanced gameplay options, such as splitting pairs and doubling down.
- Implement a scoring system and leaderboard.
- Improve error handling and input validation.

## Acknowledgments
This game was developed with supervision from Dr. Almond of West Virginia Univeristy of Parkersburg as a console-based project for learning purposes and was inspired by the popular casino game Blackjack. The rules and gameplay were based on the traditional rules of Blackjack.
