package model;

import java.util.Scanner;

public class Participant extends User {
    String teamName = null;
    Hackathon hackathon;

    Participant(Manager manager) {
        super(manager);
    }

    void createTeam() {
        if (this.teamName != null) {
            System.out.println("You already have a team.");
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please type the name of the team: ");
            String teamName = scanner.nextLine();
            this.teamName = teamName;

            System.out.print("Please type the total members number: ");
            int teamSize = scanner.nextInt();

            if (teamSize > hackathon.maxTeamSize) {
                System.out.println("This number exceeds the allowed maximum.");
            } else {
                Team team = new Team(teamName, teamSize);
            }
        }
    }

    void joinTeam(String teamName, Hackathon hackathon) {
        if (this.teamName != null) {
            System.out.println("You already have a team.");
        } else {
            for (Team team : hackathon.teams) {
                if (teamName.equals(team.teamName)) {
                    team.addParticipant(this);
                    this.teamName = teamName;
                    System.out.println("You have joined the team " + teamName);
                    return;
                }
            }
        }
        System.out.println("Team not found.");
    }
}
