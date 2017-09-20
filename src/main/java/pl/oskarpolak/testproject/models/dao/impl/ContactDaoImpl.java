package pl.oskarpolak.testproject.models.dao.impl;

import pl.oskarpolak.testproject.models.MysqlConnector;
import pl.oskarpolak.testproject.models.dao.ContactDao;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    private MysqlConnector connector = MysqlConnector.getInstance();

    @Override
    public List<String> getAllContactsNames(String username) {
        return null;
    }

    @Override
    public String getNumber(String contact) {
        return null;
    }

    @Override
    public boolean addContact(String name, String number) {
        return false;
    }

    @Override
    public void removeContact(String name) {

    }

    @Override
    public boolean editContact(String name, String number) {
        return false;
    }
}
