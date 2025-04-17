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
    private final List<Judge> judges;
    private final List<Participant> participants;
    private final List<Team> teams;
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

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public void setStartDate(LocalDate newStartDate) {
        this.startDate = newStartDate;
    }

    public void setEndDate(LocalDate newEndDate) {
        this.endDate = newEndDate;
    }

    public void setOrganizer(Organizer newOrganizer) {
        this.organizer = newOrganizer;
    }

    public void setMaxTeamSize(int newMaxTeamSize) {
        this.maxTeamSize = newMaxTeamSize;
    }

    public void setRegistrationDeadline(LocalDate newRegistrationDeadline) {
        this.registrationDeadline = newRegistrationDeadline;
    }

    public void addJudge(Judge judge) {
        judges.add(judge);
    }

    public void addParticipant(Participant participant) {
        if (!isOpen || !LocalDate.now().isBefore(registrationDeadline)) {
            System.out.println("Registration is currently closed.");
        } else if (participants.contains(participant)) {
            System.out.println("This participant is already registered.");
        } else {
            participants.add(participant);
            System.out.println("Participant " + participant.getUsername() + " has been successfully registered!");
        }
    }

    public void addTeam(Team team) {
        if (team != null && !teams.contains(team)) {
            teams.add(team);
            System.out.println("Team '" + team.getTeamName() + "' added to hackathon.");
        } else {
            System.out.println("Team is null or already registered.");
        }
    }

    public List<Team> getTeams() {
        return teams;
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
