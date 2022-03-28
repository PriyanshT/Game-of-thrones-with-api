package com.example.assignment02gc200472583;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CharacterExplorerController implements Initializable {

    @FXML
    private Button getDetailsButton;

    @FXML
    private ImageView imageView;

    @FXML
    private ChoiceBox<Character> searchChoiceBox;

    @FXML
    void getDetails(ActionEvent event) {

    }

    @FXML
    void selectCharacter(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApiResponse apiResponse = APIUtility.getCharactersFromThronesAPI();

        searchChoiceBox.getItems().addAll(apiResponse.getCharacters());

        searchChoiceBox.setOnAction((event) -> {
            Character sourceCharacter = searchChoiceBox.getValue();
                imageView.setImage(new Image(sourceCharacter.getImageUrl()));
        });
    }
}
