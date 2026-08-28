import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        
        String inputName = "scores.txt";
        String outputName = "report.txt";

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputName);
        if (scores.isEmpty()) {
            System.out.println("No valid scores found. Report not generated.");
            return;
        }
        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90) countA++;
            else if (score >= 80) countB++; 
            else if (score >= 70) countC++; 
            else if (score >= 60) countD++; 
            else countF++; 
        }
        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, countA, countB, countC, countD, countF, outputName);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        String line;
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid line found");
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) return 0.0;
        double sum = 0;        
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, 
                                    int countA, int countB, int countC, int countD, int countF,
                                    String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String report = String.format("Average score: %.2f%n", avg);
            report += String.format("Highest score: %d%n", high);
            report += String.format("Lowest score: %d%n", low);
            report += "\n";
            report += "Grade distribution:\n";
            report += String.format(" %-14s%d%n", "A (90 - 100):", countA);
            report += String.format(" %-14s%d%n", "B (80 - 89):", countB);
            report += String.format(" %-14s%d%n", "C (70 - 79):", countC);
            report += String.format(" %-14s%d%n", "D (60 - 69):", countD);
            report += String.format(" %-14s%d%n", "F (Below 60):", countF);
            writer.write(report);
            System.out.println(report);

        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }
}