package app.state.staff;

import app.*;

import java.util.List;
import java.util.Scanner;

public class PendingState implements StaffState {
    @Override
    public void handleLogin(StaffContext context) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("=====================================");
            System.out.println("승인 대기 중입니다. 관리자의 승인을 기다려주세요.");
            System.out.println("1. 개설된 과목 목록 보기");
            System.out.println("2. 내 정보 보기");
            System.out.println("3. 나가기");
            System.out.print("선택: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<Course> openedCourses = CourseManager.getInstance().getOpenedCourses();
                    if (openedCourses.isEmpty()) {
                        System.out.println("개설된 과목이 없습니다.");
                    } else {
                        System.out.println("개설된 과목 목록:");
                        for (Course c : openedCourses) {
                            System.out.println(c.getCourseId() + " | " + c.getCourseName() + " | 담당: " + c.getProfessor().getName());
                        }
                    }
                    break;
                case 2:
                    System.out.println("==== 내 정보 ====");
                    System.out.println("ID: " + context.getStaff().getId());
                    System.out.println("이름: " + context.getStaff().getName());
                    break;
                case 3:
                    System.out.println("나가기를 선택했습니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    @Override
    public void handleApprove(StaffContext context) {
        context.setState(new ApprovedState());
        // userDB에 staff 등록
        Auth.userDB.put(context.getStaff().getId(), context.getStaff());
        UserManager.getInstance().addStaff(context.getStaff());
        System.out.println("승인 완료!");
    }

    @Override
    public void handleReject(StaffContext context) {
        context.setState(new RejectedState());
        System.out.println("거절 처리되었습니다.");
    }

    @Override
    public String getStateName() {
        return "대기";
    }
}

