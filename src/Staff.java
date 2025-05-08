import java.util.List;
import java.util.Scanner;

public class Staff extends User {

    public Staff(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseManager courseManager = new CourseManager();

        while (true) {
            System.out.println("\n================ 스태프 메뉴 =================");
            System.out.println(" 0. 🔍 개설된 과목 목록");
            System.out.println(" 1. 📘 과목 개설 허락");
            System.out.println(" 2. ❌ 과목 개설 불허");
            System.out.println(" 3. 📋 개설 요청 과목 목록 보기");
            System.out.println(" 4. 🔒 로그아웃");
            System.out.println("===============================================");
            System.out.print("👉 선택하세요 (0-4): ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 0:
                    System.out.println("🔷 [개설된 과목 목록]");
                    courseManager.getOpenedCourses();
                    break;
                case 1:
                    System.out.println("🔷 [과목 개설 허락]");
                    List<Course> coursesToApprove = courseManager.getPendingCourses();
                    if (coursesToApprove.isEmpty()) {
                        System.out.println("⚠️ 개설 요청 과목이 없습니다.");
                        break;
                    }

                    printCourseList(coursesToApprove);

                    System.out.print(" - 허락할 과목 코드 입력: ");
                    String approveId = sc.next();
                    if (approveId == null || approveId.isEmpty()) {
                        System.out.println("❗ 잘못된 과목 코드입니다.");
                        break;
                    }

                    courseManager.openCourse(approveId);
                    System.out.println("✅ 과목 개설 허락 완료!");
                    break;

                case 2:
                    System.out.println("🔷 [과목 개설 불허]");
                    List<Course> coursesToReject = courseManager.getPendingCourses();
                    if (coursesToReject.isEmpty()) {
                        System.out.println("⚠️ 개설 요청 과목이 없습니다.");
                        break;
                    }

                    printCourseList(coursesToReject);

                    System.out.print(" - 불허할 과목 코드 입력: ");
                    String rejectId = sc.next();
                    if (rejectId == null || rejectId.isEmpty()) {
                        System.out.println("❗ 잘못된 과목 코드입니다.");
                        break;
                    }

                    courseManager.closeCourse(rejectId);
                    System.out.println("✅ 과목 개설 불허 완료!");
                    break;

                case 3:
                    System.out.println("🔷 [개설 요청 과목 목록]");
                    List<Course> pendingCourses = courseManager.getPendingCourses();
                    if (pendingCourses.isEmpty()) {
                        System.out.println("⚠️ 개설 요청 과목이 없습니다.");
                    } else {
                        printCourseList(pendingCourses);
                    }
                    break;

                case 4:
                    System.out.println("👋 로그아웃합니다...");
                    return;

                default:
                    System.out.println("❗ 잘못된 선택입니다. 다시 시도해주세요.");
            }

            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 개행 제거
            sc.nextLine(); // 사용자 입력 대기
        }
    }

    private void printCourseList(List<Course> courses) {
        System.out.printf("%-10s %-20s %-6s %-10s\n", "CourseID", "CourseName", "Credit", "Participants");
        System.out.println("--------------------------------------------------------------");
        for (Course c : courses) {
            System.out.printf("%-10s %-20s %-6d %-10d\n",
                    c.getCourseId(), c.getCourseName(), c.getCredit(), c.getParticipants());
        }
    }
}
