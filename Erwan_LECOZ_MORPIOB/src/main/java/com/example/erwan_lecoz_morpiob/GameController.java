package com.example.erwan_lecoz_morpiob;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.*;

import java.util.Random;

public class GameController {

    private relanceController secondaryController;

    Stage modalLeave;
    Stage modalRules;
    Stage modalWhoPlay;

    Stage modalDialog;
    String nomPlayer1;
    String nomPlayer2;
    int Player=0;
    int score1=0;
    int score2=0;
    String logo1;
    String logo2;
    String aPose;

    Border border = new Border(new javafx.scene.layout.BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY, BorderWidths.DEFAULT));
    String[][] morpion = {
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
    };

    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList( "Options","Règles", "Menu", "Quitter");
        // Ajout des éléments à la ComboBox
        comboBox.setItems(items);
        // Ajouter un gestionnaire d'événements pour le changement de sélection dans la ComboBox
        comboBox.setOnAction(event -> {
            String selectedOption = comboBox.getValue();
            if (selectedOption.equals("Règles")) {
                modalRules.showAndWait();
            }
            else if (selectedOption.equals("Quitter")) {
                modalLeave.showAndWait();
            }
            else if (selectedOption.equals("Menu")){
                Stage stage = (Stage) grillButton11.getScene().getWindow();
                stage.close();
            }
            if (!comboBox.getItems().isEmpty()) {
                comboBox.setValue(comboBox.getItems().get(0)); // Réinitialiser à la première option
            }
        });
    }

    public void afficherWhoPlay(){
        modalWhoPlay.showAndWait();
    }

    public void reciveDataLogo(String logo1, String logo2){
        this.logo1=logo1;
        this.logo2=logo2;
    }

    public void reciveDataPlay(String nom1, String nom2){
        nomPlayer1=nom1;
        nomPlayer2=nom2;
        playerOne.setText(nom1);
        playerTwo.setText(nom2);
    }

    public void reciveDataWhoPlay(int qui){
        if (qui==3){
            Random random = new Random();
            int randomNumber = random.nextInt(2) + 1;
            if (randomNumber==1){
                qui=1;
            }
            else if (randomNumber==2){
                qui=2;
            }
        }
        if (qui==1){
            Player=0;
            aPose=logo1;
            playerOne.setBorder(border);
            playerTwo.setBorder(null);
        }
        else if (qui==2){
            Player=1;
            aPose=logo2;
            playerTwo.setBorder(border);
            playerOne.setBorder(null);
        }
    }

    public void reciveDataRelance(int first, int two){
        score1 = first;
        score2 = two;
        reset(first,two);
    }

    public void setSecondaryController(relanceController secondaryController) {
        this.secondaryController = secondaryController;
    }

    public void callSecondaryControllerMethod(int gagnant) {
        if (secondaryController != null) {
            secondaryController.reciveData(score1,score2,gagnant,nomPlayer1,nomPlayer2);
        }
    }


    public void reset(int scoreFirst, int scoreeTwo){
        score1=scoreFirst;
        score2=scoreeTwo;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                morpion[i][j]=" ";
            }
        }
        grillButton11.setText("");
        grillButton11.setStyle("-fx-background-color:#80C9A7;");
        grillButton12.setText("");
        grillButton12.setStyle("-fx-background-color:#80C9A7;");
        grillButton13.setText("");
        grillButton13.setStyle("-fx-background-color:#80C9A7;");
        grillButton21.setText("");
        grillButton21.setStyle("-fx-background-color:#80C9A7;");
        grillButton22.setText("");
        grillButton22.setStyle("-fx-background-color:#80C9A7;");
        grillButton23.setText("");
        grillButton23.setStyle("-fx-background-color:#80C9A7;");
        grillButton31.setText("");
        grillButton31.setStyle("-fx-background-color:#80C9A7;");
        grillButton32.setText("");
        grillButton32.setStyle("-fx-background-color:#80C9A7;");
        grillButton33.setText("");
        grillButton33.setStyle("-fx-background-color:#80C9A7;");

    }

    public void turnPlay () {
        if (Player==0){
            Player=1;
            aPose=logo2;
            playerTwo.setBorder(border);
            playerOne.setBorder(null);
        }
        else{
            Player=0;
            aPose=logo1;
            playerOne.setBorder(border);
            playerTwo.setBorder(null);
        }
    }

    Scene sceneRelance;
    public void refresh(){
        if (verifWin()){
            if (Player==0){
                score1++;
                scoreOne.setText(String.valueOf(score1));
            }
            if (Player==1){
                score2++;
                scoreTwo.setText(String.valueOf(score2));
            }
            callSecondaryControllerMethod(Player);
            modalDialog.setScene(sceneRelance);
        }
        else if(draw()){
            callSecondaryControllerMethod(2);
            modalDialog.setScene(sceneRelance);
        }
    }

    private boolean draw() {
        boolean verifDraw=true;
        for (int i=0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (morpion[i][j]==" ") {
                    verifDraw = false;
                }
            }
        }
        return verifDraw;
    }

    public boolean verifWin(){
        if (!verifLigne()){
            if (!verifColonne()){
                if (!verifDiagonale()){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean verifLigne(){
        for (int i=0; i < 3; i++) {
            String premierElement = morpion[i][0];
            boolean memeElement = true;
            for (int j = 0; j < 3; j++) {
                if (morpion[i][j] != premierElement || morpion[i][j]==" ") {
                    memeElement = false;
                    break;
                }
            }
            if (memeElement) {
                if (i==0){
                    grillButton11.setStyle("-fx-background-color: #FCEC85;");
                    grillButton12.setStyle("-fx-background-color: #FCEC85;");
                    grillButton13.setStyle("-fx-background-color: #FCEC85;");
                }
                else if (i==1){
                    grillButton21.setStyle("-fx-background-color: #FCEC85;");
                    grillButton22.setStyle("-fx-background-color: #FCEC85;");
                    grillButton23.setStyle("-fx-background-color: #FCEC85;");
                }
                else if (i==2){
                    grillButton31.setStyle("-fx-background-color: #FCEC85;");
                    grillButton32.setStyle("-fx-background-color: #FCEC85;");
                    grillButton33.setStyle("-fx-background-color: #FCEC85;");
                }
                return true;

            }
        }
        return false;
    }

    public boolean verifColonne(){
        for (int i=0;  i < 3; i++) {
            String premierElement = morpion[0][i];
            boolean memeElement = true;
            for (int j = 0; j < 3; j++) {
                if (morpion[j][i] != premierElement || morpion[j][i]==" ") {
                    memeElement = false;
                    break;
                }
            }
            if (memeElement) {
                if (i==0){
                    grillButton11.setStyle("-fx-background-color: #FCEC85;");
                    grillButton21.setStyle("-fx-background-color: #FCEC85;");
                    grillButton31.setStyle("-fx-background-color: #FCEC85;");
                }
                else if (i==1){
                    grillButton12.setStyle("-fx-background-color: #FCEC85;");
                    grillButton22.setStyle("-fx-background-color: #FCEC85;");
                    grillButton32.setStyle("-fx-background-color: #FCEC85;");
                }
                else if (i==2){
                    grillButton13.setStyle("-fx-background-color: #FCEC85;");
                    grillButton23.setStyle("-fx-background-color: #FCEC85;");
                    grillButton33.setStyle("-fx-background-color: #FCEC85;");
                }
                return true;
            }
        }
        return false;
    }

    public boolean verifDiagonale(){
        if (morpion[1][1]!=" "){
            if (morpion[0][0]==morpion[1][1]&&morpion[0][0]==morpion[2][2]){
                grillButton11.setStyle("-fx-background-color: #FCEC85;");
                grillButton22.setStyle("-fx-background-color: #FCEC85;");
                grillButton33.setStyle("-fx-background-color: #FCEC85;");
                return true;
            }
            else if (morpion[0][2]==morpion[1][1]&&morpion[0][2]==morpion[2][0]){
                grillButton31.setStyle("-fx-background-color: #FCEC85;");
                grillButton22.setStyle("-fx-background-color: #FCEC85;");
                grillButton13.setStyle("-fx-background-color: #FCEC85;");
                return true;
            }
        }
        return false;
    }

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button grillButton11;

    @FXML
    private Button grillButton12;

    @FXML
    private Button grillButton13;

    @FXML
    private Button grillButton21;

    @FXML
    private Button grillButton22;

    @FXML
    private Button grillButton23;

    @FXML
    private Button grillButton31;

    @FXML
    private Button grillButton32;

    @FXML
    private Button grillButton33;

    @FXML
    private Label playerOne;

    @FXML
    private Label playerTwo;

    @FXML
    private Label scoreOne;

    @FXML
    private Label scoreTwo;

    @FXML
    void buttonClicked11(ActionEvent event) {
        if (morpion[0][0]==" "){
            morpion[0][0]=aPose;
            grillButton11.setText(String.valueOf(aPose));
            grillButton11.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked12(ActionEvent event) {
        if (morpion[0][1]==" "){
            morpion[0][1]=aPose;
            grillButton12.setText(String.valueOf(aPose));
            grillButton12.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked13(ActionEvent event) {
        if (morpion[0][2]==" "){
            morpion[0][2]=aPose;
            grillButton13.setText(String.valueOf(aPose));
            grillButton13.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked21(ActionEvent event) {
        if (morpion[1][0]==" "){
            morpion[1][0]=aPose;
            grillButton21.setText(String.valueOf(aPose));
            grillButton21.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked22(ActionEvent event) {
        if (morpion[1][1]==" "){
            morpion[1][1]=aPose;
            grillButton22.setText(String.valueOf(aPose));
            grillButton22.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked23(ActionEvent event) {
        if (morpion[1][2]==" "){
            morpion[1][2]=aPose;
            grillButton23.setText(String.valueOf(aPose));
            grillButton23.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked31(ActionEvent event) {
        if (morpion[2][0]==" "){
            morpion[2][0]=aPose;
            grillButton31.setText(String.valueOf(aPose));
            grillButton31.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked32(ActionEvent event) {
        if (morpion[2][1]==" "){
            morpion[2][1]=aPose;
            grillButton32.setText(String.valueOf(aPose));
            grillButton32.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    @FXML
    void buttonClicked33(ActionEvent event) {
        if (morpion[2][2]==" "){
            morpion[2][2]=aPose;
            grillButton33.setText(String.valueOf(aPose));
            grillButton33.setStyle("-fx-background-color: #D5F6C8;");
            refresh();
            turnPlay();
        }
    }

    public void setGameScene(Scene sceneRelance) {
        this.sceneRelance = sceneRelance;
    }

    public void setStage(Stage modalWindow) {
        this.modalDialog = modalWindow;
    }
}
