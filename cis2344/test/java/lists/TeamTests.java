package lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTests {

    Team team;

    @BeforeEach
    void CreateDefaultTeam() {
        team = new Team("Manchester City");
    }

    @Test
    void CreateTeam() {
        assertEquals(team.getName(), "Manchester City");
    }

    @Test
    void AddWinToTeam() {
        team.addWins(2);

        assertEquals(team.getWins(), 2);
    }

    @Test
    void AddDrawToTeam() {
        team.addDraws(3);

        assertEquals(team.getDraws(), 3);
    }

    @Test
    void AddLossToTeam() {
        team.addLosses(1);

        assertEquals(team.getLosses(), 1);
    }

    @Test
    void AddScoreToTeam() {
        team.addWins(3);
        team.addDraws(2);
        team.addLosses(5);
        assertEquals(team.getScore(), (3 * 3) + 2);
    }
}
