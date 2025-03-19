package ntnu.idatt2003;

import java.util.List;

/**
 *A container that holds Card objects
 */

public interface CardContainer {
    int getCardCount();
    Card getCard(int index);
    List<Card> getCards();
}