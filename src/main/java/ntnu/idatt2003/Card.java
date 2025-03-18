package ntnu.idatt2003;

import java.util.List;

/**
 * Represents a playing card.
 */

public class Card {

  /**
   * The suit of the card.
   */
  private final char suit;

  private final int face;

  /**
   *
   */

  public static final List<Character> suits = List.of('S', 'H', 'D', 'C');

  public Card(char suit, int face) {
    if (!suits.contains(suit) || face < 1 || face > 13) {
      throw new IllegalArgumentException("Invalid card");
    }
    this.suit = suit;
    this.face = face;
  }

  /**
   * Returns the suit of the card.
   * @return the suit of the card
   */

  public char getSuit() { return suit; }

  /**
   * Returns the face value of the card.
   * @return the face value of the card
   */
  public int getFace() { return face; }

  /**
   * Returns a string representation of the card.
   * @return a string representation of the card
   */

  @Override
  public String toString() { return String.format("%c%d", suit, face); }
}

