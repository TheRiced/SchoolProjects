package ntnu.idatt2003;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets; // Correct import
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameGUI extends Application {
  private final DeckOfCards deck = new DeckOfCards();
  private List<Card> currentHand = new ArrayList<>();
  private Label handLabel = new Label("Hand: ");
  private Label resultLabel = new Label();

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

    layout.getChildren().addAll(handLabel, dealButton, checkButton, resultLabel);

    Scene scene = new Scene(layout, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card Game");
    primaryStage.show();
  }

  private void dealHand() {
    currentHand = deck.dealHand(5);
    handLabel.setText("Hand: " + currentHand);
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

  private void styleButton(Button button) {
    button.setStyle("-fx-font-size: 14px; -fx-background-color: rgba(134,188,26,0.53); -fx-text-fill: white;");
    button.setPadding(new Insets(10, 20, 10, 20));
  }

  public static void main(String[] args) {
    launch(args);
  }
}