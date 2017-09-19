package pl.oskarpolak.testproject.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.oskarpolak.testproject.models.UserSession;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    TextField textLogin, textLoginR;

    @FXML
    PasswordField textPassword, textPasswordR, textPasswordRepeatR;

    @FXML
    Button buttonLogin, buttonRegister;

    private UserSession userSession = UserSession.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
