package Controllers;

import Services.UserService;
import entities.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.SceneOperator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class AdminController implements Initializable {

    @FXML
    public Label AdmName;
    @FXML
    public TableView <User> UserTable;
    @FXML
    public TableColumn <User, String> UserName;
    @FXML
    public TableColumn <User, Integer> UserType;
    @FXML
    public TableColumn <User, Integer> UserRating;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAdmName(SceneOperator.getUser().getUsername());
        UserName.setCellValueFactory(new PropertyValueFactory<>("username"));
        UserType.setCellValueFactory(new PropertyValueFactory<>("type"));
        UserRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        RefTable();
    }

    public String getAdmName() {
        return AdmName.getText();
    }

    public void setAdmName(String admName) {
        AdmName.setText(AdmName.getText() + admName);
    }

    public void create(ActionEvent actionEvent) {
        Stage ACCStage = new Stage();
        ACCStage.setOnCloseRequest(new EventHandler<WindowEvent>() {public void handle(WindowEvent we) {RefTable();}});
        SceneOperator.childScene(this.getClass(), "scenes/AccScene.fxml", "Create Account", ACCStage);
        RefTable();
    }

    public void editAcc(ActionEvent actionEvent) {
        User UtoEdit = new User();
        UtoEdit = UserTable.getSelectionModel().getSelectedItem();
        Stage ACCStage = new Stage();
        ACCStage.setOnCloseRequest(new EventHandler<WindowEvent>() {public void handle(WindowEvent we) {RefTable();}});
        if(UtoEdit != null) {
            AccController AccContrl = (AccController) SceneOperator.childScene(this.getClass(), "scenes/AccScene.fxml", "Create Account", ACCStage);
            AccContrl.setACCuser(UtoEdit);
        }
        else{
            System.out.println("Please select a user!");
        }

    }

    public void RefTable(){
        UserService US = new UserService();
        List <User> UT = US.findAll();
        UserTable.getItems().setAll(UT);
    }

    public void LogOut(ActionEvent actionEvent) {
        SceneOperator.setUser(null);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SceneOperator.setScene(this.getClass(), "scenes/LogIn.fxml", "Login", primaryStage);
    }



}
