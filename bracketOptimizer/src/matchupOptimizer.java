import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// WHEN BACK NEXT TIME: NEED TO FIX COPYING EACH LINE INTO THE 2D ARRAY


public class matchupOptimizer {
    public static void main(String[] args) throws Exception {
        int columnsTeams = 21; // TODO: Change this when we change the CSV file for seeding
        int rowsTeams = 40;
        String filePath = "C:\\Users\\hcord\\OneDrive\\Desktop\\March Madness Project Folder\\Kenpom 2025 data Just Copy and Paste - Sheet1.csv";
        String[][] teams = new String[rowsTeams][columnsTeams];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // Use this to create a 2D array of all of the teams in the CSV File
            String line;
            boolean firstLine = true; // To skip header

            while ((line = br.readLine()) != null) {
                if (firstLine) { 
                    firstLine = false; // Skip header
                    continue;
                }

                String[] values = line.split(","); // Split by comma
                for (int i = 0; i <= rowsTeams; i++) {
                    teams[i] = values;
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < rowsTeams; i++) {
            System.out.println(teams[1][i]);
        }



        // Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the team you would like to see the matchup for: ");
    }
}
