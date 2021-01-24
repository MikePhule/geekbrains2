package lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Chat");
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
