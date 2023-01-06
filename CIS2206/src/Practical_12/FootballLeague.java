package Practical_12;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class FootballLeague {
    private String name;
    private LinkedList<Team> teams;
    private Comparator<Team> teamComparator;

    public FootballLeague(String name) {
        this.name = name;
        teams = new LinkedList<>();
        teamComparator = new TeamScoreComparator().reversed();
    }

    public String getName() {
        return name;
    }

    public int getTeamPosition(Team team) {
        // Team is not valid.
        if (team == null)
            return -1;

        return teams.indexOf(team);
    }

    public void addTeam(Team team) {
        // Team is not valid so it cannot be added.
        if (team == null)
            return;

        // Don't allow duplicate teams.
        if (teams.contains(team))
            return;

        teams.add(team);
        teams.sort(teamComparator);
    }

    public void addTeams(Collection<Team> teams) {
        this.teams.addAll(teams);
        this.teams.sort(teamComparator);
    }

    public void removeTeam(Team team) {
        // Team is not valid so it cannot be removed.
        if (team == null)
            return;

        teams.remove(team);
        teams.sort(teamComparator);
    }

    public void declareWin(Team victor, Team loser) {
        // A team cannot be the winner and loser.
        if (victor == loser)
            return;

        // If a victor was provided, give them a win.
        if (victor != null)
            victor.addWins(1);
        // If a loser was provided, give them a loss.
        if (loser != null)
            loser.addLosses(1);

        teams.sort(teamComparator);
    }

    public void declareDraw(Team team1, Team team2) {
        // A team cannot tie with themselves.
        if (team1 == team2)
            return;

        if (team1 != null)
            team1.addDraws(1);
        if (team2 != null)
            team2.addDraws(1);

        teams.sort(teamComparator);
    }

    public void relegateTeams(FootballLeague lowerLeague, int lowestX) {
        // For this relegation feature, I want to combine for-loop-like functionality with
        // for-each-loop-like functionality. One way to do this is to use a while loop with an iterator.

        // Gets an iterator for the teams so we can process them in a descending sequential order.
        var itr = teams.descendingIterator();

        // Keep going until the iterator has reached the maximum or the number of specified teams
        // have been processed.
        while (lowestX > 0 && itr.hasNext())
        {
            // Get a reference to the next team.
            Team teamToRelegate = itr.next();
            // Remove the recently acquired team from the underlying teams list (this league).
            itr.remove();

            // If a lower league was specified, moves this team to the new league.
            if (lowerLeague != null)
                lowerLeague.addTeam(teamToRelegate);

            lowestX--;
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(100);

        sb.append(name + " League Table");
        sb.append("\n---------------------");

        for (var team : teams) {
            sb.append("\n");
            sb.append(team.toString());
        }

        sb.append("\n");

        return sb.toString();
    }
}
