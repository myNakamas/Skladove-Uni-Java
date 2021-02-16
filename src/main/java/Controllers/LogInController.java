package Controllers;

import Services.UserService;
import entities.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import util.HibernateUtil;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    public TextField username;
    public PasswordField password;

    Button btn1 = new Button();
    Button btn2 = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void login(ActionEvent actionEvent) {
        UserService userService = new UserService();
      /*  List<User> all =  userService.findAll();
        System.out.println(all.get(0));*/
        String uName = username.getText();
        String uPass = password.getText();
        List<User> all =  userService.findAll();
        for (User i : all)
        {
            if(i.getUsername().equals(uName) && i.getPassword().equals(uPass))
            { System.out.println("User exists in DB"); }
            else {
                System.out.println("User does not exist in DB");
            }
        }

    }

   /* public void showAccountData() {
        UserService userService = new UserService();
        User newUser = new User();
        String uName = username.getText();
        newUser.setUsername(uName);

        String uPass = password.getText();
        newUser.setPassword(uPass);

        userService.persist(newUser);

    }*/

    public void showRegisterScene(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("scenes/AgentScene.fxml")));
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
        }
    }

}
