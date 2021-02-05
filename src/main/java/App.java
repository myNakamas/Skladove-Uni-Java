import Services.UserService;
import entities.User;
import javafx.application.Application;
import javafx.stage.Stage;
import util.SceneOperator;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            SceneOperator.setup(primaryStage);
            SceneOperator.setScene(this.getClass(), "scenes/LogIn.fxml", "Login", primaryStage);

            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setType(1);
            user.setRating(0);

            UserService userService = new UserService();
            userService.persist(user);


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}