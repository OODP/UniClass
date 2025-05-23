package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class ViewOpenedCoursesCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public ViewOpenedCoursesCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {
        System.out.println("🔷 [개설된 과목 목록]");
        courseManager.viewOpenedCourses();
    }
}
