package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class OpenCourseRequestCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public OpenCourseRequestCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {

        Scanner sc = new Scanner(System.in);
        System.out.println("🔷 [과목 개설 신청]");
        System.out.print(" - 과목 코드 입력: ");
        String courseId = sc.next();
        System.out.print(" - 과목명 입력: ");
        String courseName = sc.next();
        System.out.print(" - 학점 입력: ");
        int credit = sc.nextInt();
        System.out.print(" - 수강 인원 입력: ");
        int participants = sc.nextInt();
        courseManager.requestOpenCourse(courseId, courseName, credit, participants, professor);
        System.out.println("✅ 과목 개설 신청 완료!");

    }
}
