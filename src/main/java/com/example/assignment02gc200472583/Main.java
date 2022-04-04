package com.example.assignment02gc200472583;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("character-explorer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Character Explorer");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/main/resources/com/example/assignment02gc200472583/favicon.png"));
        stage.show();
    }

    public static void main(String[] args) {

        launch();
        // ApiResponse apiResponse = APIUtility.getCharactersFromJSONFile("apiResponse.json");
        ApiResponse apiResponse = APIUtility.getCharactersFromThronesAPI();
    }
}