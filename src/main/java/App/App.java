package App;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
//import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Group root = new Group();
            Scene s = new Scene(root, 300, 300, Color.BLACK);
            primaryStage.setTitle("test");
            primaryStage.setScene(s);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}