package ntnu.idatt2003;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  @Test
  void deckHas52CardsInitially() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getCardCount());
  }

  @Test
  void deckContainsAllSuitsAndFaces() {
    DeckOfCards deck = new DeckOfCards();
    for (char suit : Card.suits) {
      for (int face = 1; face <= 13; face++) {
        assertTrue(deck.getCards().contains(new Card(suit, face)));
      }
    }
  }

  @Test
  void dealValidHand() {
    DeckOfCards deck = new DeckOfCards();
    List<Card> hand = deck.dealHand(5);
    assertEquals(5, hand.size());
  }

  @Test
  void dealHandThrowsExceptionForInvalidNumber() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
  }

  @Test
  void getCardByIndex() {
    DeckOfCards deck = new DeckOfCards();
    Card card = deck.getCard(0);
    assertNotNull(card);
  }

  @Test
  void getCardThrowsExceptionForInvalidIndex() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.getCard(52));
    assertThrows(IllegalArgumentException.class, () -> deck.getCard(-1));
  }
}