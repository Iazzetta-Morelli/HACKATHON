package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hackathon {
    private Boolean isOpen;
    private String title;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Organizer organizer;
    private List<Judge> judges;
    private List<Participant> participants;
    private List<Team> teams;
    private int maxTeamSize;
    private LocalDate registrationDeadline;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Hackathon(String title, String location, LocalDate startDate, LocalDate endDate, Organizer organizer, int maxTeamSize, LocalDate registrationDeadline) {
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organizer = organizer;
        this.maxTeamSize = maxTeamSize;
        this.registrationDeadline = registrationDeadline;
        this.judges = new ArrayList<>();
        this.participants = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.isOpen = false;
    }

    public void addJudge(Judge judge) {
        judges.add(judge);
    }

    public void addParticipant(Participant participant) {
        if (isOpen && LocalDate.now().isBefore(registrationDeadline)) {
            participants.add(participant);
        } else {
            System.out.println("Registration is currently closed.");
        }
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public LocalDate getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void closeRegistration() {
        this.isOpen = false;
        System.out.println("Registration is currently closed.");
    }

    public boolean isRegistrationOpen() {
        return isOpen && LocalDate.now().isBefore(registrationDeadline);
    }
}
