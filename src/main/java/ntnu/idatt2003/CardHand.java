package ntnu.idatt2003;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardHand implements CardContainer {
    private final List<Card> hand;
    
    public CardHand(List<Card> hand) {
        if (hand == null || hand.isEmpty()) {
            throw new IllegalArgumentException("Hand cannot be null or empty");
        }
        this.hand = hand;
    }
    
    public int sumValues() {
        return hand.stream().mapToInt(Card::getFace).sum();
    }
    
    public String getHearts() {
        String hearts = hand.stream()
                .filter(c -> c.getSuit() == 'H')
                .map(Card::toString)
                .collect(Collectors.joining(" "));
        return hearts.isEmpty() ? "No Hearts" : hearts;
    }
    
    public boolean containsQueenOfSpades() {
        return hand.stream().anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12);
    }
    
    public boolean isFlush() {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()))
                .values().stream().anyMatch(count -> count >= 5);
    }

    @Override
    public int getCardCount() {
        return hand.size();
    }

    @Override
    public Card getCard(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand.get(index);
    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(hand);
    }
    
}
