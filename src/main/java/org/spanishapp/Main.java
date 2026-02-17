package org.spanishapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.List;

public class Main extends Application {
    // Fields
    private Chapter currentChapter;
    private int currentIndex = 0;
    private boolean modePltoEs = true;  // true: PL -> ES; false: ES -> PL
    // UI fields
    private Label questionLabel;
    private TextField answerField;
    private Label resultLabel;
    private Button checkButton;
    private Button nextButton;
    private Button modeButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        currentChapter = new Chapter("Start");
        currentChapter.addFlashcard(new Flashcard("pies", "el perro"));
        currentChapter.addFlashcard(new Flashcard("dom", "la casa"));
        currentChapter.addFlashcard(new Flashcard("kot", "el gato"));

        questionLabel = new Label("Pytanie...");
        // setStyle

        answerField = new TextField();
        answerField.setText("Wpisz odpowiedź");

        resultLabel = new Label("");

        checkButton = new Button("Sprawdź");
        nextButton = new Button("Następne");
        nextButton.setDisable(true);
        modeButton = new Button("Tryb: PL <-> ES");

        // Buttons for actions
        checkButton.setOnAction(event -> checkAnswer());
        nextButton.setOnAction(event -> nextCard());
        modeButton.setOnAction(event -> toggleMode());

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER); // Centering
        layout.getChildren().addAll(
                modeButton,
                questionLabel,
                answerField,
                checkButton,
                resultLabel,
                nextButton
        );

        updateView();

        Scene scene = new Scene(layout, 400, 500);
        stage.setTitle("Nauka hiszpańskiego");
        stage.setScene(scene);
        stage.show();
    }

    private void updateView() {
        List<Flashcard> list = currentChapter.getFlashcards();
        if (list.isEmpty()) {
            questionLabel.setText("Brak fiszek w tym rodziale!");
            resultLabel.setText("Dodaj nowe słówka");

            // Blocking UI
            answerField.setDisable(true);
            checkButton.setDisable(true);
            nextButton.setDisable(true);

            return;
        }
        // Unblocking field in case it was blocked before
        answerField.setDisable(false);

        // Main logic
        Flashcard currentCard = list.get(currentIndex);

        if (modePltoEs) {
            questionLabel.setText(currentCard.getPolish());
        } else {
            questionLabel.setText(currentCard.getSpanish());
        }

        answerField.clear();
        resultLabel.setText("");

        checkButton.setDisable(false);
        nextButton.setDisable(true);    // Next button is not active at the beginning of the question
        answerField.requestFocus();     // Automatic focus on answer field
    }
}