public class Team {
    private int index;
    private int ranking;
    private String name;
    private int seed; 
    private String region; //TODO: Implement Region
    private String conf; // Conference
    private String record; // Record formatted as W-L

    //Adjusted Efficiency Margins Overall/Offensive/Defensive including overall rank
    private double adjEM;
    private double adjO;
    private int adjORank;
    private double adjD;
    private int adjDRank;
    private double adjT;
    private int adjTRank;

    // Luck 
    private double luck;
    private int luckRank;

    // Strength of Schedule
    private double sosAdjEM;
    private int sosAdjEMRank;
    private double sosOppO;
    private int sosOppORank;
    private double sosOppD;
    private int sosOppDRank;

    // Non-Conference Strength of Schedule
    private double ncsosAdjEM;
    private int ncsosAdjEMRank;

    public Team(String[] teamValues) {
        this.index= Integer.parseInt(teamValues[0]); // Assuming the first value is the index
        this.ranking = Integer.parseInt(teamValues[1]);;
        this.name = teamValues[2];
        this.seed = Integer.parseInt(teamValues[3]);
        
        this.region = null; // TODO: Implement Region
        this.conf = teamValues[4];  
        this.record = teamValues[5];
        this.adjEM = Double.parseDouble(teamValues[6]);
        this.adjO = Double.parseDouble(teamValues[7]);
        this.adjORank = Integer.parseInt(teamValues[8]);
        this.adjD = Double.parseDouble(teamValues[9]);
        this.adjDRank = Integer.parseInt(teamValues[10]);
        this.adjT = Double.parseDouble(teamValues[11]);
        this.adjTRank = Integer.parseInt(teamValues[12]);
        this.luck = Double.parseDouble(teamValues[13]);
        this.luckRank = Integer.parseInt(teamValues[14]);
        this.sosAdjEM = Double.parseDouble(teamValues[15]);
        this.sosAdjEMRank = Integer.parseInt(teamValues[16]);
        this.sosOppO = Double.parseDouble(teamValues[17]);
        this.sosOppORank = Integer.parseInt(teamValues[18]);
        this.sosOppD = Double.parseDouble(teamValues[19]);
        this.sosOppDRank = Integer.parseInt(teamValues[20]);
        this.ncsosAdjEM = Double.parseDouble(teamValues[21]);
        this.ncsosAdjEMRank = Integer.parseInt(teamValues[22]);
    }

    public String toString() {
        return "Team{\n" +
            "  index=" + index + ",\n" +
            "  name='" + name + "',\n" +
            "  seed=" + seed + ",\n" +
            "  ranking=" + ranking + ",\n" +
            "  conf='" + conf + "',\n" +
            "  record='" + record + "',\n" +
            "  adjEM='" + adjEM + "',\n" +
            "  adjO='" + adjO + "',\n" +
            "  adjORank='" + adjORank + "',\n" +
            "  adjD='" + adjD + "',\n" +
            "  adjDRank='" + adjDRank + "',\n" +
            "  adjT='" + adjT + "',\n" +
            "  adjTRank='" + adjTRank + "',\n" +
            "  luck='" + luck + "',\n" +
            "  luckRank='" + luckRank + "',\n" +
            "  sosAdjEM='" + sosAdjEM + "',\n" +
            "  sosAdjEMRank='" + sosAdjEMRank + "',\n" +
            "  sosOppO='" + sosOppO + "',\n" +
            "  sosOppORank='" + sosOppORank + "',\n" +
            "  sosOppD='" + sosOppD + "',\n" +
            "  sosOppDRank='" + sosOppDRank + "',\n" +
            "  ncsosAdjEM='" + ncsosAdjEM + "',\n" +
            "  ncsosAdjEMRank='" + ncsosAdjEMRank + "'\n" +
            "}";
    }

    public int getIndex() {
        return index;
    }
    
    public int getRanking() {
        return ranking;
    }
    
    public String getName() {
        return name;
    }

    public int getSeed() {
        return seed;
    }

    public String getRegion() {
        return region;
    }

    public String getConf() {
        return conf;
    }

    public String getRecord() {
        return record;
    }

    public double getAdjEM() {
        return adjEM;
    }

    public double getAdjO() {
        return adjO;
    }

    public int getAdjORank() {
        return adjORank;
    }

    public double getAdjD() {
        return adjD;
    }

    public int getAdjDRank() {
        return adjDRank;
    }

    public double getAdjT() {
        return adjT;
    }

    public int getAdjTRank() {
        return adjTRank;
    }

    public double getLuck() {
        return luck;
    }

    public int getLuckRank() {
        return luckRank;
    }

    public double getSosAdjEM() {
        return sosAdjEM;
    }

    public int getSosAdjEMRank() {
        return sosAdjEMRank;
    }

    public double getSosOppO() {
        return sosOppO;
    }

    public int getSosOppORank() {
        return sosOppORank;
    }

    public double getSosOppD() {
        return sosOppD;
    }

    public int getSosOppDRank() {
        return sosOppDRank;
    }

    public double getNcsosAdjEM() {
        return ncsosAdjEM;
    }

    public int getNcsosAdjEMRank() {
        return ncsosAdjEMRank;
    }

    public void compareTo(Team other) {
        
    }

}
