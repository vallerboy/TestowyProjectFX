package pl.oskarpolak.testproject.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.oskarpolak.testproject.models.MysqlConnector;
import pl.oskarpolak.testproject.models.UserSession;
import pl.oskarpolak.testproject.models.dao.ContactDao;
import pl.oskarpolak.testproject.models.dao.impl.ContactDaoImpl;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    TextField textNumber, textName;

    @FXML
    ListView<String> listContacts;

    @FXML
    Button buttonLogout;

    private ObservableList contactItems;

    private UserSession session  = UserSession.getInstance();
    private ContactDao contactDao = new ContactDaoImpl();

    public void initialize(URL location, ResourceBundle resources) {
        textName.setEditable(false);
        textNumber.setEditable(false);


        loadContacts();

        listContacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            textName.setText(newValue);
            textNumber.setText(contactDao.getNumber(newValue));
        });

        buttonLogout.setOnMouseClicked(e -> logout());

        updateActions();


    }

    private void updateActions(){
        textName.setOnMouseClicked(e -> {
            if(e.getClickCount() >= 2){
                textName.setEditable(true);
            }
        });

        textName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
               if(!newValue){
                   contactDao.editContact(textName.getText(), textNumber.getText(), listContacts.getSelectionModel().getSelectedItem());
                   loadContacts();
                   textName.setEditable(false);
               }
            }
        });
    }

    private void logout() {
        session.setLogedIn(false);
        session.setUsername(null);
        session.setId(0);

        Stage stage = (Stage) buttonLogout.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("loginView.fxml"));
            stage.setScene(new Scene(root, 600,400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContacts() {
        contactItems = FXCollections.observableArrayList(contactDao.getAllContactsNames(session.getUsername()));
        listContacts.setItems(contactItems);
    }
}
