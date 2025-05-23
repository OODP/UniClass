package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class CloseCourseRequestCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public CloseCourseRequestCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {

        System.out.println("🔷 [과목 폐강 신청]");
        List<Course> closeCourses = courseManager.getPendingCourses();
        if (closeCourses.isEmpty()) {
            System.out.println("⚠️ 개설된 과목이 없습니다.");
            return;
        }
        for (Course course : closeCourses) {
            System.out.println(" - " + course);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print(" - 폐강할 과목 코드 입력: ");
        courseManager.requestCloseCourse(sc.next());
        System.out.println("✅ 과목 폐강 신청 완료!");

    }
}
