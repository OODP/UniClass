import java.util.Scanner;

public class Student extends User {

    public Student(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ 학생 메뉴 =================");
            System.out.println(" 1. 📚 수강 신청");
            System.out.println(" 2. ❌ 수강 신청 취소");
            System.out.println(" 3. 📝 예비 수강 신청");
            System.out.println(" 4. ❌ 예비 수강 신청 취소");
            System.out.println(" 5. 🕒 수강 대기 신청");
            System.out.println(" 6. ❌ 수강 대기 신청 취소");
            System.out.println(" 7. 🔒 로그아웃");
            System.out.println("============================================");
            System.out.print("👉 선택하세요 (1-7): ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("🔷 [수강 신청]");
                    // 수강 신청 기능 구현 예정
                    break;

                case 2:
                    System.out.println("🔷 [수강 신청 취소]");
                    // 수강 신청 취소 기능 구현 예정
                    break;

                case 3:
                    System.out.println("🔷 [예비 수강 신청]");
                    // 예비 수강 신청 기능 구현 예정
                    break;

                case 4:
                    System.out.println("🔷 [예비 수강 신청 취소]");
                    // 예비 수강 신청 취소 기능 구현 예정
                    break;

                case 5:
                    System.out.println("🔷 [수강 대기 신청]");
                    // 수강 대기 신청 기능 구현 예정
                    break;

                case 6:
                    System.out.println("🔷 [수강 대기 신청 취소]");
                    // 수강 대기 신청 취소 기능 구현 예정
                    break;

                case 7:
                    System.out.println("👋 로그아웃합니다...");
                    return;

                default:
                    System.out.println("❗ 잘못된 선택입니다. 다시 입력하세요.");
            }

            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 개행 제거
            sc.nextLine(); // 사용자 입력 대기
        }
    }
}
