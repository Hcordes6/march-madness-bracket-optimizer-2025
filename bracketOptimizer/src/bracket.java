import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class bracket {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\hcord\\OneDrive\\Desktop\\March Madness Project Folder\\Kenpom 2025 data Just Copy and Paste - Sheet1.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // To skip header

            while ((line = br.readLine()) != null) {
                if (firstLine) { 
                    firstLine = false; // Skip header
                    continue;
                }

                String[] values = line.split(","); // Split by comma
                int rank = Integer.parseInt(values[0]);
                String team = values[1];
                String conf = values[2];
                int netRegRank = Integer.parseInt(values[20]);

                

                Team auburn = new Team(values);


                System.out.println("Rank: " + rank + ", Team: " + team + ", Conference: " + conf +", Net Reg Rank: " + netRegRank);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
