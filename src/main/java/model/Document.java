package model;

import java.util.ArrayList;

public class Document {
    private String title;
    private String content;
    private Team team;
    private ArrayList<String> comments = new ArrayList<>();

    public Document(String title, String content, Team team) {
        this.title = title;
        this.content = content;
        this.team = team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Team getTeam() {
        return team;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public void printInfo() {
        System.out.println("Document: " + title);
        System.out.println("Uploaded by team: " + (team != null ? team.getTeamName() : "Unknown"));
    }
}