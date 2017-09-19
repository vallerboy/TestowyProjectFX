package pl.oskarpolak.testproject.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.oskarpolak.testproject.models.MysqlConnector;
import pl.oskarpolak.testproject.models.UserSession;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    // Dorobic widok logowania login / haslo i odpowiednia tabela
    // Podlgad kontakow w mainView i dodawnie nowych kontaktow

    private UserSession session  = UserSession.getInstance();

    public void initialize(URL location, ResourceBundle resources) {
        MysqlConnector.getInstance();

        if(session.isLogedIn()){
            System.out.println("USER JEST ZALOGOWANY!");
        }
    }
}
