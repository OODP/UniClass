import java.util.List;
import java.util.Scanner;

public class Professor extends User {

    public Professor(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseManager courseManager = new CourseManager();

        while (true) {
            System.out.println("\n================ 교수 메뉴 =================");
            System.out.println(" 0. 🔍 개설된 과목 목록");
            System.out.println(" 1. 📘 과목 개설 신청 (Open)");
            System.out.println(" 2. ❌ 과목 폐강 신청 (Close)");
            System.out.println(" 3. ✏️  개설한 과목 정보 수정 (Update)");
            System.out.println(" 4. 📋 개설 신청 과목 목록 보기 (View)");
            System.out.println(" 5. 🧑‍🎓 학생 대기 신청 목록 확인 및 처리");
            System.out.println(" 6. 🔒 로그아웃");
            System.out.println("============================================");
            System.out.print("👉 선택하세요 (0-6): ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 0:
                    System.out.println("🔷 [개설된 과목 목록]");
                    courseManager.viewOpenedCourses();
                    break;

                case 1:
                    System.out.println("🔷 [과목 개설 신청]");
                    System.out.print(" - 과목 코드 입력: ");
                    String courseId = sc.next();
                    System.out.print(" - 과목명 입력: ");
                    String courseName = sc.next();
                    System.out.print(" - 학점 입력: ");
                    int credit = sc.nextInt();
                    System.out.print(" - 수강 인원 입력: ");
                    int participants = sc.nextInt();

                    courseManager.requestOpenCourse(courseId, courseName, credit, participants, this);
                    System.out.println("✅ 과목 개설 신청 완료!");
                    break;

                case 2:
                    System.out.println("🔷 [과목 폐강 신청]");
                    List<Course> closeCourses = courseManager.getPendingCourses();
                    if (closeCourses.isEmpty()) {
                        System.out.println("⚠️ 개설된 과목이 없습니다.");
                        break;
                    }

                    for (Course course : closeCourses) {
                        System.out.println(" - " + course);
                    }

                    System.out.print(" - 폐강할 과목 코드 입력: ");
                    courseManager.requestCloseCourse(sc.next());
                    System.out.println("✅ 과목 폐강 신청 완료!");
                    break;

                case 3:
                    System.out.println("🔷 [과목 정보 수정]");
                    System.out.print(" - 수정할 과목 코드: ");
                    String courseCode = sc.next();
                    System.out.print(" - 새 과목명: ");
                    String newCourseName = sc.next();
                    System.out.print(" - 새 학점: ");
                    int newCredit = sc.nextInt();
                    System.out.print(" - 새 수강인원: ");
                    int newParticipants = sc.nextInt();

                    courseManager.modifyCourse(courseCode, newCourseName, newCredit, newParticipants);
                    System.out.println("✅ 과목 정보 수정 완료!");
                    break;

                case 4:
                    System.out.println("🔷 [개설 신청 과목 목록]");
                    List<Course> pendingCourses = courseManager.getPendingCourses();
                    if (pendingCourses.isEmpty()) {
                        System.out.println("⚠️ 개설 신청된 과목이 없습니다.");
                    } else {
                        System.out.printf("%-10s %-20s %-6s %-10s\n", "CourseID", "CourseName", "Credit", "Participants");
                        System.out.println("-------------------------------------------------");
                        for (Course c : pendingCourses) {
                            System.out.printf("%-10s %-20s %-6d %-10d\n",
                                    c.getCourseId(), c.getCourseName(), c.getCredit(), c.getParticipants());
                        }
                    }
                    break;

                case 5:
                    System.out.println("🔷 [학생 대기 신청 목록]");
//                    courseManager.showAndHandleWaitingList(this);
                    break;

                case 6:
                    System.out.println("👋 로그아웃합니다...");
                    return;

                default:
                    System.out.println("❗ 잘못된 선택입니다. 다시 시도해주세요.");
            }

            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 행 제거
            sc.nextLine(); // 사용자 입력 대기
        }
    }
}
