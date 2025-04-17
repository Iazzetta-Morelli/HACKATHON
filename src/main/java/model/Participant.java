package model;

import java.util.Scanner;

public class Participant extends User {
    private Team team;
    private boolean isTeamLeader;

    public Participant(String username, String email, String password) {
        super(username, email, password);
        this.team = null;
        this.isTeamLeader = false;
    }

    public void createTeam(String teamName, Hackathon hackathon) {
        if (this.team != null) {
            System.out.println("You are already part of a team.");
            return;
        }

        Team newTeam = new Team(teamName, hackathon);
        this.team = newTeam;
        newTeam.addMember(this);
        this.isTeamLeader = true;
        System.out.println("Team '" + teamName + "' created successfully.");
    }

    public void joinTeam(String teamName) {
        if (this.team != null) {
            System.out.println("You are already part of a team.");
            return;
        }

        if (team.addMember(this)) {
            this.team = team;
            System.out.println("Joined team '" + team.getTeamName() + "' successfully.");
        } else {
            System.out.println("Unable to join the team.");
        }
    }

    public String getTeamName() {
        return team != null ? team.getTeamName() : "No team";
    }

    public boolean isTeamLeader() {
        return isTeamLeader;
    }
}
