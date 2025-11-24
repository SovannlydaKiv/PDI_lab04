import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

    public class ex01 {
        public static void main(String[] args) throws IOException {
         File f = new File ("C:\\Users\\Admin\\Documents\\PDI\\TP04\\LuckyNumber.csv");
            FileWriter fw = new FileWriter(f);
            int n;
            Random r = new Random();
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < 500; i++) {
                n = r.nextInt(1,500);
                fw.write(n + "\n");
            }
        }
    
}
