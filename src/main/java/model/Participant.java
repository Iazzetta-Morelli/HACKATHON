package model;

public class Participant extends User {
    protected Team team;
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

        for (Team existingTeam : hackathon.getTeams()) {
            if (existingTeam.getTeamName().equals(teamName)) {
                System.out.println("A team with this name already exists. Please choose a different name.");
                return;
            }
        }

        Team newTeam = new Team(teamName, hackathon);
        if (newTeam.addMember(this)) {
            this.team = newTeam;
            this.isTeamLeader = true;
            hackathon.addTeam(this.team);
            System.out.println("Team '" + teamName + "' created successfully.");
        } else {
            System.out.println("Failed to create team.");
        }
    }

    public void joinTeam(String teamName, Hackathon hackathon) {
        if (this.team != null) {
            System.out.println("You are already part of a team.");
            return;
        }

        for (Team existingTeam : hackathon.getTeams()) {
            if (existingTeam.getTeamName().equals(teamName)) {
                if (existingTeam.addMember(this)) {
                    this.team = existingTeam;
                    System.out.println("Joined team '" + teamName + "' successfully.");
                    return;
                } else {
                    System.out.println("Team is full.");
                    return;
                }
            }
        }
        System.out.println("Team not found.");
    }

    public String getTeamName() {
        return team != null ? team.getTeamName() : "No team";
    }

    public boolean isTeamLeader() {
        return isTeamLeader;
    }
}
