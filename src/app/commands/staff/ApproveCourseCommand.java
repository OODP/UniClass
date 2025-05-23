package app.commands.staff;

import app.CourseManager;
import app.Course;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class ApproveCourseCommand implements Command {
    private CourseManager courseManager;

    public ApproveCourseCommand(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [과목 개설 허락]");

        List<Course> coursesToApprove = courseManager.getPendingCourses();
        if (coursesToApprove.isEmpty()) {
            System.out.println("⚠️ 개설 요청 과목이 없습니다.");
            return;
        }
        printCourseList(coursesToApprove);
        Scanner sc = new Scanner(System.in);
        System.out.print(" - 허락할 과목 코드 입력: ");
        String approveId = sc.next();
        if (approveId == null || approveId.isEmpty()) {
            System.out.println("❗ 잘못된 과목 코드입니다.");
            return;
        }
        courseManager.openCourse(approveId);
        System.out.println("✅ 과목 개설 허락 완료!");

    }

    private void printCourseList(List<Course> courses) {
        System.out.printf("%-10s %-20s %-6s %-10s\n", "CourseID", "CourseName", "Credit", "Participants");
        System.out.println("-------------------------------------------------");
        for (Course c : courses) {
            System.out.printf("%-10s %-20s %-6d %-10d\n",
                    c.getCourseId(), c.getCourseName(), c.getCredit(), c.getParticipants());
        }
    }
}
