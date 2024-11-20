package com.example.erwan_lecoz_morpiob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RulesController {

    @FXML
    void backButton(ActionEvent event) {
        Button btn = (Button)event.getSource();
        Stage stage = (Stage)btn.getScene().getWindow();
        stage.close();
    }

}
