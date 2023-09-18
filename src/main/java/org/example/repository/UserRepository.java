package org.example.repository;

public interface UserRepository {
    String insertUser = """
            insert into users(chatid, firstname, lastname, phonenumber,
            username, balance, bio, state)
            values(?,?,?,?,?,?,?,?);
            """;
    String findById = "select * from users where id = ?";
    String getAllUsers = """
            select * from users;
            """;
    String deleteUser = "";

    String updateUserState = """
            update users set state = ? where chatid = ?;
            """;
}
