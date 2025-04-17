package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Organizer extends User {
    private List<Hackathon> organizedHackathons;

    public Organizer(String username, String email, String password) {
        super(username, email, password);
        organizedHackathons = new ArrayList<>();
    }

    public void createHackathon(String title, String location, LocalDate startDate, LocalDate endDate, Organizer organizer, int maxTeamSize, LocalDate registrationDeadline) {
        Hackathon newHackathon = new Hackathon(title, location, startDate, endDate, organizer, maxTeamSize, registrationDeadline);
        organizedHackathons.add(newHackathon);
        System.out.println("Hackathon '" + title + "' created successfully!");
    }
}
