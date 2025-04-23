package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Organizer extends User {
    public Organizer(String username, String email, String password) {
        super(username, email, password);
    }
    
    public Hackathon createHackathon(String title, String location, LocalDate startDate, LocalDate endDate) {
        Hackathon hackathon = new Hackathon(false, title, location, startDate, endDate, this);
        System.out.println("Hackathon '" + title + "' created successfully.");
        return hackathon;
    }
    
    public void setStatus(Hackathon hackathon, boolean status) {
        hackathon.setStatus(status);
        System.out.println("Hackathon status set to: " + (status ? "open" : "closed"));
    }
    
    public void setTitle(Hackathon hackathon, String title) {
        hackathon.setTitle(title);
        System.out.println("Hackathon title updated to: " + title);
    }
    
    public void setLocation(Hackathon hackathon, String location) {
        hackathon.setLocation(location);
        System.out.println("Hackathon location set to: " + location);
    }
    
    public void setStartDate(Hackathon hackathon, LocalDate startDate) {
        hackathon.setStartDate(startDate);
        System.out.println("Hackathon start date set to: " + startDate);
    }
    
    public void setEndDate(Hackathon hackathon, LocalDate endDate) {
        hackathon.setEndDate(endDate);
        System.out.println("Hackathon end date set to: " + endDate);
    }
    
    public void setOrganizer(Hackathon hackathon, Organizer newOrganizer) {
        hackathon.setOrganizer(newOrganizer);
        System.out.println("Organizer changed to: " + newOrganizer.getUsername());
    }
    
    public void setMaxParticipants(Hackathon hackathon, int maxParticipants) {
        hackathon.setMaxParticipants(maxParticipants);
        System.out.println("Max participants set to: " + maxParticipants);
    }
    
    public void setMaxTeamSize(Hackathon hackathon, int maxTeamSize) {
        hackathon.setMaxTeamSize(maxTeamSize);
        System.out.println("Max team size set to: " + maxTeamSize);
    }
    
    public void setRegistrationDeadline(Hackathon hackathon, LocalDate deadline) {
        hackathon.setRegistrationDeadline(deadline);
        System.out.println("Registration deadline set to: " + deadline);
    }
    
    public void inviteJudges(Hackathon hackathon, Judge judge) {
        hackathon.registerJudge(judge);
    }
}

