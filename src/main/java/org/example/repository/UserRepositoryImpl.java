package org.example.repository;

import org.example.model.user.User;
import org.example.model.user.UserState;
import org.example.util.BeanUtil;
import org.telegram.telegrambots.meta.api.objects.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    private static final UserRepositoryImpl instance = new UserRepositoryImpl();

    private UserRepositoryImpl() {
    }

    public static UserRepositoryImpl getInstance() {
        return instance;
    }

    private final Connection connection = BeanUtil.connection();
    public boolean save(Contact contact, String bio, String username, double balance){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);

            preparedStatement.setString(1, String.valueOf(contact.getUserId()));
            preparedStatement.setString(2, contact.getFirstName());
            preparedStatement.setString(3, contact.getLastName());
            preparedStatement.setString(4, contact.getPhoneNumber());
            preparedStatement.setString(5, username);
            preparedStatement.setDouble(6, balance);
            preparedStatement.setString(7, bio);
            preparedStatement.setString(8, String.valueOf(UserState.REGISTERED));

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
    }

    public User findById(UUID id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                User user = new User()
                        .setChatId(Long.valueOf(resultSet.getString("chatid")))
                        .setFirstName(resultSet.getString("firstname"))
                        .setLastName(resultSet.getString("lastname"))
                        .setPhoneNumber(resultSet.getString("phonenumber"))
                        .setUsername(resultSet.getString("username"))
                        .setBalance(resultSet.getDouble("balance"))
                        .setBio(resultSet.getString("bio"))
                        .setState(UserState.valueOf(resultSet.getString("state")));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(getAllUsers);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User()
                        .setChatId(Long.valueOf(resultSet.getString("chatid")))
                        .setFirstName(resultSet.getString("firstname"))
                        .setLastName(resultSet.getString("lastname"))
                        .setPhoneNumber(resultSet.getString("phonenumber"))
                        .setUsername(resultSet.getString("username"))
                        .setBalance(resultSet.getDouble("balance"))
                        .setBio(resultSet.getString("bio"))
                        .setState(UserState.valueOf(resultSet.getString("state")));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void updateState(Long chatId, UserState userState) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserState);
            preparedStatement.setString(1, userState.toString());
            preparedStatement.setString(2, chatId.toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
