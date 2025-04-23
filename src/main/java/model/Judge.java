package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Judge extends User {
    public boolean isHeadJudge;

    public Judge(String username, String email, String password, boolean isHeadJudge) {
        super(username, email, password);
        this.isHeadJudge = isHeadJudge;
    }

    public void publishProblem(Hackathon hackathon, String problemStatement) {
        if (isHeadJudge) {
            hackathon.setProblemStatement(problemStatement);
            System.out.println("Problem statement: " + problemStatement);
        }
    }

    public void addFeedback(String comment, Document document) {
        document.addComment(comment);
    }

    public void rateTeam(Team team, int score) {
        if (score < 0 || score > 10) {
            System.out.println("The score must be between 0 and 10: re-try.");
        } else {
            team.setScore(score);
        }
    }

    public void setFinalScore(ArrayList<Team> teams) {
        float average = 0;

        for (Team t : teams) {
            for (Float f : t.getScores()) {
                average += f;
            }
            average /= t.getScores().size();
            t.setFinalScore(average);
        }
    }

    public void publishRanking(ArrayList<Team> teams) {
        teams.sort(Comparator.comparing(Team::getFinalScore).reversed());

        System.out.println("Ranking:");
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            System.out.printf("%d. %s - %.2f%n", i + 1, team.getTeamName(), team.getFinalScore());
        }
    }
}
