package app.strategy;

import app.Course;

// 교수명 검색
public class ProfessorNameSearchStrategy implements CourseSearchStrategy {
    @Override
    public boolean matches(Course course, String keyword) {
        return course.getProfessor().getName().toLowerCase().contains(keyword.toLowerCase());
    }
}
