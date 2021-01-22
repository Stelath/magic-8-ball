/**
 * An application that displays a Magic 8 Ball on the user's screen that
 * they can use by pressing a shake button
 *
 * @author Alex Korte
 * @version 1/21/2021
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MagicBall extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set Title of Window
        primaryStage.setTitle("Magic 8 Ball");

        // Create array to hold all Magic 8 Ball Images
        Image[] magicBallImages = {new Image("/images/BallDefault.png"), new Image("/images/BallYes.png"),
                new Image("/images/BallYes2.png"), new Image("/images/BallNo.png"),
                new Image("/images/BallNoIdea.png"), new Image("/images/BallNoIdea.png")};

        // Create JavaFX elements
        ImageView magicBallImage = new ImageView(magicBallImages[0]);
        Button shakeBallButton = new Button("Shake");

        // Event Handlers
        EventHandler<ActionEvent> fortuneButtonEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
                magicBallImage.setImage(magicBallImages[(int)(Math.random() * 6) + 1]);
            }
        };

        // When button is pressed
        shakeBallButton.setOnAction(fortuneButtonEvent);

        VBox vBox = new VBox();
        vBox.setSpacing(30);

        // Add JavaFX elements to VBox layout
        vBox.getChildren().add(magicBallImage);
        vBox.getChildren().add(shakeBallButton);

        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
