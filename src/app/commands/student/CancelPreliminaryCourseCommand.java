package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class CancelPreliminaryCourseCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public CancelPreliminaryCourseCommand(CourseManager cm, Student st) {
        this.cm = cm;
        this.student = st;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [예비 수강 신청 취소]");
        cm.cancelPreliminaryCourse(student);
    }
}