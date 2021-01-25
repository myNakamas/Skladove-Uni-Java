import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.fxml.FXMLLoader;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("registration_form.fxml"));
//            primaryStage.setTitle("Registration Form FXML Application");
//            primaryStage.setScene(new Scene(root, 800, 500));
//            primaryStage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("works");
    }

    public static void main(String[] args) {
        launch(args);
    }
}