package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class ApplyCourseCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public ApplyCourseCommand(CourseManager cm, Student st) {
        this.cm = cm;
        this.student = st;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [수강 신청]");
        cm.applyCourse(student);
    }
}