package Controllers;

import Services.UserService;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.SceneOperator;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;



public class AdminController implements Initializable {

    public Label AdmName;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAdmName(SceneOperator.getUser().getUsername());
    }

    public String getAdmName() {
        return AdmName.getText();
    }

    public void setAdmName(String admName) {
        AdmName.setText(AdmName.getText() + admName);
    }
    public void create(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SceneOperator.setScene(this.getClass(),"scenes/CreateAccScene.fxml", "Create Account", primaryStage);

    }


    public void storage(ActionEvent actionEvent) {


    }

}
