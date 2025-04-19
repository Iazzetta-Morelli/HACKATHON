package model;

import java.time.LocalDate;
import java.util.List;

public class Hackathon {
    private boolean isOpen;
    private String title;
    private String location;
    private Organizer organizer;
    private List<Participant> participants;
    private List<Judge> judges;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxParticipants;
    private int maxTeamSize;
    private LocalDate registrationDeadline;
    
    public Hackathon(String title, String location, LocalDate startDate, LocalDate endDate, int maxParticipants, int maxTeamSize, LocalDate registrationDeadline) {
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxParticipants = maxParticipants;
        this.maxTeamSize = maxTeamSize;
        this.registrationDeadline = registrationDeadline;
        this.isOpen = false;  
    }
    
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public boolean getHackathonStatus() {
        return isOpen;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Judge> getJudges() {
        return judges;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public LocalDate getRegistrationDeadline() {
        return registrationDeadline;
    }
}
