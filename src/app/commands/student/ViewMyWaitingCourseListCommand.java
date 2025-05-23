package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class ViewMyWaitingCourseListCommand implements Command {
    private final CourseManager cm;
    private final Student student;

    public ViewMyWaitingCourseListCommand(CourseManager cm, Student student) {
        this.cm = cm;
        this.student = student;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [수강 대기 신청 목록]");
        cm.viewMyWaitingCourseList(student);
    }
}