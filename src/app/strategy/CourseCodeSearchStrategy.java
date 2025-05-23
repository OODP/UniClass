package app.strategy;

import app.Course;

// 과목코드 검색
public class CourseCodeSearchStrategy implements CourseSearchStrategy {
    @Override
    public boolean matches(Course course, String keyword) {
        return course.getCourseId().toLowerCase().contains(keyword.toLowerCase());
    }
}
