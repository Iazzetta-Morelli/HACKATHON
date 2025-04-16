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
    String organizer;
    ArrayList<String> judges = new ArrayList<>();
    ArrayList<String> participants = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    int maxTeamSize;
    LocalDate registrationDeadline;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
