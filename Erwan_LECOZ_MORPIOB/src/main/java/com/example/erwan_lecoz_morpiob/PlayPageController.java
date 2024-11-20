package com.example.erwan_lecoz_morpiob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayPageController {

    @FXML
    private TextField joueurTwoTextField;

    @FXML
    private TextField joueurOneTextField;

    @FXML
    private Label winnerLabel;

    @FXML
    private Button jouerButtonLabel;

    private Stage modalWindow;


    @FXML
    void jouerGameButton(ActionEvent event) {
        callController();
        modalWindow.show();
        jeu.afficherWhoPlay();
        Stage stage = (Stage) jouerButtonLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void menuGameButton(ActionEvent event) {
        Stage stage = (Stage) jouerButtonLabel.getScene().getWindow();
        stage.close();
    }

    public void setGameWindow(Stage modalWindow) {
        this.modalWindow=modalWindow;
    }
    private GameController jeu;
    public void setController(GameController jeu) {
        this.jeu = jeu;
    }
    private WhoPlayController whoplay;
    public void setControllerWhoPlay(WhoPlayController whoplay) {
        this.whoplay = whoplay;
    }

    public void callController() {
        if (jeu != null) {
            String joueurOneText = joueurOneTextField.getText();
            String joueurTwoText = joueurTwoTextField.getText();
            if (joueurOneText.isEmpty()){
                if (joueurTwoText.isEmpty()){
                    jeu.reciveDataPlay("joueur 1","joueur 2");
                    whoplay.reciveDataPlay("joueur 1","joueur 2");
                }
                else {
                    jeu.reciveDataPlay("joueur 1", joueurTwoTextField.getText());
                    whoplay.reciveDataPlay("joueur 1", joueurTwoTextField.getText());
                }
            }
            else if(joueurTwoText.isEmpty()){
                jeu.reciveDataPlay(joueurOneTextField.getText(),"joueur 2");
                whoplay.reciveDataPlay(joueurOneTextField.getText(),"joueur 2");
            }
            else{
                jeu.reciveDataPlay(joueurOneTextField.getText(),joueurTwoTextField.getText());
                whoplay.reciveDataPlay(joueurOneTextField.getText(),joueurTwoTextField.getText());
            }
        }
    }
}
