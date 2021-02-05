package Controllers;

import Services.UserService;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    public TextField username;
    public PasswordField password;

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

//    public void showAccountData() {
//        UserService userService = new UserService();
//        User newUser = new User();
//        String uName = username.getText();
//        newUser.setUsername(uName);
//
//        String uPass = password.getText();
//        newUser.setPassword(uPass);
//
//        userService.persist(newUser);
//
//    }

}
