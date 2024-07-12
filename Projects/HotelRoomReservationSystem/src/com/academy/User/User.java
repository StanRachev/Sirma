package com.academy.User;

import java.util.List;

public class User {

    String username;
    String password;
    List<String> history;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
