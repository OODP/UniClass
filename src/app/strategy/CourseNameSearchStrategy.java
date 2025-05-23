package app.strategy;

import app.Course;

// 과목명 검색
public class CourseNameSearchStrategy implements CourseSearchStrategy {
    @Override
    public boolean matches(Course course, String keyword) {
        return course.getCourseName().toLowerCase().contains(keyword.toLowerCase());
    }
}

