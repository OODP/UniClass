package app;

public class Grade {
    private final Student student;
    private final Course course;
    private String gradeValue;

    public Grade(Student student, Course course, String grade) {
        this.student = student;
        this.course = course;
        this.gradeValue = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }
}
