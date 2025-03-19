package ntnu.idatt2003;

import java.util.List;

/**
 *A container that holds Card objects
 */

public interface CardContainer {
    /**
     * retives the count of cards
     * @return the number of cards in the container
     */
    int getCardCount();
    /**
     * retrieves a card from the container
     * @param index the index of the card to retrieve
     * @return the card at the given index
     */
    Card getCard(int index);
    /**
     * retrieves a hand of cards from the container
     * @return a list of cards representing the hand
     */
    List<Card> getCards();
}