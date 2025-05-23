package app.commands.student;

import app.CourseManager;
import app.commands.Command;

public class ViewOpenedCoursesCommand implements Command {
    private final CourseManager cm;

    public ViewOpenedCoursesCommand(CourseManager cm) {
        this.cm = cm;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [개설된 과목 목록]");
        cm.viewOpenedCourses();
    }
}