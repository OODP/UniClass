import java.util.Scanner;

public class Student extends User {

    public Student(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("1. 수강 신청, ");
            System.out.println("2. 수강 신청 취소");
            System.out.print("3. 예비 수강 신청, ");
            System.out.println("4. 예비 수강 신청 취소");
            System.out.print("5. 수강 대기 신청, ");
            System.out.println("6. 수강 대기 신청 취소");
            System.out.print("7. Logout\n=> ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. 수강 신청...");
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    System.out.println("2. 수강 신청 취소...");
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    System.out.println("3. 예비 수강 신청...");
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    System.out.println("4. 예비 수강 신청 취소...");
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("5. 수강 대기 신청...");
                    System.out.println("----------------------------------------");
                    break;
                case 6:
                    System.out.println("6. 수강 대기 신청 취소...");
                    System.out.println("----------------------------------------");
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
