package HW7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Main program for a Color Game.
 * @author Anthony Wong
 * @version 1.0
 */
public class ColorGame extends Application {
    private ArrayList<String> colorcodes = new ArrayList<String>();
    private ArrayList<String> colors = new ArrayList<String>();
    private Random rand = new Random();
    private int runningscore = 0;

    /**
     * Local interface with resetmeth abstract method.
     */
    interface QuickReset {
        void resetmeth();
    }

    /**
     * Overridden start method for loading the stage.
     * @param primaryStage is the main stage
     * @throws FileNotFoundException if picture not found
     */
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        addColors();
        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        Text name = new Text();
        name.setText("Name: None");
        hbox1.setPadding(new Insets(5, 10, 5, 10));
        hbox1.getChildren().add(name);
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        TextField nameentry = new TextField("Enter your name here");
        Button nameenter = new Button("Enter");
        hbox2.setPadding(new Insets(5, 10, 5, 10));
        hbox2.getChildren().addAll(nameentry, nameenter);
        HBox hbox3 = new HBox();
        hbox3.setAlignment(Pos.CENTER);
        Text score = new Text();
        score.setText("Score: " + runningscore);
        hbox3.setPadding(new Insets(5, 10, 5, 10));
        hbox3.getChildren().add(score);
        HBox hbox4 = new HBox();
        hbox4.setAlignment(Pos.CENTER_RIGHT);
        Button question = new Button(getColor());
        question.setStyle("-fx-background-color: " + getCode());
        Button reset = new Button("Reset");
        hbox4.setPadding(new Insets(5, 10, 5, 10));
        hbox4.setSpacing(90);
        hbox4.getChildren().addAll(question, reset);
        HBox hbox5 = new HBox();
        hbox5.setAlignment(Pos.CENTER);
        Button ans1 = new Button(getColor());
        ans1.setStyle("-fx-background-color: " + getCode());
        Button ans2 = new Button(getColor());
        ans2.setStyle("-fx-background-color: " + getCode());
        Button ans3 = new Button(getColor());
        ans3.setStyle("-fx-background-color: " + getCode());
        Button none = new Button("None");
        hbox5.setPadding(new Insets(5, 50, 5, 60));
        hbox5.setSpacing(10);
        hbox5.getChildren().addAll(ans1, ans2, ans3, none);
        HBox hbox6 = new HBox();
        hbox6.setAlignment(Pos.CENTER);
        Text status = new Text();
        status.setText("Choose an answer to begin!");
        hbox6.setPadding(new Insets(5, 10, 10, 10));
        hbox6.getChildren().add(status);
        QuickReset r = () -> {
            question.setText(getColor());
            question.setStyle("-fx-background-color: " + getCode());
            ans1.setText(getColor());
            ans1.setStyle("-fx-background-color: " + getCode());
            ans2.setText(getColor());
            ans2.setStyle("-fx-background-color: " + getCode());
            ans3.setText(getColor());
            ans3.setStyle("-fx-background-color: " + getCode());
        };
        EventHandler<ActionEvent> nameconfirm = actionEvent -> name.setText("Name: " + nameentry.getText());
        EventHandler<ActionEvent> resetconfirm = actionEvent -> {
            name.setText("Name: None");
            runningscore = 0;
            score.setText("Score: " + runningscore);
            status.setText("Choose an answer to begin!");
            r.resetmeth();
        };
        EventHandler<ActionEvent> checkanswer1 = actionEvent -> {
            String color = question.getText();
            int idx = colors.indexOf(color);
            String code = colorcodes.get(idx);
            if (("-fx-background-color: " + code).equals(ans1.getStyle())) {
                runningscore++;
                score.setText("Score: " + runningscore);
                status.setText("Correct!");
            } else {
                runningscore = 0;
                score.setText("Score: " + runningscore);
                status.setText("Incorrect :(");
            }
            r.resetmeth();
        };
        EventHandler<ActionEvent> checkanswer2 = actionEvent -> {
            String color = question.getText();
            int idx = colors.indexOf(color);
            String code = colorcodes.get(idx);
            if (("-fx-background-color: " + code).equals(ans2.getStyle())) {
                runningscore++;
                score.setText("Score: " + runningscore);
                status.setText("Correct!");
            } else {
                runningscore = 0;
                score.setText("Score: " + runningscore);
                status.setText("Incorrect :(");
            }
            r.resetmeth();
        };
        EventHandler<ActionEvent> checkanswer3 = actionEvent -> {
            String color = question.getText();
            int idx = colors.indexOf(color);
            String code = colorcodes.get(idx);
            if (("-fx-background-color: " + code).equals(ans3.getStyle())) {
                runningscore++;
                score.setText("Score: " + runningscore);
                status.setText("Correct!");
            } else {
                runningscore = 0;
                score.setText("Score: " + runningscore);
                status.setText("Incorrect :(");
            }
            r.resetmeth();
        };
        EventHandler<ActionEvent> noneanswer = actionEvent -> {
            String color = question.getText();
            int idx = colors.indexOf(color);
            String code = colorcodes.get(idx);
            if (("-fx-background-color: " + code).equals(ans3.getStyle())
                     || ("-fx-background-color: " + code).equals(ans2.getStyle())
                     || ("-fx-background-color: " + code).equals(ans1.getStyle())) {
                runningscore = 0;
                score.setText("Score: " + runningscore);
                status.setText("Incorrect :(");
            } else {
                runningscore++;
                score.setText("Score: " + runningscore);
                status.setText("Correct! (none)");
            }
            r.resetmeth();
        };
        nameenter.setOnAction(nameconfirm);
        reset.setOnAction(resetconfirm);
        ans1.setOnAction(checkanswer1);
        ans2.setOnAction(checkanswer2);
        ans3.setOnAction(checkanswer3);
        none.setOnAction(noneanswer);
        VBox root = new VBox();
        root.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6);
        Scene scene = new Scene(root);
        InputStream stream = new FileInputStream("HW7/color-wheel-300x300.png");
        Image intro = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(intro);
        Button introbutton = new Button("Start Game!");
        Group startscreen = new Group(imageView);
        VBox introvbox = new VBox();
        introvbox.getChildren().addAll(startscreen, introbutton);
        introvbox.setAlignment(Pos.CENTER);
        Scene introscene = new Scene(introvbox);
        introbutton.setOnAction(e -> primaryStage.setScene(scene));
        primaryStage.setTitle("Color Game!");
        primaryStage.setScene(introscene);
        primaryStage.show();
    }

    /**
     * Determines the color of buttons.
     * @return the color
     */
    public String getColor() {
        int idx = rand.nextInt(5);
        return colors.get(idx);
    }

    /**
     * Determines color code of buttons.
     * @return the color code
     */
    public String getCode() {
        int idx = rand.nextInt(5);
        return colorcodes.get(idx);
    }

    /**
     * Initialize Colors and Colorcodes ArrayLists.
     */
    public void addColors() {
        colorcodes.add("#FF0000");
        colors.add("Red");
        colorcodes.add("#FFA500");
        colors.add("Orange");
        colorcodes.add("#FFFF00");
        colors.add("Yellow");
        colorcodes.add("#800080");
        colors.add("Purple");
        colorcodes.add("#006400");
        colors.add("Green");
    }

    /**
     * Main method for game.
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
