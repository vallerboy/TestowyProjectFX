package pl.oskarpolak.testproject.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    Button buttonHello;

    public void initialize(URL location, ResourceBundle resources) {
       // buttonHello.setOnMouseClicked(s -> System.out.println("Hello!"));
    }

    public void onButtonHelloClicked(MouseEvent event){
       if(event.isAltDown()) {
           System.out.println("Hello! Klikniecie: " + event.getClickCount());
       }
    }
}
