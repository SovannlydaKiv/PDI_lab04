import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

    public class ex03 {
        public static void main(String[] args) throws IOException {
            File f = new File("C:\\Users\\Admin\\Documents\\PDI\\TP04_files\\Ex3StudentData.csv");
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < 3; i++) {
                String name, ID, gender;
                System.out.print("Enter student name: ");
                Scanner input = new Scanner(System.in);
                name = input.nextLine();
                System.out.print("Enter student ID: ");   
                ID = input.nextLine();
                System.out.print("Enter student gender: ");
                gender = input.nextLine();
                System.out.print("\n");
                fw.write (name + "," + ID + "," + gender + "\n");
            }
            fw.close();
        }
}
