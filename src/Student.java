import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends User {

    CourseManager courseManager = new CourseManager();
    List<Course> myCourseList = new ArrayList<>(); // 수강 신청한 과목 리스트
    int student_credit = 0; // 수강 신청한 학점

    public Student(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    public List<Course> getMyCourseList() {
        if(myCourseList.isEmpty()) {
            System.out.println("⚠️ 수강 신청한 과목이 없습니다.");
            return null;
        }
        System.out.println("🔷 [수강 신청 목록]");
        for(Course course : myCourseList) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }
        return myCourseList;
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ 학생 메뉴 =================");
            System.out.println(" 0. 🔍개설된 과목 목록");
            System.out.println(" 1. 📖 수강 신청 목록");
            System.out.println(" 2. 📚 수강 신청");
            System.out.println(" 3. ❌ 수강 신청 취소");
//            System.out.println(" 4. 📝 예비 수강 신청");
//            System.out.println(" 4. ❌ 예비 수강 신청 취소");
//            System.out.println(" 5. 🕒 수강 대기 신청");
//            System.out.println(" 6. ❌ 수강 대기 신청 취소");
            System.out.println(" 7. 🔒 로그아웃");
            System.out.println("============================================");
            System.out.print("👉 선택하세요 (0-7): ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 0:
                    System.out.println("🔷 [개설된 과목 목록]");
                    courseManager.getOpenedCourses();
                    break;
                case 1:
                    System.out.println("🔷 [수강 신청 목록]");
                    courseManager.showCourseList(this);
                    break;

                case 2:
                    System.out.println("🔷 [수강 신청]");
                    courseManager.applyCourse(this);
                    break;

                case 3:
                    System.out.println("🔷 [수강 신청 취소]");
                    courseManager.cancelCourse(this);
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
