package com.example.librarymanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/librarymanagement/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1315, 600);
        scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        stage.setTitle("Library System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}