package org.example.service;

import org.example.model.user.User;
import org.example.model.user.UserState;
import org.example.repository.UserRepositoryImpl;
import org.telegram.telegrambots.meta.api.objects.Contact;
import java.util.Objects;


public class UserService {

    private static final UserService instance = new UserService();

    private UserService() {
    }

    public static UserService getInstance() {
        return instance;
    }

    public final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    public boolean addUser(Contact contact, String bio, String username,double balance) {
        if (cheackPhoneNumber(contact.getPhoneNumber())) {
            return false;
        }
            userRepository.save(contact,bio,username,balance);
            return true;
    }

    private boolean cheackPhoneNumber(String phoneNumber) {
        for (User allUser : userRepository.getAllUsers()) {
            if (Objects.equals(allUser.getPhoneNumber(), phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void updateState(Long chatId, UserState userState) {
        userRepository.updateState(chatId, userState);
    }

    public User getByChatId(Long chatId) {
        for (User allUser : userRepository.getAllUsers()) {
            if (Objects.equals(allUser.getChatId(), chatId)) {
                return allUser;
            }
        }
        return null;
    }
}
