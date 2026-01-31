import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResultManager manager = new ResultManager();
        System.out.println("Data loaded from file successfully.");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Result Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Results");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks 1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter Marks 2: ");
                    int m2 = sc.nextInt();
                    System.out.print("Enter Marks 3: ");
                    int m3 = sc.nextInt();

                    Student student = new Student(id, name, m1, m2, m3);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.displayAllResults();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();
                    Student found = manager.searchById(searchId);
                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
