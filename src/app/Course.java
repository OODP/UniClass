package app;

import java.util.ArrayList;
import java.util.List;


public class Course {

    private final String courseId;
    private String courseName;
    private int credit;
    private int participants;
    private final Professor professor;
    private final List<Student> waitingStudentList = new ArrayList<>();

    public Course(String courseId, String courseName, int credit, int participants, Professor professor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.participants = participants;
        this.professor = professor;
    }

    //getter
    public List<Student> getWaitingStudentList() {
        return waitingStudentList;
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

    public Professor getProfessor() {
        return professor;
    }

    //setter
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
