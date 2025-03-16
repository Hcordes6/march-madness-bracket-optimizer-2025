import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class matchupOptimizer {
    public static void main(String[] args) throws Exception {
        int columnsTeams = 20; // TODO: Change this when we change the CSV file for seeding
        int rowsTeams = 40;
        String filePath = "C:\\Users\\hcord\\OneDrive\\Desktop\\March Madness Project Folder\\Kenpom 2025 data Just Copy and Paste - Sheet1.csv";
        String[][] teams = new String[rowsTeams][columnsTeams + 1]; // 2D array of all of the teams in the CSV File
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // Use this to create a 2D array of all
                                                                                 // of the teams in the CSV File
            int lineI = 0; // Line Iteration
            String line;
            boolean firstLine = true; // To skip header
            while (lineI < rowsTeams && (line = br.readLine()) != null) { // Holds limit to the amount of teams wanted
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }
                String[] values = line.split(","); // Split by comma
                for (int i = 0; i <= columnsTeams; i++) {
                    teams[lineI][i] = values[i];
                }
                lineI++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ----------------------------Start of User
        // Input----------------------------------
        Scanner scanner = new Scanner(System.in);
        // User Input for Team 1
        System.out.println("Enter the name of the first team you would like to see the matchup for: ");
        Team team1 = null;
        boolean team1Found = false;
        while (team1Found == false) {
            String teamName = scanner.next();
            for (int i = 0; i < rowsTeams; i++) {
                if (teams[i][1].equals(teamName)) {
                    team1 = new Team(teams[i]);
                    System.out.println(team1.toString());
                    team1Found = true;
                    break;
                }
            }
            if (team1Found == false) {
                System.out.println("Team not found. Please enter a valid team name (Case Sensitive): ");
            }
        }

        // User Input for Team 2
        System.out.println("Enter the name of the second team you would like to see the matchup for: ");
        Team team2 = null;
        boolean team2Found = false;
        while (team2Found == false) {
            String teamName = scanner.next();
            for (int i = 0; i < rowsTeams; i++) {
                if (teams[i][1].equals(teamName)) {
                    team2 = new Team(teams[i]);
                    System.out.println(team2.toString());
                    team2Found = true;
                    break;
                }
            }
            if (team2Found == false) {
                System.out.println("Team not found. Please enter a valid team name (Case Sensitive): ");
            } else if (team2.getName() == team1.getName()) {
                System.out.println("Invalid, Enter a NEW team name: ");
                team2Found = false;
            }
        }

        // ----------------------------Preferred Stat
        // Analysis-----------------------------------
        // Base-5 point system for each stat that matters

        int team1Score = 1;
        int team2Score = 1;

        int conferenceWeight = 5;
        int winSosWeight = 15;
        int adjEMWeight = 10;
        int adjOWeight = 10;

        // Conference Analysis
        if ((team1.getConf().equals("SEC")) || (team1.getConf().equals("B12")) || (team1.getConf().equals("B10"))
                || (team1.getConf().equals("ACC"))) {
            team1Score += conferenceWeight;
        }
        if ((team2.getConf().equals("SEC")) || (team2.getConf().equals("B12")) || (team2.getConf().equals("B10"))
                || (team2.getConf().equals("ACC"))) {
            team2Score += conferenceWeight;
        }

        // Wins + SOS Analysis
        if (Integer.parseInt(team1.getRecord().substring(0, 1)) > Integer.parseInt(team2.getRecord().substring(0, 1))
                && team1.getSosAdjEM() > team2.getSosAdjEM()) {
            team1Score += winSosWeight;
        } else if (Integer.parseInt(team1.getRecord().substring(0, 1)) < Integer
                .parseInt(team2.getRecord().substring(0, 1)) && team1.getSosAdjEM() < team2.getSosAdjEM()) {
            team2Score += winSosWeight;
        }

        // Adjusted Efficiency Margin Analysis
        if (team1.getAdjEM() > team2.getAdjEM()) {
            team1Score += adjEMWeight;
        } else if (team1.getAdjEM() < team2.getAdjEM()) {
            team2Score += adjEMWeight;
        }

        // Adjusted Offensive Efficiency Analysis
        if (team1.getAdjO() > team2.getAdjO()) {
            team1Score += adjOWeight;
        } else if (team1.getAdjO() < team2.getAdjO()) {
            team2Score += adjOWeight;
        }

        // Luck
        if(team1.getLuck() > team2.getLuck()) {
            team1Score += 5;
        } else if (team1.getLuck() < team2.getLuck()) {
            team2Score += 5;
        }

        // --------------------------- Win Calculator-----------------------------------

        // Compute win probability based on score difference
        double scoreDiff;
        boolean team1Favored;
        if (team1Score > team2Score) {
            scoreDiff = team1Score - team2Score;
            team1Favored = true;
        } else {
            scoreDiff = team2Score - team1Score;
            team1Favored = false;
        }

        // Calculate win probability using the score difference
        double weight = 0.1; // Adjust the weight for upset potential
        double winProbability = 1.0 - (1.0 / (1 + Math.exp(weight * scoreDiff)));

        // Determine which team is favored
        double randomNum = Math.random(); // Generate a random number between 0 and 1
        boolean upset = false;
        if(randomNum > winProbability) {
            team1Favored = !team1Favored; // Flip the favored team if random number is greater than win probability
            upset = true;
        }
        if (team1Favored && upset) {
            System.out.println(team2.getName() + " upsets with a score of " + team2Score + "and a win probability of " + (1 - winProbability) * 100 + "%");
            System.out.println("Win probability for Team 1: " + winProbability * 100 + "% with a score of " + team1Score);
        } else if (team1Favored) {
            System.out.println("Team 1 is favored to win!");
            System.out.println("Win probability for Team 1: " + winProbability * 100 + "% with a score of " + team1Score);
            System.out.println("Win probability for Team 2: " + (1 - winProbability) * 100 + "% with a score of " + team2Score);
        } else if(team1Favored == false && upset) {
            System.out.println(team1.getName() + " upsets with a score of " + team1Score + "and a win probability of " + (1- winProbability) * 100 + "%");
            System.out.println("Win probability for Team 2: " + winProbability * 100 + "% with a score of " + team2Score);
        } else if (team1Favored == false) {
            System.out.println("Team 2 is favored to win!");
            System.out.println("Win probability for Team 1: " + (1 - winProbability) * 100 + "% with a score of " + team1Score);
            System.out.println("Win probability for Team 2: " + winProbability * 100 + "% with a score of " + team2Score);
        }
    }
}

// Graveyard:
// (line = br.readLine()) != null