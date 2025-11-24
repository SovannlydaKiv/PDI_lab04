import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ex04 {

    public static class Student {
    String ID;
    String name;
    String gender;

    Student(String ID, String name, String gender) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }
}
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

    try {

        File file = new File("C:\\Users\\Admin\\Documents\\PDI\\TP04_files\\Ex3StudentData.csv");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(",");
            if (split.length < 3) {
    continue; 
}
            students.add(new Student(split[0], split[1], split[2]));
        }
        scan.close();

        System.out.printf("%-12s %-15s %-10s\n", "ID", "Name", "Gender");
        System.out.println("----------------------------------------");
            for (Student s : students) {
            System.out.printf("%-12s %-15s %-10s\n", s.name, s.ID, s.gender);
        }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}