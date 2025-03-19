package ntnu.idatt2003;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class DeckOfCards implements CardContainer{
  private final List<Card> cards = new ArrayList<>();

  public DeckOfCards() {
    for (char suit : Card.suits) {
      for (int face = 1; face <= 13; face++) {
        cards.add(new Card(suit, face));
      }
    }
  }

  public List<Card> dealHand(int n) {
    if (n < 1 || n > cards.size()) {
      throw new IllegalArgumentException("Invalid number of cards to deal");
    }
    Collections.shuffle(cards);
    return new ArrayList<>(cards.subList(0, n));
  }

  @Override
  public int getCardCount() {
    return cards.size();
  }

  @Override
  public Card getCard(int index) {
    if (index < 0 || index >= cards.size()) {
      throw new IllegalArgumentException("Invalid index");
    }
    return cards.get(index);
  }

  @Override
  public List<Card> getCards() {
    return new ArrayList<>(cards);
  }
}