package model;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        SystemManager systemManager = new SystemManager();

        // Registrazione utenti
        systemManager.registerUser("alice", "alice@example.com", "password123");
        systemManager.registerUser("bob", "bob@example.com", "secure456");

        // Login come Organizer
        systemManager.login("alice", "password123");
        Organizer organizer = new Organizer("alice", "alice@example.com", "password123");

        // Creazione Hackathon
        LocalDate start = LocalDate.of(2025, 6, 1);
        LocalDate end = LocalDate.of(2025, 6, 3);
        LocalDate deadline = LocalDate.of(2025, 5, 30);
        Hackathon hackathon = new Hackathon("HackUP", "Rome", start, end, organizer, 3, deadline);

        // Registrazione di un partecipante
        Participant participantBob = new Participant("bob", "bob@example.com", "secure456");
        hackathon.addParticipant(participantBob);

        // Bob crea un team
        participantBob.createTeam("TeamRocket", hackathon);

        // Un altro partecipante
        Participant participantEve = new Participant("eve", "eve@example.com", "pass789");
        hackathon.addParticipant(participantEve);

        // Eve si unisce al team di Bob
        participantEve.joinTeam("TeamRocket", hackathon);

        // Stampa riepilogo
        System.out.println("\nTeam: " + participantBob.getTeamName());
        System.out.println("Membri:");
        for (Participant p : participantBob.team.getMembers()) {
            System.out.println("- " + p.getUsername());
        }
    }
}

