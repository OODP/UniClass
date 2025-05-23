package app.strategy;

import app.Course;

// app.strategy
public interface CourseSearchStrategy {
    boolean matches(Course course, String keyword);
}

