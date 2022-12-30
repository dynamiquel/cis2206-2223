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
        if (team == null)
            return -1;

        return teams.indexOf(team);
    }

    public void addTeam(Team team) {
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
        if (team == null)
            return;

        teams.remove(team);
        teams.sort(teamComparator);
    }

    public void declareWin(Team victor, Team loser) {
        // Cannot be winner and loser.
        if (victor == loser)
            return;

        if (victor != null)
            victor.addWins(1);
        if (loser != null)
            loser.addLosses(1);

        teams.sort(teamComparator);
    }

    public void declareDraw(Team team1, Team team2) {
        // Cannot tie with self.
        if (team1 == team2)
            return;

        if (team1 != null)
            team1.addDraws(1);
        if (team2 != null)
            team2.addDraws(1);

        teams.sort(teamComparator);
    }

    public void relegateTeams(FootballLeague lowerLeague, int lowestX) {

        var itr = teams.descendingIterator();

        // Keep going until the iterator has reached the maximum or the number of specified teams
        // have been processed.
        while (lowestX > 0 && itr.hasNext())
        {
            Team teamToRelegate = itr.next();
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
