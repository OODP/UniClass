package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class ApplyPreliminaryCourseCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public ApplyPreliminaryCourseCommand(CourseManager cm, Student st) {
        this.cm = cm;
        this.student = st;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [예비 수강 신청]");
        cm.applyPreliminaryCourse(student);
    }
}