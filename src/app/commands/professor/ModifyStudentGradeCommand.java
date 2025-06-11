package app.commands.professor;

import app.CourseManager;
import app.Professor;
import app.commands.Command;

public class ModifyStudentGradeCommand implements Command {
    private final CourseManager courseManager;
    private final Professor professor;

    public ModifyStudentGradeCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {
        courseManager.modifyStudentGrade(professor);
    }
}
