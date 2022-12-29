package lists;

import java.util.Comparator;

public class Team {
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private int cachedScore;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        updateScore();
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        updateScore();
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getScore() {
        return cachedScore;
    }

    protected int calculateScore() {
        return (3 * wins) + draws;
    }

    protected void updateScore() {
        cachedScore = calculateScore();
    }

    public int addWins(int wins) {
        setWins(getWins() + wins);
        return getWins();
    }

    public int addDraws(int draws) {
        setDraws(getDraws() + draws);
        return getDraws();
    }

    public int addLosses(int losses) {
        setLosses(getLosses() + losses);
        return getLosses();
    }

    @Override
    public String toString() {
        return "Team " + name +
                " (Wins: " + wins +
                ", Draws: " + draws +
                ", Losses: " + losses +
                ", Score: " + cachedScore + ")";
    }
}

class TeamScoreComparator implements Comparator<Team> {

    @Override
    public int compare(Team team1, Team team2) {
        if (team1 == null)
            return -1;
        if (team2 == null)
            return 1;

        int scoreComparison = Integer.compare(team1.getScore(), team2.getScore());
        if (scoreComparison != 0)
            return scoreComparison;

        // If same score, compare by win/loss ratio instead. +1 losses to prevent divided by 0.
        return Float.compare(
                (float)team1.getWins() / (float)team1.getLosses() + 1,
                (float)team2.getWins() / (float)team2.getLosses() + 1);
    }
}
