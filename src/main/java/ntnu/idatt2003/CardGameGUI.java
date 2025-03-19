package ntnu.idatt2003;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 */
public class CardGameGUI extends Application {
  private final DeckOfCards deck = new DeckOfCards();
  private List<Card> currentHand = new ArrayList<>();
  private Label handLabel = new Label("Hand: ");
  private Label resultLabel = new Label();
  private VBox handDisplay = new VBox(10);

  /**
   *
   * @param primaryStage the primary stage for this application, onto which
   * the application scene can be set.
   * Applications may create other stages, if needed, but they will not be
   * primary stages.
   */

  public void start(Stage primaryStage) {
    VBox layout = new VBox(15);
    layout.setPadding(new Insets(20));
    layout.setAlignment(Pos.CENTER);
    layout.setStyle("-fx-background-color: #455438;");

    Button dealButton = new Button("Deal Hand");
    Button checkButton = new Button("🔍 Check Hand");

    styleButton(dealButton);
    styleButton(checkButton);

    handLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
    resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

    dealButton.setOnAction(e -> dealHand());
    checkButton.setOnAction(e -> checkHand());

    layout.getChildren().addAll(handLabel, handDisplay, dealButton, checkButton, resultLabel);

    Scene scene = new Scene(layout, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card Game");
    primaryStage.show();
  }

  /**
   *
   */

  private void dealHand() {
    currentHand = deck.dealHand(5);

    handDisplay.getChildren().clear();
    handLabel.setText("Hand:");
    HBox cardBox = new HBox(10);
    cardBox.setAlignment(Pos.CENTER);

    for (Card card : currentHand) {
      HBox cardDisplay = createCardDisplay(card);
      cardBox.getChildren().add(cardDisplay);
    }

    // Update scene - Replace old UI with new card labels
    handDisplay.getChildren().add(cardBox);
  }

  /**
   *
   * @param card
   * @return
   */

  private HBox createCardDisplay(Card card) {
    ImageView suitImage = new ImageView(new Image(getClass().getResourceAsStream("/suits/" + getSuitFileName(card.getSuit()))));
    suitImage.setFitWidth(25);  // Resize suit image
    suitImage.setPreserveRatio(true);

    Label rankLabel = new Label(getFaceValue(card.getFace()));
    rankLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

    HBox cardBox = new HBox(5, suitImage, rankLabel);
    cardBox.setAlignment(Pos.CENTER);
    cardBox.setStyle(
        "-fx-border-color: black; " +
            "-fx-border-width: 2px; " +
            "-fx-background-color: white; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px; " +
            "-fx-padding: 10px;"
    );

    return cardBox;
  }

  /**
   *
   * @param suit
   * @return
   */

  private String getSuitFileName(char suit) {
    return switch (suit) {
      case 'S' -> "spades.png";
      case 'H' -> "hearts.png";
      case 'D' -> "diamonds.png";
      case 'C' -> "clubs.png";
      default -> "unknown.png";
    };
  }

  private String getFaceValue(int face) {
    return switch (face) {
      case 1 -> "A";  // Ace
      case 11 -> "J"; // Jack
      case 12 -> "Q"; // Queen
      case 13 -> "K"; // King
      default -> String.valueOf(face);
    };
  }


  private void checkHand() {
    if (currentHand.isEmpty()) {
      resultLabel.setText("No hand dealt yet");
      return;
    }
    CardHand hand = new CardHand(currentHand);
    resultLabel.setText(
        "Sum: " + hand.sumValues() + "\n" +
            "Hearts: " + hand.getHearts() + "\n" +
            "Contains Q of Spades: " + hand.containsQueenOfSpades() + "\n" +
            "Flush: " + hand.isFlush()
    );
  }

  /**
   *
   * @param button
   */

  private void styleButton(Button button) {
    button.setStyle("-fx-font-size: 14px; -fx-background-color: rgba(134,188,26,0.53); -fx-text-fill: white;");
    button.setPadding(new Insets(10, 20, 10, 20));
  }

  public static void main(String[] args) {
    launch(args);
  }
}