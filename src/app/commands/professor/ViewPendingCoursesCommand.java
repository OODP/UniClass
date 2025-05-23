package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class ViewPendingCoursesCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public ViewPendingCoursesCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {

        System.out.println("🔷 [개설 신청 과목 목록]");
        List<Course> pendingCourses = courseManager.getPendingCourses();
        if (pendingCourses.isEmpty()) {
            System.out.println("⚠️ 개설 신청된 과목이 없습니다.");
        } else {
            System.out.printf("%-10s %-20s %-6s %-10s\n", "CourseID", "CourseName", "Credit", "Participants");
            System.out.println("-------------------------------------------------");
            for (Course c : pendingCourses) {
                System.out.printf("%-10s %-20s %-6d %-10d\n", c.getCourseId(), c.getCourseName(), c.getCredit(), c.getParticipants());
            }
        }

    }
}
