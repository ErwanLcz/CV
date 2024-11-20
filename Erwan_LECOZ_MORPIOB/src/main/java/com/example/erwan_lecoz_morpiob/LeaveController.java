package com.example.erwan_lecoz_morpiob;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LeaveController {


    @FXML
    private Label winnerLabel;

    @FXML
    void noLeaveButton(ActionEvent event) {
        Button btn = (Button)event.getSource();
        Stage stage = (Stage)btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void yesLeaveButton(ActionEvent event) {
        System.exit(1);
    }

}
