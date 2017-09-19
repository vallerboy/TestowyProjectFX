package pl.oskarpolak.testproject.models.dao.impl;

import pl.oskarpolak.testproject.models.MysqlConnector;
import pl.oskarpolak.testproject.models.dao.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private MysqlConnector connector = MysqlConnector.getInstance();

    @Override
    public boolean login(String name, String password) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE user = ?"
            );
            preparedStatement.setString(1, name);
            ResultSet resultSet  = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return false;
            }

            preparedStatement.close();
            return resultSet.getString("password").equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  false;
    }

    @Override
    public boolean register(String name, String password) {

        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE user = ?"
            );
            preparedStatement.setString(1, name);
            ResultSet resultSet  = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }

            PreparedStatement preparedStatementInsert = connector.getConnection().prepareStatement(
                    "INSERT INTO user VALUES(?, ?, ?)"
            );
            preparedStatementInsert.setInt(1, 0);
            preparedStatementInsert.setString(2, name);
            preparedStatementInsert.setString(3, password);

            preparedStatementInsert.execute();

            preparedStatement.close();
            preparedStatementInsert.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void removeUser(int id) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "DELETE FROM user WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
