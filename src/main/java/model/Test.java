package model;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        User user = new User(manager);

        // Test per inserire l'username
        System.out.println("---- Username Setup ----");
        user.setUsername();  // Chiede all'utente di inserire un username

        // Test per inserire l'email
        System.out.println("---- Email Setup ----");
        user.setEmail();  // Chiede all'utente di inserire un'email

        // Test per inserire la password
        System.out.println("---- Password Setup ----");
        user.setPassword();  // Chiede all'utente di inserire una password

        // Stampa le informazioni inserite (per verificare che tutto funzioni)
        System.out.println("\n--- User Info ---");
        System.out.println("Username: " + user.username);
        System.out.println("Email: " + user.email);
        System.out.println("Password: " + user.password);

        // Chiude lo scanner per evitare perdite di risorse
        scanner.close();
    }
}
