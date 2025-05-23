package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class ViewMyPreliminaryCourseListCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public ViewMyPreliminaryCourseListCommand(CourseManager cm, Student student) {
        this.cm = cm;
        this.student = student;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [예비 수강 신청 목록]");
        cm.viewMyPreliminaryCourseList(student);
    }
}