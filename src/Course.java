import java.util.List;


public class Course {

    private final String courseId;
    private String courseName;
    private int credit;
    private int participants;
    private Professor professor;
    private List<Student> students;

    public Course(String courseId, String courseName, int credit, int participants, Professor professor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.participants = participants;
        this.professor = professor;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public int getParticipants() {
        return participants;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
