package org.example.sixthlab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    public static FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("Рисовалочка");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}