package Controllers;

import Services.UserService;
import entities.Sklad;
import entities.Stoka;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import util.SceneOperator;

import java.net.URL;
import java.util.ResourceBundle;

public class OwnerController implements Initializable {
    public TableView<Sklad> SkladTable;
    public TableColumn<Sklad, String> colName;  //TODO:V tablicata trqbva da slojim name
    public TableColumn<Sklad, Float> colDimentions;
    public TableColumn<Sklad, Stoka> colGoods;
    public TableColumn<Sklad, Integer> colClimate;
    public TableColumn<Sklad, String> colCategory;
    public TableColumn<Sklad,Boolean> colisUsed;
    public TableColumn<Sklad,String> colAddress;

    public PasswordField oldPass;
    public PasswordField newPass;
    public TextField newUsrnm;


    public void newSklad(ActionEvent actionEvent) {
        //TODO:nova scena za otvarqne na sklad
    }

    public void editSklad(ActionEvent actionEvent) {
        //TODO:editvane na izbran sklad (hopefully the same scene)
    }

    public void removeSklad(ActionEvent actionEvent) {
        //TODO:iztrivane na izbran sklad
    }

    public void editUser(ActionEvent actionEvent) {
        User curUser = SceneOperator.getUser();
        if(oldPass.getText().equals(curUser.getPassword()))
        {
            curUser.setUsername(newUsrnm.getText());
            curUser.setPassword(newPass.getText());
            UserService userService = new UserService();
            userService.update(curUser);
        }
    }
    //TODO:refresh funkciq za tablicata

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.newUsrnm.setText(SceneOperator.getUser().getUsername());
        //TODO:suzdavane na fabrikite za tablicata
    }
}
