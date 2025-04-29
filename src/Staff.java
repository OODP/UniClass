import java.util.Scanner;

public class Staff extends User {

    public Staff(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        System.out.println("Hello Staff!");
        System.out.println("1. View Courses");
        System.out.println("2. Manage Students");
        System.out.println("3. View Grades");
        System.out.println("4. Logout");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Viewing Courses...");
                break;
            case 2:
                System.out.println("Managing Students...");
                break;
            case 3:
                System.out.println("Viewing Grades...");
                break;
            case 4:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
