import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("scenes/main.fxml")));
            Scene s = new Scene(root);
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