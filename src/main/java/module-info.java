module Skladove {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    opens App.Controllers to javafx.fxml;

    opens App;

}
