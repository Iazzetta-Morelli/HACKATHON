package model;

import java.util.Scanner;

public class User {
    String username;
    String email;
    String password;
    private Manager manager;

    User(Manager manager) {
        this.manager = manager;
    }

    public void setUsername() {
        Scanner scanner = new Scanner(System.in);
        String desiredUsername;
        boolean available = false;

        while (!available) {
            System.out.print("Please type your desired username: ");
            desiredUsername = scanner.nextLine();

            if (manager.isUsernameTaken(desiredUsername)) {
                System.out.println("Error: this username is already in use. Please try again.");
            } else {
                this.username = desiredUsername;
                manager.addUsername(desiredUsername);
                available = true;
                System.out.println("Username set successfully!");
            }
        }
    }

    public void setEmail() {
        Scanner scanner = new Scanner(System.in);
        String desiredEmail;
        boolean available = false;

        while (!available) {
            System.out.print("Please type your desired email: ");
            desiredEmail = scanner.nextLine();

            if (manager.isEmailTaken(desiredEmail)) {
                System.out.println("Error: this email is already in use. Please try again.");
            } else {
                this.email = desiredEmail;
                manager.addEmail(desiredEmail);
                available = true;
                System.out.println("Email set successfully!");
            }
        }
    }

    public void setPassword() {
        Scanner scanner = new Scanner(System.in);
        String password;

        System.out.print("Please type your password: ");
        password = scanner.nextLine();
        this.password = password;
    }
}
