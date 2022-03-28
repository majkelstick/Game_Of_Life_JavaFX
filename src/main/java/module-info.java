module com.gol.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.gol.gameoflife to javafx.fxml;
    exports com.gol.gameoflife;
    exports com.gol.gameoflife.controller;
    opens com.gol.gameoflife.controller to javafx.fxml;
    exports com.gol.gameoflife.model;
    opens com.gol.gameoflife.model to javafx.fxml;
    exports com.gol.gameoflife.view;
    opens com.gol.gameoflife.view to javafx.fxml;
}