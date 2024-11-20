package com.example.erwan_lecoz_morpiob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ChangeLogoController {

    private MenuController menu;
    private int joueur;
    private String logo;
    private Image image;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView imageViewActualSymbol;

    @FXML
    private Label labelJoueur;

    @FXML
    private Label symbolActuel;

    @FXML
    private Button ButtonIDSelectImageDejaChoisi;

    @FXML
    void ButtonChangeImage(ActionEvent event) {
        selectImage();
    }

    @FXML
    void ButtonClickedSymbol1(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol10(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol11(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol12(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol2(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol3(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol4(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol5(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol6(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol7(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol8(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonClickedSymbol9(ActionEvent event) {
        symbolActuel.setVisible(true);
        imageViewActualSymbol.setVisible(false);
        Button button = (Button) event.getSource();
        symbolActuel.setText(button.getText());
        logo=button.getText();
    }

    @FXML
    void ButtonSelectImageDejaChoisi(ActionEvent event) {
        symbolActuel.setVisible(false);
        imageViewActualSymbol.setVisible(true);
    }

    @FXML
    void backButton(ActionEvent event) {
        callController();
        Stage stage = (Stage) imageView.getScene().getWindow();
        stage.close();
    }

    public void reciveData(int joueur, String pseudoJoueur, String logo, Image image){
        this.joueur=joueur;
        this.logo=logo;
        this.image=image;
        if (logo!=null){
            symbolActuel.setText(logo);
        } else if (image!=null) {
            imageViewActualSymbol.setImage(image);
        }
        labelJoueur.setText(pseudoJoueur);
    }


    public void setController(MenuController menu) {
        this.menu = menu;
    }

    public void callController() {
        if (!imageViewActualSymbol.isVisible()){
            menu.reciveDataLogo(joueur,logo,image);
        }
        else{
            menu.reciveDataLogo(joueur,null,image);
        }
    }

    public void selectImage() {
        FileChooser fileChooser = new FileChooser();

        // Configurer le file chooser pour ne montrer que les fichiers image
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png", "*.gif");
        fileChooser.getExtensionFilters().add(extFilter);

        // Afficher la boîte de dialogue de sélection de fichier
        File selectedFile = fileChooser.showOpenDialog(null);

        // Vérifier si un fichier a été sélectionné
        if (selectedFile != null) {
            // Charger l'image sélectionnée dans l'ImageView
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            imageViewActualSymbol.setImage(image);
            this.image=image;
            imageViewActualSymbol.setVisible(true);
            ButtonIDSelectImageDejaChoisi.setDisable(false);
            symbolActuel.setVisible(false);
        }
    }

}
