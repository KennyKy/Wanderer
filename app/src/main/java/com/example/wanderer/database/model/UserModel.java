package com.example.wanderer.database.model;

public class UserModel {
    public static final String
        TABLE_NAME="users",
        USERNAME_COLUMN="username",
        EMAIL_COLUMN="email",
        PASSWORD_COLUMN="password";

    public static final String
        CREATE_TABLE = "CREATE TABLE users (username, email, password);";

    public static final String
        DROP_TABLE = " drop table if exists users";

    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
