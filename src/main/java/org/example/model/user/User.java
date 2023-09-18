package org.example.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class User {
    private UUID id;
    private Long chatId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private Double balance;
    private String bio;
    private UserState state;

}
