package app;

import app.commands.student.*;
import app.invokers.StudentCommandInvoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends User {

    CourseManager courseManager = CourseManager.getInstance();
    List<Course> myCourseList = new ArrayList<>(); // 수강 신청한 과목 리스트
    List<Course> myPreliminaryCourseList = new ArrayList<>(); // 예비 수강 신청한 과목 리스트
    List<Course> myWaitingCourseList = new ArrayList<>(); // 수강 대기 신청한 과목 리스트
    int student_credit = 0; // 수강 신청한 학점

    public Student(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    // 나의 수강 신청 리스트 getter
    public List<Course> getMyCourseList() {
        return myCourseList;
    }

    // 예비 수강 신청 과목 보기
    public List<Course> getMyPreliminaryCourseList() {
        return myPreliminaryCourseList;
    }

    // 수강 대기 신청 과목 보기
    public List<Course> getMyWaitingCourseList() {
        return myWaitingCourseList;
    }

    // 메뉴
    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        StudentCommandInvoker invoker = new StudentCommandInvoker();

        invoker.setCommand(1, new ViewOpenedCoursesCommand(courseManager));
        invoker.setCommand(2, new ViewMyCourseListCommand(courseManager, this));
        invoker.setCommand(3, new ViewMyPreliminaryCourseListCommand(courseManager, this));
        invoker.setCommand(4, new ViewMyWaitingCourseListCommand(courseManager, this));
        invoker.setCommand(5, new ApplyCourseCommand(courseManager, this));
        invoker.setCommand(6, new CancelCourseCommand(courseManager, this));
        invoker.setCommand(7, new ApplyPreliminaryCourseCommand(courseManager, this));
        invoker.setCommand(8, new CancelPreliminaryCourseCommand(courseManager, this));
        invoker.setCommand(9, new ApplyWaitingCourseCommand(courseManager, this));
        invoker.setCommand(10, new CancelWaitingCourseCommand(courseManager, this));

        while (true) {
            System.out.println("\n================ 학생 메뉴 =================");
            System.out.println(" 1. 🔍 개설된 과목 목록");
            System.out.println(" 2. 📖 수강 신청 목록");
            System.out.println(" 3. 🔍 예비 수강 신청 목록");
            System.out.println(" 4. 📖 수강 대기 신청 목록");

            System.out.println(" 5. 📚 수강 신청");
            System.out.println(" 6. ❌ 수강 신청 취소");
            System.out.println(" 7. 📝 예비 수강 신청");
            System.out.println(" 8. ❌ 예비 수강 신청 취소");
            System.out.println(" 9. 🕒 수강 대기 신청");
            System.out.println(" 10. ❌ 수강 대기 신청 취소");
            System.out.println(" 11. 🔒 로그아웃");
            System.out.println("============================================");
            System.out.print("👉 선택하세요 (1-11): ");

            int choice = sc.nextInt();
            System.out.println();

            if (choice == 11) {
                System.out.println("👋 로그아웃합니다...");
                return;
            }

            invoker.executeCommand(choice);

            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 개행 제거
            sc.nextLine(); // 사용자 입력 대기
        }
    }
}
