package com.example.erwan_lecoz_morpiob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController {

    private String pseudo1="Joueur 1";
    private String pseudo2="Joueur 2";
    private Stage modalWindow;
    private Stage modalWindowLogo;
    private ChangeLogoController logoController;
    private GameController gamecontroller;
    private String logo1="O";
    private String logo2="X";

    @FXML
    private ImageView imageJ1;

    @FXML
    private ImageView imageJ2;

    @FXML
    private Label labelButtonJ1;

    @FXML
    private Label labelButtonJ2;

    @FXML
    void ButtonClicked1v1(ActionEvent event) {
        callController();
        modalWindow.show();
    }

    @FXML
    void ButtonClicked1vIA(ActionEvent event) {

    }

    @FXML
    void ButtonSymboleJ1(ActionEvent event) {
        Button button = (Button) event.getSource();
        logoController.reciveData(1,pseudo1,labelButtonJ1.getText(),imageJ1.getImage());
        modalWindowLogo.show();
    }

    @FXML
    void ButtonSymboleJ2(ActionEvent event) {
        Button button = (Button) event.getSource();
        logoController.reciveData(2,pseudo2,labelButtonJ2.getText(),imageJ2.getImage());
        modalWindowLogo.show();
    }
    public void setGameWindow(Stage modalWindow) {
        this.modalWindow=modalWindow;
    }
    public void setLogoWindow (Stage modalWindowLogo){this.modalWindowLogo=modalWindowLogo;}
    public void reciveDataLogo(int joueur, String logo, Image image){
        if (logo!=null){
            if (joueur==1){
                logo1=logo;
                labelButtonJ1.setText(logo);
                labelButtonJ1.setVisible(true);
                imageJ1.setVisible(false);
            } else if (joueur==2) {
                logo2=logo;
                labelButtonJ2.setText(logo);
                labelButtonJ2.setVisible(true);
                imageJ2.setVisible(false);
            }
        } else if (image!=null) {
            if (joueur==1){
                imageJ1.setImage(image);
                labelButtonJ1.setVisible(false);
                imageJ1.setVisible(true);
            } else if (joueur==2) {
                imageJ2.setImage(image);
                labelButtonJ2.setVisible(false);
                imageJ2.setVisible(true);
            }
        }
    }
    public void setControllerLogo(ChangeLogoController logoController) {
        this.logoController = logoController;
    }
    public void setControllerGame(GameController gamecontroller) {
        this.gamecontroller = gamecontroller;
    }
    public void callController(){
        gamecontroller.reciveDataLogo(logo1,logo2);
    }


}
