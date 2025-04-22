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
    
    public void createTeam(String teamName, Hackathon hackathon, SystemManager systemManager) {
        if (this.team != null) {
            System.out.println("You are already part of a team.");
        }

        Team newTeam = new Team(teamName, hackathon);
        newTeam.addMember(this);
        this.team = newTeam;
        this.isTeamLeader = true;

        // Assegna il codice tramite il SystemManager
        systemManager.assignTeamCode(newTeam);

        if (!hackathon.registerTeam(newTeam)) {
            System.out.println("Registration failed: choose another team name and try again.");
        } else {
            System.out.println("Registration completed!");
        }
    }

    public void joinTeam(String teamName, String teamCode, List<Team> availableTeams) {
        if (this.team != null) {
            System.out.println("You are already part of a team.");
        }

        for (Team t : availableTeams) {
            if (t.getTeamName().equalsIgnoreCase(teamName) && t.getTeamCode() != null && t.getTeamCode().equalsIgnoreCase(teamCode)) {
                t.addMember(this);
                this.team = t;
                System.out.println("Joined the team successfully!");
            }
        }

        System.out.println("Team not found or incorrect code.");
    }
}
