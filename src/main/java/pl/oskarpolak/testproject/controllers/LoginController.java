package pl.oskarpolak.testproject.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.oskarpolak.testproject.models.UserSession;
import pl.oskarpolak.testproject.models.Utils;
import pl.oskarpolak.testproject.models.dao.UserDao;
import pl.oskarpolak.testproject.models.dao.impl.UserDaoImpl;

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
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonLogin.setOnMouseClicked(e -> tryLogin());
    }

    private void tryLogin() {
        String login = textLogin.getText();
        String password = textPassword.getText();

        if(userDao.login(login, password)){
            userSession.setUsername(login);
            userSession.setLogedIn(true);

            Utils.createSimpleDialog("Logowanie", "", "Zalogowano poprawnie");
         }else{
            Utils.createSimpleDialog("Logowanie", "", "Masz błąd w danych");
        }
    }
}
