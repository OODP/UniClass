package app.strategy;

import app.Course;

import java.util.ArrayList;
import java.util.List;

// app
public class CourseSearchContext {
    private CourseSearchStrategy strategy;

    public void setStrategy(CourseSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Course> search(List<Course> courses, String keyword) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (strategy.matches(course, keyword)) {
                result.add(course);
            }
        }
        return result;
    }
}

