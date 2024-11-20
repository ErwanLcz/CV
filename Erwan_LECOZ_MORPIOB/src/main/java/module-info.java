module com.example.erwan_lecoz_morpiob {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.erwan_lecoz_morpiob to javafx.fxml;
    exports com.example.erwan_lecoz_morpiob;
}