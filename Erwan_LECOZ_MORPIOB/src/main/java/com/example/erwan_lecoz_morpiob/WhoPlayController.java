package com.example.erwan_lecoz_morpiob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WhoPlayController {

    @FXML
    private Button j1ButtonLabel;

    @FXML
    private Button j2ButtonLabel;

    private GameController jeu;
    public void setController(GameController jeu) {
        this.jeu = jeu;
    }

    @FXML
    void j1ButtonActivation(ActionEvent event) {
        jeu.reciveDataWhoPlay(1);
        Button btn = (Button)event.getSource();
        Stage stage = (Stage)btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void j2ButtonActivation(ActionEvent event) {
        jeu.reciveDataWhoPlay(2);
        Button btn = (Button)event.getSource();
        Stage stage = (Stage)btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void randomButtonActivation(ActionEvent event) {
        jeu.reciveDataWhoPlay(3);
        Button btn = (Button)event.getSource();
        Stage stage = (Stage)btn.getScene().getWindow();
        stage.close();
    }

    public void reciveDataPlay(String nom1, String nom2){
        j1ButtonLabel.setText(nom1);
        j2ButtonLabel.setText(nom2);
    }

}
