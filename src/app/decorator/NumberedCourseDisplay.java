package app.decorator;

import app.Course;
import java.util.List;

public class NumberedCourseDisplay extends CourseListDisplayDecorator{

    public NumberedCourseDisplay(CourseListDisplay decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void display(List<Course> courses) {
        System.out.println("📋 [과목 목록]");
        int index = 1;
        for (Course course : courses) {
            System.out.println(index + ". " + course.getCourseId() + " - " + course.getCourseName());
            index++;
        }
    }
}
