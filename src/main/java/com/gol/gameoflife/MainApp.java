package com.gol.gameoflife;

import com.gol.gameoflife.controller.Controller;
import com.gol.gameoflife.view.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

        private ViewController view;

        private Controller controller;

        @Override
        public void start(Stage stage) throws IOException {
            controller = new Controller(20,20);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main-view.fxml"));
            VBox root = loader.load();

            view  = loader.getController();

            view.setController(controller);
            view.drawBoard();

            Scene scene = new Scene(root, 700, 600);
            stage.setTitle("Game of life");
            stage.setScene(scene);
            stage.show();

        }

        public static void main(String[] args) { launch(); }

}