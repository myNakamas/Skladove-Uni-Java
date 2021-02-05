import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.HibernateUtil;

import java.io.IOException;
import java.util.Objects;

public class SceneLoader {
    public static void changeScene(String sceneLocation, Stage primaryStage, String title) throws IOException {
    HibernateUtil.getSessionFactory().openSession();
    Parent root = FXMLLoader.load(Objects.requireNonNull(SceneLoader.class.getClassLoader().getResource(sceneLocation)));
    Scene s = new Scene(root);
    primaryStage.setTitle("Storage");
    primaryStage.setScene(s);
    primaryStage.show();
    primaryStage.getIcons().add(new Image("images/house.png"));

}
    public static void setTerminateOnClose(Stage primaryStage){
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
