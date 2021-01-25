module Skladove {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    opens App.Controllers to javafx.fxml;

    opens App;

}
