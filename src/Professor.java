import java.util.Scanner;

public class Professor extends User {

    public Professor(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("1. 과목 개설 신청(Open), ");
            System.out.println("2. 과목 폐강 신청(Close)");
            System.out.println("3. 개설한 과목 정보 수정(Update)");
            System.out.println("4. 개설된 과목 목록 보기(View)");
            System.out.println("5. 학생들의 대기 신청 목록 보기(허락 / 불허 결정)");
            System.out.print("6. Logout\n=> ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("과목 개설 신청...");
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    System.out.println("과목 폐강 신청...");
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    System.out.println("개설한 과목 정보 수정...");
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    System.out.println("개설된 과목 목록 보기...");
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("학생들의 대기 신청 목록 보기...");
                    System.out.println("----------------------------------------");
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
