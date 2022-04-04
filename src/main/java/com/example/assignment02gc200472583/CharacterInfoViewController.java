package com.example.assignment02gc200472583;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterInfoViewController {

    @FXML
    private Label familyLabel;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label characterNameLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label titleLabel;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "character-explorer-view.fxml", -1);
    }

    private Character character;

    public void loadCharacterDetails(int id, ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        //System.out.println(id);
        character = APIUtility.getCharacterInfo(id);

        // to change the window title and favicon
        stage.setTitle(character.getFirstName());

        // to change all the labels and image
        characterNameLabel.setText(character.getFullName());
        firstNameLabel.setText(character.getFirstName());
        lastNameLabel.setText(character.getLastName());
        fullNameLabel.setText(character.getFullName());
        titleLabel.setText(character.getTitle());
        familyLabel.setText(character.getFamily());

        try {
            imageView.setImage(new Image(character.getImageUrl()));
        }
        catch (IllegalArgumentException e)
        {
            imageView.setImage(new Image("https://www.pngplay.com/wp-content/uploads/12/Bugs-Bunny-No-PNG-Photo-Image.png"));
        }
    }
}
