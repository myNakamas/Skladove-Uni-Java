package Controllers;

import Services.UserService;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.SceneOperator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AccController implements Initializable {

    private User ACCuser;
    @FXML
    private TextField usrnm;
    @FXML
    private TextField pwd;
    @FXML
    private ComboBox <String> type;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type.getItems().addAll("Admin", "Agent", "Owner");
    }

    public void setACCuser(User ACCuser) {
        this.ACCuser = ACCuser;
        usrnm.setText(ACCuser.getUsername());
        pwd.setText(ACCuser.getPassword());
        type.getSelectionModel().select(ACCuser.getType());
    }

    public void SetAcc(ActionEvent actionEvent)
    {
        UserService userService = new UserService();
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        if(ACCuser == null)
        {
            ACCuser = new User();
            ACCuser.setUsername(usrnm.getText());
            ACCuser.setPassword(pwd.getText());
            ACCuser.setType(type.getSelectionModel().getSelectedIndex());
            ACCuser.setRating(0);

            if(userService.findByUsername("username",ACCuser.getUsername()) == null)
            userService.persist(ACCuser);
            primaryStage.getOnCloseRequest().handle(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            primaryStage.close();
        }
        else
            {
                ACCuser.setUsername(usrnm.getText());
                ACCuser.setPassword(pwd.getText());
                ACCuser.setType(type.getSelectionModel().getSelectedIndex());
                ACCuser.setRating(0);
                userService.update(ACCuser);
                primaryStage.getOnCloseRequest().handle(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
                primaryStage.close();
        }
    }
}

