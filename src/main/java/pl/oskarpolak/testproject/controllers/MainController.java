package pl.oskarpolak.testproject.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import pl.oskarpolak.testproject.models.MysqlConnector;
import pl.oskarpolak.testproject.models.UserSession;
import pl.oskarpolak.testproject.models.dao.ContactDao;
import pl.oskarpolak.testproject.models.dao.impl.ContactDaoImpl;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    Label textNumber, textName;

    @FXML
    ListView listContacts;

    private ObservableList contactItems;

    private UserSession session  = UserSession.getInstance();
    private ContactDao contactDao = new ContactDaoImpl();

    public void initialize(URL location, ResourceBundle resources) {
        loadContacts();
    }

    private void loadContacts() {
        contactItems = FXCollections.observableArrayList(contactDao.getAllContactsNames(session.getUsername()));
        listContacts.setItems(contactItems);
    }
}
