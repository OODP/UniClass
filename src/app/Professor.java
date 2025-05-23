package app;

import app.commands.professor.*;
import app.commands.staff.ViewPendingCoursesCommand;
import app.invokers.ProfessorCommandInvoker;

import java.util.Scanner;

public class Professor extends User {

    public Professor(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseManager courseManager = new CourseManager();
        ProfessorCommandInvoker invoker = new ProfessorCommandInvoker();

        invoker.setCommand(1, new ViewOpenedCoursesCommand(courseManager, this));
        invoker.setCommand(2, new OpenCourseRequestCommand(courseManager, this));
        invoker.setCommand(3, new CloseCourseRequestCommand(courseManager, this));
        invoker.setCommand(4, new ModifyCourseCommand(courseManager, this));
        invoker.setCommand(5, new ViewPendingCoursesCommand(courseManager));
        invoker.setCommand(6, new HandleWaitingListCommand(courseManager, this));

        while (true) {
            System.out.println("\n================ 교수 메뉴 =================");
            System.out.println(" 1. 🔍 개설된 과목 목록");
            System.out.println(" 2. 📘 과목 개설 신청 (Open)");
            System.out.println(" 3. ❌ 과목 폐강 신청 (Close)");
            System.out.println(" 4. ✏️  개설한 과목 정보 수정 (Update)");
            System.out.println(" 5. 📋 개설 신청 과목 목록 보기 (View)");
            System.out.println(" 6. 🧑‍🎓 학생 대기 신청 목록 확인 및 처리");
            System.out.println(" 7. 🔒 로그아웃");
            System.out.println("============================================");
            System.out.print("👉 선택하세요 (0-6): ");

            int choice = sc.nextInt();
            System.out.println();

            if (choice == 7) {
                System.out.println("👋 로그아웃합니다...");
                return;
            }

            invoker.executeCommand(choice);

            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 행 제거
            sc.nextLine(); // 사용자 입력 대기
        }
    }
}
