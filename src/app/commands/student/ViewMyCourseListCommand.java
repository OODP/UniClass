package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class ViewMyCourseListCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public ViewMyCourseListCommand(CourseManager cm, Student st) {
        this.cm = cm;
        this.student = st;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [수강 신청 목록]");
        cm.viewMyCourseList(student);
    }
}