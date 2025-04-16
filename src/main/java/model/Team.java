package model;

import java.util.ArrayList;

public class Team {
    String teamName = null;
    int teamSize;
    ArrayList<Participant> teamMembers = new ArrayList<>();

    public Team(String teamName, int teamSize) {
        this.teamName = teamName;
        this.teamSize = teamSize;
    }

    public void addParticipant(Participant participant) {
        teamMembers.add(participant);
    }
}
