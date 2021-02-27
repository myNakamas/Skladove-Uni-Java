package util;

import Controllers.LogInController;
import Services.UserService;
import entities.User;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public final class SceneOperator {

    private static User CurUser;

    public static User getUser() {
        return CurUser;
    }

    public static void setUser(User user) {
        CurUser = user;
    }

    public static Object setScene(Class aClass, String scene, String title, Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(aClass.getClassLoader().getResource(scene)));
            Parent root = loader.load();
            Scene s = new Scene(root);
            primaryStage.setTitle(title);
            primaryStage.setScene(s);
            primaryStage.show();


            return loader.getController();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object childScene(Class aClass, String scene, String title,Stage ChildStage){
        ChildStage.initModality(Modality.APPLICATION_MODAL);
        return setScene(aClass,scene, title, ChildStage);
    }

    public static void setup(Stage primaryStage) {
        HibernateUtil.getSessionFactory().openSession();
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.getIcons().add(new Image("images/house.png"));

        UserService userService = new UserService();

        if(userService.findAll().isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setType(0);
            user.setRating(0);
            userService.persist(user);

            User user2 = new User();
            user2.setUsername("agent");
            user2.setPassword("agent");
            user2.setType(1);
            user2.setRating(0);
            userService.persist(user2);
        }
    }

}
