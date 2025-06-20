package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Course {
    private final String courseId;
    private String courseName;
    private int credit;
    private int participants;
    // 등록한 학생 수
    private int registeredStudents;
    private final Professor professor;
    private final List<Student> waitingStudentList = new ArrayList<>();
    private final List<Grade> gradeList = new ArrayList<>();

    public Course(String courseId, String courseName, int credit, int participants, int registeredStudents, Professor professor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.participants = participants;
        this.registeredStudents = registeredStudents;
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

    public int getRegisteredStudents() {
        return registeredStudents;
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

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    // 과목에 학생 추가
    public void setGradeValue(Student student, String gradeValue) {
        for(Grade g : gradeList) {
            if(g.getStudent().equals(student)) {
                g.setGradeValue(gradeValue);
                return;
            }
        }
        gradeList.add(new Grade(student, this, gradeValue));
    }

    public String getGradeValue(Student student) {
        for(Grade g : gradeList) {
            if(g.getStudent().equals(student)) {
                return g.getGradeValue();
            }
        }
        return null;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

}
