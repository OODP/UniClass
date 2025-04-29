import java.util.Scanner;

public class Student extends User {

    public Student(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        System.out.println("Hello Student!");
        System.out.println("1. View Courses");
        System.out.println("2. View Grades");
        System.out.println("3. Logout");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Viewing Courses...");
                break;
            case 2:
                System.out.println("Viewing Grades...");
                break;
            case 3:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
