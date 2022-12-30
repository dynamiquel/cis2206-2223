package Practical_12;

import java.util.HashMap;
import java.util.Map;

public class Dashboard {
    private FootballLeague league;

    public Map<String, Team> createDefaultTeams() {
        var teams = new HashMap<String, Team>(6);

        teams.put("England", new Team("England"));
        teams.put("Scotland", new Team("Scotland"));
        teams.put("Wales", new Team("Wales"));
        teams.put("Ireland", new Team("Ireland"));
        teams.put("France", new Team("France"));
        teams.put("Germany", new Team("Germany"));

        return teams;
    }

    public Map<String, FootballLeague> createDefaultLeagues() {
        var leagues = new HashMap<String, FootballLeague>(2);

        leagues.put("Standard", new FootballLeague("Standard"));
        leagues.put("Lowers", new FootballLeague("Lowers"));
        return leagues;
    }

    public void addDefaultTeams(Map<String, Team> teams, Map<String, FootballLeague> leagues) {
        leagues.get("Standard").addTeam(teams.get("England"));
        leagues.get("Standard").addTeam(teams.get("Scotland"));
        leagues.get("Standard").addTeam(teams.get("Wales"));
        leagues.get("Standard").addTeam(teams.get("Ireland"));
        leagues.get("Standard").addTeam(teams.get("France"));
        leagues.get("Standard").addTeam(teams.get("Germany"));
        System.out.println(leagues.get("Standard").toString());
    }

    public void removeTeams(Map<String, Team> teams, Map<String, FootballLeague> leagues) {
        leagues.get("Standard").removeTeam(teams.get("Scotland"));
        System.out.println(leagues.get("Standard").toString());
    }

    public void relegateTeams(Map<String, Team> teams, Map<String, FootballLeague> leagues) {
        leagues.get("Standard").relegateTeams(leagues.get("Lowers"), 3);
        System.out.println(leagues.get("Standard").toString());
        System.out.println(leagues.get("Lowers").toString());
    }

    public void addScoreToTeams(Map<String, Team> teams, Map<String, FootballLeague> leagues) {
        leagues.get("Standard").declareWin(teams.get("England"), teams.get("Wales"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareWin(teams.get("France"), teams.get("Germany"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareDraw(teams.get("Ireland"), teams.get("Scotland"));
        System.out.println(leagues.get("Standard").toString());

        leagues.get("Standard").declareWin(teams.get("England"), teams.get("Germany"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareWin(teams.get("England"), teams.get("Scotland"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareWin(teams.get("France"), teams.get("Ireland"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareDraw(teams.get("Germany"), teams.get("Wales"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareWin(teams.get("Wales"), teams.get("Ireland"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareDraw(teams.get("Wales"), teams.get("Scotland"));
        System.out.println(leagues.get("Standard").toString());

        leagues.get("Standard").declareWin(teams.get("France"), teams.get("England"));
        System.out.println(leagues.get("Standard").toString());
        leagues.get("Standard").declareDraw(teams.get("France"), teams.get("Germany"));
        System.out.println(leagues.get("Standard").toString());
    }
}
