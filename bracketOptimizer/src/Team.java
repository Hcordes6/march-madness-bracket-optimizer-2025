public class Team {
    private String name;
    private int ranking;
    private String conf;

    public Team(String[] teamValues) {
        this.ranking = Integer.parseInt(teamValues[0]);;
        this.name = teamValues[1];
        this.conf = teamValues[2];  
    }
}
