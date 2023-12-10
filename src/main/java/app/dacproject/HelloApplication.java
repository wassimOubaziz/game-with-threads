package app.dacproject;

import app.dacproject.classes.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Front Back FootBall Game!");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            Player.gameOverOver = true;
            Platform.exit();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}