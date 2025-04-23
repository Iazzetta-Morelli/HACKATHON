package model;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
    private final List<User> users;
    private User loggedInUser;

    public SystemManager() {
        users = new ArrayList<>();
        loggedInUser = null;
    }

    public void registerUser(String username, String email, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("This username is already taken.");
                return;
            }

            if (user.getEmail().equals(email)) {
                System.out.println("This email il already in use.");
                return;
            }
        }

        User newUser = new User(username, email, password);
        users.add(newUser);
        System.out.println("Registration completed!");
        System.out.println("username: " + username + ", email: " + email + ".");
    }

    public void login(User user, String password) {
        for (User u : users) {
            boolean match = u.getUsername().equals(user.getUsername()) ||
                    u.getEmail().equals(user.getEmail());
            if (match && u.checkPassword(password)) {
                u.setLoginStatus(true);
                System.out.println("Login successful.");
                return;
            } else if (match) {
                System.out.println("Incorrect password.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void logout(User user) {
        if (user.getLoginStatus()){
            user.setLoginStatus(false);
        } else {
            System.out.println("User is already logged out.");
            return;
        }
    }

    private String generateTeamCode() {
        return java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void assignTeamCode(Team team) {
        if (team != null) {
            String code = generateTeamCode();
            System.out.println("Team is null, cannot assign code.");
        }
    }
}
