import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        List<String> students = readStudentsFromFile("students.txt");
        for (String student : students) {
            System.out.println(student);
        }
        int groupSize = 2; 
        List<List<String>> groups = createRandomGroups(students, groupSize);
            
        for (List<String> group : groups) {
            System.out.println(groups);
        }
    

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
    public static List<List<String>> createRandomGroups(List<String> students, int groupSize) {
        Collections.shuffle(students); // Shuffle the student list
        List<List<String>> groups = new ArrayList<>();
        
        for (int i = 0; i < students.size(); i += groupSize) {
            int end = Math.min(i + groupSize, students.size());
            groups.add(new ArrayList<>(students.subList(i, end)));
        }
        
        return groups;
    }

}
