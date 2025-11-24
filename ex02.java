import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class ex02 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of files to create: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Random r = new Random();
        ArrayList<FileWriter> fileWriters = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            File f = new File("C:\\Users\\Admin\\Documents\\PDI\\TP04\\Ex2LuckyNumber" + (i + 1) + ".csv");
            FileWriter fw = new FileWriter(f);
            fileWriters.add(fw);
        }

        for (int i = 0; i < 100; i++) {
            int randomNum = r.nextInt(1, 101);
            for (int j = 0; j < n; j++) {
                fileWriters.get(j).write(randomNum + "\n");
            }
        }
        
        for (FileWriter fw : fileWriters) {
            fw.close();
        }
        
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\Admin\\Documents\\PDI\\TP04\\Ex2LuckyNumber" + (i + 1) + ".csv"));
            while (fileScanner.hasNextInt()) {
                allNumbers.add(fileScanner.nextInt());
            }
            fileScanner.close();
        }
        
        int max = Collections.max(allNumbers);
        int min = Collections.min(allNumbers);
        
        System.out.println("Maximum number: " + max);
        System.out.println("Minimum number: " + min);
        
        input.close();
    }
}