package pl.oskarpolak.testproject.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import pl.oskarpolak.testproject.models.MysqlConnector;
import pl.oskarpolak.testproject.models.UserSession;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    Label textNumber, textName;

    @FXML
    ListView listContacts;

    private UserSession session  = UserSession.getInstance();

    public void initialize(URL location, ResourceBundle resources) {

    }
}
