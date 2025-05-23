package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class CancelWaitingCourseCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public CancelWaitingCourseCommand(CourseManager cm, Student st) {
        this.cm = cm;
        this.student = st;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [수강 대기 신청 취소]");
        cm.cancelWaitingCourse(student);
    }
}