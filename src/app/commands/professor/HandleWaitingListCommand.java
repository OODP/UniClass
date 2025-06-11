package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class HandleWaitingListCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public HandleWaitingListCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {
        courseManager.showAndHandleWaitingList(professor);
    }
}
