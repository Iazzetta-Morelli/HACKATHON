package model;

public class User {
    private final String username;
    private final String email;
    private final String password;

    User(String username, String email, String password) {
        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Username cannot be null or empty.");
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email cannot be null or empty.");
        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password cannot be null or empty.");

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
