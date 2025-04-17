package model;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
    private List<User> users;
    private User loggedInUser;

    public SystemManager() {
        users = new ArrayList<>();
        loggedInUser = null;
    }

    public boolean registerUser(String username, String email, String password) {
        for (User user : users ) {
            if (user.getUsername().equals(username)) {
                System.out.println("This username is already taken.");
                return false;
            }
            if (user.getEmail().equals(email)) {
                System.out.println("This email il already in use.");
                return false;
            }
        }

        User newUser = new User(username, email, password);
        users.add(newUser);
        System.out.println("Registration completed!");
        return true;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.checkPassword(password)) {
                    loggedInUser = user;
                    System.out.println("Login was successful!");
                    return true;
                } else {
                    System.out.println("Incorrect password.");
                    return false;
                }
            }
        }

        System.out.println("Username not found.");
        return false;
    }

    public void logout() {
        if (loggedInUser == null) {
            System.out.println("User is already logged out");
        } else {
            loggedInUser = null;
            System.out.println("Logout was successful!");
        }
    }

    public boolean isUserLoggedIn() {
        return loggedInUser != null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
