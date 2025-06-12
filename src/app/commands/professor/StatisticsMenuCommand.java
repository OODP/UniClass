package app.commands.professor;

import app.CourseManager;
import app.Professor;
import app.commands.Command;

import java.util.Scanner;

public class StatisticsMenuCommand implements Command {
    private final CourseManager courseManager;
    private final Professor professor;

    public StatisticsMenuCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n========= [통계 메뉴] =========");
            System.out.println("1. 수강 신청 현황");
            System.out.println("2. 성적 현황");
            System.out.println("0. 뒤로가기");
            System.out.print("선택: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("통계 메뉴를 종료합니다.");
                break;
            }

            StatisticsCommand command = null;
            switch (choice) {
                case 1:
                    command = new EnrollmentStatusCommand(courseManager, professor);
                    break;
                case 2:
                    command = new GradeStatusCommand(courseManager, professor);
                    break;
                default:
                    System.out.println("올바른 번호를 입력하세요.");
                    continue;
            }

            command.execute();
            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 개행 문자 제거
            sc.nextLine(); // 사용자 입력 대기
        }
    }
}
