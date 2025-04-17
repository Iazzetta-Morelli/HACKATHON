package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Participant> members;
    private Hackathon hackathon;

    public Team(String teamName, Hackathon hackathon) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
        this.hackathon = hackathon;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Participant> getMembers() {
        return members;
    }

    public boolean addMember(Participant participant) {
        if (members.size() < hackathon.getMaxTeamSize()) {
            members.add(participant);
            return true;
        } else {
            System.out.println("Team is already full. Maximum members allowed: " + hackathon.getMaxTeamSize());
            return false;
        }
    }

    public boolean isFull() {
        return members.size() >= hackathon.getMaxTeamSize();
    }

    public int getMemberCount() {
        return members.size();
    }
}
