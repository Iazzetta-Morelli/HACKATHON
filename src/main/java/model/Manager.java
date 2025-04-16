package model;

import java.util.ArrayList;

public class Manager {
    // Liste per memorizzare gli utenti
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();

    public void addUsername(String username) {
        if (!isUsernameTaken(username)) {
            usernames.add(username);
        } else {
            System.out.println("Error: this username is already in use.");
        }
    }

    public void addEmail(String email) {
        if (!isEmailTaken(email)) {
            emails.add(email);
        } else {
            System.out.println("Error: this email is already in use.");
        }
    }

    public boolean isUsernameTaken(String username) {
        return usernames.contains(username);
    }

    public boolean isEmailTaken(String email) {
        return emails.contains(email);
    }
}
