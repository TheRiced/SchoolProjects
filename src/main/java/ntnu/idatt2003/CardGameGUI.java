package ntnu.idatt2003;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameGUI extends Application {
  private final CardDeck deck = new CardDeck();
  private List<Card> currentHand = new ArrayList<>();
  private Label handLabel = new Label("Hand: ");
  private Label resultLabel = new Label();

  @Override
  public void start(Stage primaryStage) {
    Button dealButton = new Button("Deal Hand");
    Button checkButton = new Button("Check Hand");

    dealButton.setOnAction(e -> dealHand());
    checkButton.setOnAction(e -> checkHand());

    VBox layout = new VBox(10, handLabel, dealButton, checkButton, resultLabel);
    primaryStage.setScene(new Scene(layout, 300, 200));
    primaryStage.setTitle("Kortspill");
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

  public static void main(String[] args) {
    launch(args);
  }
}