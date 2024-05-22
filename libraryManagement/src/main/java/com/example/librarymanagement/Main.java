package com.example.librarymanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/librarymanagement/SignUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 755, 600);
            //scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
            stage.setTitle("Library System");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}