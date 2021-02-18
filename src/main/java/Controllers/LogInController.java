package Controllers;

import Services.UserService;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.SceneOperator;

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
        List<User> all =  userService.findAll();
        for(User i: all){
            if(i.getUsername().equals(username.getText())&&i.getPassword().equals(password.getText()))
            {
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                SceneOperator.setUser(i);
                switch(i.getType())
                {
                    case 1: SceneOperator.setScene(this.getClass(),"scenes/AdminScene.fxml", "Admin", primaryStage); break;
                    case 2: SceneOperator.setScene(this.getClass(), "scenes/AgentScene.fxml", "Agent", primaryStage);  break;
                    case 3: SceneOperator.setScene(this.getClass(), "scenes/OwnerScene.fxml", "Owner", primaryStage); break;
                }
            }
            else {
                System.out.println("Wrong username or password");
            }
        }
    }
}
