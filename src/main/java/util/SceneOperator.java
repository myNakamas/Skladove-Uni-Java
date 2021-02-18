package util;

import Controllers.LogInController;
import entities.User;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

    public static void setScene(Class aClass, String scene, String title, Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(aClass.getClassLoader().getResource(scene)));
            Scene s = new Scene(root);
            primaryStage.setTitle(title);
            primaryStage.setScene(s);
            primaryStage.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void setup(Stage primaryStage) {
        HibernateUtil.getSessionFactory().openSession();
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.getIcons().add(new Image("images/house.png"));
    }
}
