package app.commands.professor;

import app.Course;
import app.CourseManager;
import app.Professor;
import app.Student;
import app.commands.professor.StatisticsCommand;

import java.util.List;

public class EnrollmentStatusCommand extends StatisticsCommand {

    public EnrollmentStatusCommand(CourseManager courseManager, Professor professor) {
        super(courseManager, professor);
    }

    @Override
    protected void showStatistics(Course course) {
        // CourseManager를 통해 수강 신청 학생 목록을 조회
        List<Student> enrolledStudents = courseManager.getEnrolledStudents(course);
        int enrolled = enrolledStudents.size();
        int capacity = course.getParticipants();

        System.out.println("🔹 과목명: " + course.getCourseName());
        System.out.println("🔹 담당 교수: " + course.getProfessor().getName());
        System.out.println("🔹 수강 신청 인원: " + enrolled + " / " + capacity);

        if (enrolled > 0) {
            System.out.println("신청 학생 목록:");
            for (Student student : enrolledStudents) {
                System.out.println("  - " + student.getId() + " " + student.getName());
            }
        } else {
            System.out.println("신청한 학생이 없습니다.");
        }
    }
}
