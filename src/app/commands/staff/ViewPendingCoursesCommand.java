package app.commands.staff;

import app.CourseManager;
import app.Course;
import app.commands.Command;

import java.util.List;

public class ViewPendingCoursesCommand implements Command {
    private CourseManager courseManager;

    public ViewPendingCoursesCommand(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [개설 요청 과목 목록]");

        List<Course> pendingCourses = courseManager.getPendingCourses();
        if (pendingCourses.isEmpty()) {
            System.out.println("⚠️ 개설 요청 과목이 없습니다.");
        } else {
            printCourseList(pendingCourses);
        }

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
