package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hackathon {
    Boolean status = false;
    String title;
    String location;
    LocalDate startDate;
    LocalDate endDate;
    Organizer organizer;
    ArrayList<Judge> judges;
    ArrayList<Participant> participants;
    ArrayList<Team> teams;
    int maxTeamSize;
    LocalDate registrationDeadline;
    private String problemStatement;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Hackathon(boolean status, String title, String location, LocalDate startDate, LocalDate endDate, Organizer organizer) {
        this.status = status;
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organizer = organizer;
    }

    public void setStatus(boolean newStatus) {
        status = newStatus;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String newLocation) {
        location = newLocation;
    }

    public void setStartDate(LocalDate newStartDate) {
        startDate = newStartDate;
    }

    public void setEndDate(LocalDate newEndDate) {
        endDate = newEndDate;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public void registerParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public boolean registerTeam(Team team) {
        for (Team t : teams) {
            if (t.getTeamName().equals(team.getTeamName())) {
                System.out.println("This team name is already taken.");
                return false;
            }
        }

        this.teams.add(team);
        System.out.println("Team has been successfully registered.");
        return true;
    }

    public void registerJudge(Judge judge) {
        this.judges.add(judge);
    }

    public void setMaxTeamSize(int newMaxTeamSize) {
        maxTeamSize = newMaxTeamSize;
    }

    public void setRegistrationDeadline(LocalDate newRegistrationDeadline) {
        registrationDeadline = newRegistrationDeadline;
    }

    public boolean getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public LocalDate getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setMaxParticipants(int maxParticipants) {
        
    }
}
