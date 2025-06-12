package app.commands.professor;

import app.Course;
import app.CourseManager;
import app.Professor;
import app.Student;
import app.Grade;
import app.commands.professor.StatisticsCommand;

import java.util.List;

public class GradeStatusCommand extends StatisticsCommand {

    public GradeStatusCommand(CourseManager courseManager, Professor professor) {
        super(courseManager, professor);
    }

    @Override
    protected void showStatistics(Course course) {
        List<Grade> gradeList = course.getGradeList();

        System.out.println("🔹 과목명: " + course.getCourseName());
        System.out.println("🔹 담당 교수: " + course.getProfessor().getName());
        System.out.println("🔹 성적 현황:");

        if (gradeList.isEmpty()) {
            System.out.println("입력된 성적이 없습니다.");
            return;
        }

        for (Grade grade : gradeList) {
            Student student = grade.getStudent();
            String gradeValue = grade.getGradeValue();
            System.out.println("  - 학번: " + student.getId() + ", 이름: " + student.getName() + ", 성적: " + gradeValue);
        }
    }
}

