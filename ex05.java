import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex05 {

    public static class Student {
    String id;
    String name;
    String gender;

    Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + gender;
    }
}

public static void main(String[] args) {

    ArrayList<Student> students = new ArrayList<>();

    try {
        File file = new File("c:\\Users\\Admin\\Documents\\PDI\\TP04_files\\Ex3StudentData.csv");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(",");

            if (split.length >= 3) {
                students.add(new Student(split[0], split[1], split[2]));
            }
        }
        scan.close();

        students.add(new Student("P20240001", "Kiv Sovannlyda", "F"));
        students.add(new Student("P20240019", "Chiv Inthera", "F"));
        students.add(new Student("P20240003", "Sao Dali Inaco", "F"));

        Collections.sort(students, (a, b) -> a.name.compareToIgnoreCase(b.name));

        FileWriter writer = new FileWriter("c:\\Users\\Admin\\Documents\\PDI\\TP04_files\\Ex3StudentData.csv");
        for (Student s : students) {
            writer.write(s.toString() + "\n");
        }
        writer.close();

        System.out.println("Data successfully updated and saved!");

    } catch (FileNotFoundException e) {
        System.out.println("File not found!");
    } catch (IOException e) {
        System.out.println("Error writing to file.");
    }
}

}