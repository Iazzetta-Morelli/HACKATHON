package model;

import java.util.ArrayList;
import java.util.List;

public class Judge extends User {

    private String problemStatement;
    private List<CommentEntry> comments;
    private List<VoteEntry> votes;

    public Judge(String username, String email, String password) {
        super(username, email, password);
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
    }
    
    public void publishProblem(String problem) {
        this.problemStatement = problem;
        System.out.println("Problem posted: " + problem);
    }
    
    public void addFeedback(Team team, String comment) {
        comments.add(new CommentEntry(team, comment));
        System.out.println("Comment added to team " + team.getTeamName() + ": " + comment);
    }

    public void rateTeam(Team team, int rating) {
        if (rating < 0 || rating > 100) {
            System.out.println("The score must be between 0 and 10.");
            return;
        }
        // Cerca se il team è già stato votato
        for (VoteEntry v : votes) {
            if (v.team == team) {
                v.rating = rating;
                System.out.println("Updated score for team " + team.getTeamName() + ": " + rating);
                return;
            }
        }
        votes.add(new VoteEntry(team, rating));
        System.out.println("The team " + team.getTeamName() + " received a score of " + rating);
    }
    
    public void publishRanking() {
        if (votes.isEmpty()) {
            System.out.println("No scores have been registered in the ranking.");
            return;
        }
        
        // Ordina i team per punteggio
        List<VoteEntry> sortedVotes = new ArrayList<>(votes);
        sortedVotes.sort((a, b) -> b.rating - a.rating);

        System.out.println("Final ranking:");
        int position = 1;
        for (VoteEntry entry : sortedVotes) {
            System.out.println(position + ". " + entry.team.getTeamName() + " - Score: " + entry.rating);
            position++;
        }
    }

    private class CommentEntry {
        Team team;
        String comment;

        CommentEntry(Team team, String comment) {
            this.team = team;
            this.comment = comment;
        }
    }
    
    private class VoteEntry {
        Team team;
        int rating;

        VoteEntry(Team team, int rating) {
            this.team = team;
            this.rating = rating;
        }
    }
}
