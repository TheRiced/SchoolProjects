package ntnu.idatt2003;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

  @Test
  void testCardCreation() {
    Card card = new Card('H', 10);
    assertEquals('H', card.getSuit());
    assertEquals(10, card.getFace());
  }

  @Test
  void invalidCardCreationThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new Card('X', 5));
    assertThrows(IllegalArgumentException.class, () -> new Card('H', 0));
    assertThrows(IllegalArgumentException.class, () -> new Card('D', 14));
  }

  @Test
  void testToString() {
    Card card = new Card('S', 1);


  }
}