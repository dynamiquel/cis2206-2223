package lists;

public class Main {
    public static void main(String[] args) {
        var dashboard = new Dashboard();
        var teams = dashboard.createDefaultTeams();
        var leagues = dashboard.createDefaultLeagues();

        dashboard.addDefaultTeams(teams, leagues);
        dashboard.addScoreToTeams(teams, leagues);
        dashboard.removeTeams(teams, leagues);
        dashboard.relegateTeams(teams, leagues);
    }
}
