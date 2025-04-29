import java.util.Scanner;

public class Staff extends User {

    public Staff(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. 개설 허락할 과목 선택");
            System.out.println("2. 개설 불허할 과목 선택");
            System.out.println("3. 개설 요청 과목 목록 보기");
            System.out.print("4. Logout\n=> ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("리스트 보여주고, 개설 허락할 과목 선택...");
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    System.out.println("리스트 보여주고, 개설 불허할 과목 선택...");
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    System.out.println("개설 요청 과목 목록 보기...");
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
