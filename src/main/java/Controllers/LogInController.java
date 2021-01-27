package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    public TextField username;
    public PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void login(ActionEvent actionEvent) {
        System.out.println(username.getText());
    }
}
