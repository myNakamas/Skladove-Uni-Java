import Services.UserService;
import entities.User;
import javafx.application.Application;
import javafx.stage.Stage;
import util.SceneLoader;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            HibernateUtil.getSessionFactory().openSession();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("scenes/LogIn.fxml")));
            Scene s = new Scene(root);
            primaryStage.setTitle("Storage");
            primaryStage.setScene(s);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("images/house.png"));
            Platform.setImplicitExit(true);
            primaryStage.setOnCloseRequest((ae) -> {
                Platform.exit();
                System.exit(0);
            });

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