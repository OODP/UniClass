package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class ModifyCourseCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public ModifyCourseCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {

        Scanner sc = new Scanner(System.in);
        System.out.println("🔷 [과목 정보 수정]");
        System.out.print(" - 수정할 과목 코드: ");
        String courseCode = sc.next();
        System.out.print(" - 새 과목명: ");
        String newCourseName = sc.next();
        System.out.print(" - 새 학점: ");
        int newCredit = sc.nextInt();
        System.out.print(" - 새 수강인원: ");
        int newParticipants = sc.nextInt();
        courseManager.modifyCourse(courseCode, newCourseName, newCredit, newParticipants);
        System.out.println("✅ 과목 정보 수정 완료!");

    }
}
