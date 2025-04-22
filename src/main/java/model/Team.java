package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<User> members;
    private Hackathon hackathon;
    private List<Document> documents;
    private String teamCode;
    private int rate;
    private int average;

    public Team(String teamName, Hackathon hackathon) {
        this.teamName = teamName;
        this.hackathon = hackathon;
        this.members = new ArrayList<>();
        this.documents = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public int getAverage () {
        //aggiungere i parametri dei voti dei giudici
        return average;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }
    
    public String getTeamCode() {
        return teamCode;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void uploadDocument(String title, String content) {
        Document newDocument = new Document(title, content, this);
        documents.add(newDocument); // Il documento viene aggiunto al team
    }

    public void printInfo() {
        System.out.println("Team: " + teamName);
        System.out.println("Hackathon: " + hackathon.getTitle()); 

        System.out.println("Members:");
        for (User u : members) {
            System.out.println("- " + u.getUsername());
        }

        System.out.println("Documents uploaded: " + documents.size());
        for (Document doc : documents) {
            doc.printInfo();
        }
    }
}



