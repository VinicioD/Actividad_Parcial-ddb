package com.example.guiltyspark;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene(scene);

        stage.sizeToScene();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}