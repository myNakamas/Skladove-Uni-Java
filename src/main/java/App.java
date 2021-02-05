import Services.UserService;
import entities.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import util.HibernateUtil;

import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            SceneLoader.changeScene("scenes/Login.fxml",primaryStage,"Login");
            SceneLoader.setTerminateOnClose(primaryStage);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}