import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class matchupOptimizer {
    public static void main(String[] args) throws Exception {
        int columnsTeams = 20; // TODO: Change this when we change the CSV file for seeding
        int rowsTeams = 40;
        String filePath = "C:\\Users\\hcord\\OneDrive\\Desktop\\March Madness Project Folder\\Kenpom 2025 data Just Copy and Paste - Sheet1.csv";
        String[][] teams = new String[rowsTeams][columnsTeams+1]; // 2D array of all of the teams in the CSV File
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // Use this to create a 2D array of all of the teams in the CSV File
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



//----------------------------Start of User Input----------------------------------
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


// ----------------------------Preferred Stat Analysis-----------------------------------
        // Base-5 point system for each stat that matters

        int team1Score = 0;
        int team2Score = 0;
        
        // Conference Analysis
        if ((team1.getConf().equals("SEC")) || (team1.getConf().equals("B12")) || (team1.getConf().equals("B10")) || (team1.getConf().equals("ACC"))) {
            team1Score += 5;
        }
        if ((team2.getConf().equals("SEC")) || (team2.getConf().equals("B12")) || (team2.getConf().equals("B10")) || (team2.getConf().equals("ACC"))) {
            team2Score += 5;
        }

        // Wins + SOS Analysis
        if (Integer.parseInt(team1.getRecord().substring(0, 1)) > Integer.parseInt(team2.getRecord().substring(0, 1)) && team1.getSosAdjEM() > team2.getSosAdjEM()) {
            team1Score += 15;
        } else if (Integer.parseInt(team1.getRecord().substring(0, 1)) < Integer.parseInt(team2.getRecord().substring(0, 1)) && team1.getSosAdjEM() < team2.getSosAdjEM()) {
            team2Score += 15;
        }

        //

        // Win Calculator
        if (team1Score > team2Score) {
            System.out.println(team1.getName() + " is favored to win the matchup against " + team2.getName() + "!");
            System.out.println(team1Score + " - " + team2Score);
        } else if (team1Score < team2Score) {
            System.out.println(team2.getName() + " is favored to win the matchup against " + team1.getName() + "!");
            System.out.println(team1Score + " - " + team2Score);
        } else {
            System.out.println("The matchup between " + team1.getName() + " and " + team2.getName() + " is too close to call!");
        }
        
    }
}


// Graveyard:
// (line = br.readLine()) != null