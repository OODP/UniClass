package app.decorator;

import app.Course;
import java.util.List;

public abstract class CourseListDisplayDecorator implements CourseListDisplay {
    protected CourseListDisplay decoratedDisplay;

    public CourseListDisplayDecorator(CourseListDisplay decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }

    @Override
    public void display(List<Course> courses) {
        decoratedDisplay.display(courses);
    }
}
