package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML                       // fx:id="myButton"
    private Button myButton;    // Value injected by FXMLLoader.

    @Override                   // Called by FXMLLoader when initialization is complete.
    public void initialize(URL location, ResourceBundle resources) {

        myButton.setOnAction((event) -> {
            System.out.println("Log log!");
        });
    }
}
