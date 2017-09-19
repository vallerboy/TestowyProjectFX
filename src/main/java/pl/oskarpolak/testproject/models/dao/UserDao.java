package pl.oskarpolak.testproject.models.dao;

public interface UserDao {
    boolean login(String name, String password);
    boolean register(String name, String password);
    void removeUser(int id);
}
