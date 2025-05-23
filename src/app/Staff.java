package app;

import app.commands.staff.ApproveCourseCommand;
import app.commands.staff.RejectCourseCommand;
import app.commands.staff.ViewOpenedCoursesCommand;
import app.commands.staff.ViewPendingCoursesCommand;
import app.invokers.StaffCommandInvoker;

import java.util.Scanner;

public class Staff extends User {

    public Staff(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseManager courseManager = new CourseManager();
        StaffCommandInvoker invoker = new StaffCommandInvoker();

        invoker.setCommand(1, new ViewOpenedCoursesCommand(courseManager));
        invoker.setCommand(2, new ApproveCourseCommand(courseManager));
        invoker.setCommand(3, new RejectCourseCommand(courseManager));
        invoker.setCommand(4, new ViewPendingCoursesCommand(courseManager));

        while (true) {
            System.out.println("\n================ 스태프 메뉴 =================");
            System.out.println(" 1. 🔍 개설된 과목 목록");
            System.out.println(" 2. 📘 과목 개설 허락");
            System.out.println(" 3. ❌ 과목 개설 불허");
            System.out.println(" 4. 📋 개설 요청 과목 목록 보기");
            System.out.println(" 5. 🔒 로그아웃");
            System.out.println("===============================================");
            System.out.print("👉 선택하세요 (1-5): ");

            int choice = sc.nextInt();
            System.out.println();

            if (choice == 5) {
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
