package ntnu.idatt2003;



import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CardHandTest {

  @Test
  void validCardHandCreation() {
    List<Card> cards = List.of(new Card('H', 5), new Card('D', 7));
    CardHand hand = new CardHand(cards);
    assertEquals(2, hand.getCardCount());
  }

  @Test
  void creatingEmptyHandThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new CardHand(List.of()));
  }

  @Test
  void sumValuesCorrectly() {
    List<Card> cards = List.of(new Card('H', 2), new Card('D', 4), new Card('S', 6));
    CardHand hand = new CardHand(cards);
    assertEquals(12, hand.sumValues());
  }

  @Test
  void detectsHeartsCorrectly() {
    List<Card> cards = List.of(new Card('H', 3), new Card('D', 5), new Card('H', 10));
    CardHand hand = new CardHand(cards);
    assertEquals("H3 H10", hand.getHearts());
  }

  @Test
  void detectsNoHearts() {
    List<Card> cards = List.of(new Card('D', 3), new Card('S', 5));
    CardHand hand = new CardHand(cards);
    assertEquals("No Hearts", hand.getHearts());
  }

  @Test
  void detectsQueenOfSpades() {
    List<Card> cards = List.of(new Card('S', 12), new Card('H', 2));
    CardHand hand = new CardHand(cards);
    assertTrue(hand.containsQueenOfSpades());
  }

  @Test
  void detectsNoQueenOfSpades() {
    List<Card> cards = List.of(new Card('S', 10), new Card('H', 2));
    CardHand hand = new CardHand(cards);
    assertFalse(hand.containsQueenOfSpades());
  }

  @Test
  void detectsFlush() {
    List<Card> cards = List.of(new Card('H', 1), new Card('H', 3), new Card('H', 5), new Card('H', 7), new Card('H', 9));
    CardHand hand = new CardHand(cards);
    assertTrue(hand.isFlush());
  }

  @Test
  void detectsNoFlush() {
    List<Card> cards = List.of(new Card('H', 1), new Card('H', 3), new Card('H', 5), new Card('D', 7), new Card('S', 9));
    CardHand hand = new CardHand(cards);
    assertFalse(hand.isFlush());
  }
}