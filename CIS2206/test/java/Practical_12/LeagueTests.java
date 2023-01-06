package Practical_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueTests {
    FootballLeague league;
    Team team1, team2, team3;

    @BeforeEach
    void CreateDefaultLeague() {
        league = new FootballLeague("Standard");
        team1 = new Team("Manchester City");
        team2 = new Team("Manchester United");
        team3 = new Team("Liverpool");

        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
    }

    @Test
    void CreateLeagueWithTeams() {
        assertEquals(0, league.getTeamPosition(team1));
        assertEquals(1, league.getTeamPosition(team2));
        assertEquals(2, league.getTeamPosition(team3));
    }

    @Test
    void LeagueTeamsOrderedByScore() {
        league.declareWin(team1, team2);
        league.declareDraw(team2, team3);
        league.declareWin(team3, team1);

        assertEquals(1, league.getTeamPosition(team1));
        assertEquals(2, league.getTeamPosition(team2));
        assertEquals(0, league.getTeamPosition(team3));
    }

    @Test
    void LeagueTeamsAdditionalScoreChanges() {
        league.declareWin(team1, team2);
        league.declareDraw(team2, team3);
        league.declareWin(team3, team1);

        league.declareWin(team1, team1);

        league.declareWin(team2, team1);
        league.declareWin(team3, team2);
        league.declareWin(team1, team3);

        league.declareDraw(team3, team3);

        league.declareDraw(team2, team3);
        league.declareDraw(team1, team2);
        league.declareDraw(team1, team3);

        league.declareDraw(team1, team3);

        assertEquals(9, team1.getScore());
        assertEquals(6, team2.getScore());
        assertEquals(10, team3.getScore());

        assertEquals(1, league.getTeamPosition(team1));
        assertEquals(2, league.getTeamPosition(team2));
        assertEquals(0, league.getTeamPosition(team3));
    }

    @Test
    void LeagueTeamRemoval() {
        league.declareWin(team1, team2);
        league.declareDraw(team2, team3);
        league.declareWin(team3, team1);

        league.removeTeam(team1);
        assertEquals(-1, league.getTeamPosition(team1));
        assertEquals(1, league.getTeamPosition(team2));
        assertEquals(0, league.getTeamPosition(team3));
    }

    @Test
    void LeagueTeamAddition() {
        league.declareWin(team1, team2);
        league.declareDraw(team2, team3);
        league.declareWin(team3, team1);

        var team4 = new Team("Arsenal");
        team4.addWins(10);
        team4.addLosses(15);
        league.addTeam(team4);

        assertEquals(2, league.getTeamPosition(team1));
        assertEquals(3, league.getTeamPosition(team2));
        assertEquals(1, league.getTeamPosition(team3));
        assertEquals(0, league.getTeamPosition(team4));
    }

    @Test
    void LeagueTeamRelegate() {
        league.declareWin(team1, team2);
        league.declareDraw(team2, team3);
        league.declareWin(team3, team1);

        var team4 = new Team("Arsenal");
        team4.addWins(10);
        team4.addLosses(15);
        league.addTeam(team4);

        league.relegateTeams(null, 2);
        assertEquals(-1, league.getTeamPosition(team1));
        assertEquals(-1, league.getTeamPosition(team2));
        assertEquals(1, league.getTeamPosition(team3));
        assertEquals(0, league.getTeamPosition(team4));
    }

    @Test
    void LeagueTeamRelegateToAnotherLeague() {
        var lowerLeague = new FootballLeague("Lowers");

        league.declareWin(team1, team2);
        league.declareDraw(team2, team3);
        league.declareWin(team3, team1);

        var team4 = new Team("Arsenal");
        team4.addWins(10);
        team4.addLosses(15);
        league.addTeam(team4);

        league.relegateTeams(lowerLeague, 2);
        assertEquals(-1, league.getTeamPosition(team1));
        assertEquals(-1, league.getTeamPosition(team2));
        assertEquals(1, league.getTeamPosition(team3));
        assertEquals(0, league.getTeamPosition(team4));

        assertEquals(0, lowerLeague.getTeamPosition(team1));
        assertEquals(1, lowerLeague.getTeamPosition(team2));
        assertEquals(-1, lowerLeague.getTeamPosition(team3));
        assertEquals(-1, lowerLeague.getTeamPosition(team4));
    }
}
