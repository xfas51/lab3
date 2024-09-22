import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        List<String> students = readStudentsFromFile("students.txt");
        for (String student : students) {
            System.out.println(student);}

    }
    public static List<String> readStudentsFromFile(String filename) {
        List<String> students = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                students.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return students;
    }


}
