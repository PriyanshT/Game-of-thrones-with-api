package com.example.assignment02gc200472583;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
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
    void getDetails(ActionEvent event) throws IOException {
        int id = searchChoiceBox.getValue().getId();
        // System.out.println(id);
        SceneChanger.changeScene(event, "character-info-view.fxml", id);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetailsButton.setVisible(false);

        ApiResponse apiResponse = APIUtility.getCharactersFromThronesAPI();

        searchChoiceBox.getItems().addAll(apiResponse.getCharacters());
        imageView.setImage(new Image("https://www.pngplay.com/wp-content/uploads/12/Bugs-Bunny-No-PNG-Photo-Image.png"));

        searchChoiceBox.setOnAction((event) -> {
            getDetailsButton.setVisible(true);
            Character sourceCharacter = searchChoiceBox.getValue();
            try {
                imageView.setImage(new Image(sourceCharacter.getImageUrl()));
            }
            catch (IllegalArgumentException e)
            {
                imageView.setImage(new Image("https://www.pngplay.com/wp-content/uploads/12/Bugs-Bunny-No-PNG-Photo-Image.png"));
            }
        });
    }
}
