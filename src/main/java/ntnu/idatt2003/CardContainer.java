package ntnu.idatt2003;

import java.util.List;

public interface CardContainer {
    int getCardCount();
    Card getCard(int index);
    List<Card> getCards();
}