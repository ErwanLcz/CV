package com.example.erwan_lecoz_morpiob;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class relanceController {

    int score1;
    int score2;

    private GameController jeu;

    @FXML
    private Label playerOne;

    @FXML
    private Label playerTwo;

    @FXML
    private Label scoreOne;

    @FXML
    private Label scoreTwo;

    @FXML
    private Label winnerLabel;

    @FXML
    void menuButton(ActionEvent event) {
        Stage stage = (Stage) winnerLabel.getScene().getWindow();
        stage.close();
    }

    Stage modalDialog;
    Scene sceneGame;
    public void setGameScene(Scene sceneRelance) {
        this.sceneGame = sceneRelance;
    }

    public void setStage(Stage modalWindow) {
        this.modalDialog = modalWindow;
    }

    @FXML
    void relanceGameButton(ActionEvent event) {
        callController();
        modalDialog.setScene(sceneGame);
    }

    public void reciveData(int first, int two, int winner,String pseudo1,String pseudo2){
        score1 = first;
        score2 = two;
        scoreOne.setText(String.valueOf(score1));
        scoreTwo.setText(String.valueOf(score2));
        playerOne.setText(pseudo1);
        playerTwo.setText(pseudo2);
        if (winner==0){
            winnerLabel.setText(pseudo1+" a gagné !");
        }
        else if (winner==1){
            winnerLabel.setText(pseudo2+" a gagné !");
        }
        else{
            winnerLabel.setText("Dommage égalité !");
        }
    }


    public void setController(GameController jeu) {
        this.jeu = jeu;
    }

    public void callController() {
        if (jeu != null) {
            jeu.reciveDataRelance(score1,score2);
        }
    }

    Scene scenePseudo;
    public void setScenePseudo(Scene scenepseudo) {
        this.scenePseudo = scenepseudo;
    }

    @FXML
    void changeNamesButton(ActionEvent event) {
        modalDialog.setScene(scenePseudo);
    }

}
