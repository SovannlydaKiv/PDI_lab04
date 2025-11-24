import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Admin\\Documents\\PDI\\CandidatePerformanceTest.csv");
        Scanner read = new Scanner(file);

        read.nextLine();
        read.nextLine();
        read.nextLine();

        List<String[]> Storage = new ArrayList<>();
    
        while (read.hasNextLine()) {
            Storage.add(read.nextLine().split(","));
        }
        read.close();

        score stats = new score();

        stats.getStats(Storage, 1, 0);
        print("total candidates:", stats.total, stats.male, stats.female);

        stats.getStats(Storage, 90f, 9);
        print("candidates with an average of at least 90: ", stats.total, stats.male, stats.female);

        stats.getStats(Storage, 85f, 5, 8);
        print("candidates' subject score of at least 85: ", stats.total, stats.male, stats.female);

        String[] groups = { "A", "B", "C", "D", "E" };
        for (String g : groups) {
            stats.getStats(Storage, "group " + g, 2);
            print("group " + g + " students: ", stats.total, stats.male, stats.female);
        }
    }

    public static void print(String title, int total, int male, int female) {
        System.out.println();
        System.out.println(title + " " + total);
        if (total > 0) {
            System.out.printf("male: %.2f%%\n", (male * 100f / total));
            System.out.printf("female: %.2f%%\n", (female * 100f / total));
        }
    }

public static class score {
    int total;
    int male;
    int female;

    public void getStats(List<String[]> Storage, String condition, int column) {
        total = male = female = 0;

        for (String[] row : Storage) {
            if (condition.equalsIgnoreCase(row[column])) {
                total++;
                String gender = row[1];
                if (gender.equalsIgnoreCase("male")) male++;
                else if (gender.equalsIgnoreCase("female")) female++;
            }
        }
    }

    public void getStats(List<String[]> Storage, float condition, int column) {
        total = male = female = 0;

        for (String[] row : Storage) {
            float value = Float.parseFloat(row[column]);
            if (value >= condition) {
                total++;
                String gender = row[1];
                if (gender.equalsIgnoreCase("male")) male++;
                else if (gender.equalsIgnoreCase("female")) female++;
            }
        }
    }

    public void getStats(List<String[]> Storage, float condition, int column1, int column2) {
        total = male = female = 0;

        for (String[] row : Storage) {
            boolean meetsAll = true;

            for (int j = column1; j <= column2; j++) {
                float value = Float.parseFloat(row[j]);
                if (value < condition) { 
                    meetsAll = false;
                    break;
                }
            }

            if (meetsAll) {
                total++;
                String gender = row[1];
                if (gender.equalsIgnoreCase("male")) male++;
                else if (gender.equalsIgnoreCase("female")) female++;
            }
        }
    }
}
}
