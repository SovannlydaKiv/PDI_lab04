import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
    
    public class ex02{
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of files to create:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<FileWriter> file = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            File f = new File("C:\\Users\\Admin\\Documents\\PDI\\TP04\\Ex2LuckyNumber" + (i + 1) + ".csv");
            file.add(new FileWriter(f));
        }
             for (int i = 0; i < 100; i++) {
                n = r.nextInt(1,500);
                file.get(i).write(n + "\n");
            }

    }
}