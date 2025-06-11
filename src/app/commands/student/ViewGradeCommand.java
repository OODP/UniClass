package app.commands.student;

import app.CourseManager;
import app.Student;
import app.commands.Command;

public class ViewGradeCommand implements Command {
    private final CourseManager courseManager;
    private final Student student;

    public ViewGradeCommand(CourseManager courseManager, Student student) {
        this.courseManager = courseManager;
        this.student = student;
    }

    @Override
    public void execute() {
        courseManager.viewStudentGrades(student);
    }

}
