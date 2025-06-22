package app.decorator;

import app.Course;
import java.util.List;

public class BasicCourseListDisplay implements CourseListDisplay {
    @Override
    public void display(List<Course> courses) {
        for(Course course : courses){
            System.out.println(course.getCourseId() + "-" + course.getCourseName());
        }
    }
}
