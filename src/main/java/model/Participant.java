package model;

import java.util.List;

public class Participant extends User {
    private Team team;
    private boolean isTeamLeader;

    public Participant(String username, String email, String password) {
        super(username, email, password);
        this.team = null;
        this.isTeamLeader = false;
    }

    public boolean isTeamLeader() {
        return isTeamLeader;
    }

    public Team getTeam() {
        return team;
    }
    
    
    public Team createTeam(String teamName, Hackathon hackathon, SystemManager manager) {
        if (this.team != null) {
            System.out.println("Sei già in un team.");
            return null;
        }

        Team newTeam = new Team(teamName, hackathon);
        newTeam.addMember(this);
        this.team = newTeam;
        this.isTeamLeader = true;

        // Assegna il codice tramite il SystemManager
        manager.assignTeamCode(newTeam);

        System.out.println("Team creato con successo!");
        return newTeam;
    }

 
    public boolean joinTeam(String teamName, String teamCode, List<Team> availableTeams) {
        if (this.team != null) {
            System.out.println("Sei già in un team.");
            return false;
        }

        for (Team t : availableTeams) {
            if (t.getTeamName().equalsIgnoreCase(teamName) && t.getTeamCode() != null && t.getTeamCode().equalsIgnoreCase(teamCode)) {
                t.addMember(this);
                this.team = t;
                System.out.println("Joined the team successfully!");
                return true;
            }
        }

        System.out.println("Team not found or incorrect code..");
        return false;
    }
}
