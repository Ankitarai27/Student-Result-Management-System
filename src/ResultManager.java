import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private List<Student> students = new ArrayList<>();
    private final String FILE_PATH = "data/students.txt";

    public ResultManager() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added and saved successfully.");
    }

    public void displayAllResults() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                bw.write(
                    s.getId() + "," +
                    s.toString()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1].split(": ")[1];
                int total = Integer.parseInt(data[2].split(": ")[1]);

                // Recalculate marks equally (simple approach)
                int mark = total / 3;
                students.add(new Student(id, name, mark, mark, mark));
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }
}
