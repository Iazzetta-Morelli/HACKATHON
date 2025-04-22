package model;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.UUID;

    public class SystemManager {
        private List<User> users;

        public SystemManager() {
            this.users = new ArrayList<>(); //contiene tutti i campi di users
        }

        public void registerUser(User user) {
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername())) {
                    System.out.println("This username is already taken.");
                    return;
                }

                if (u.getEmail().equals(user.getEmail())) {
                    System.out.println("This email is already taken.");
                    return;
                }
            }

            users.add(user);
            System.out.println("Registration completed.");
        }

        public void login(User user, String password) {
            for (User u : users) {
                boolean match = u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail());

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
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                    if (u.getLoginStatus()) {
                        u.setLoginStatus(false);
                        System.out.println("Logout successful.");
                    } else {
                        System.out.println("User is not logged in.");
                    }
                    return;
                }
            }
            System.out.println("User not found.");
        }

        private String generateTeamCode() {
            return java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
        
        public void assignTeamCode(Team team) {
            if (team != null) {
                String code = generateTeamCode();
                team.setTeamCode(code);  // richiede che Team abbia un setTeamCode()
                System.out.println("Team code generated: " + code);
            } else {
                System.out.println("Team is null, cannot assign code.");
            }
        }
    }