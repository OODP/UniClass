import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private final List<Course> pendingCourses = new ArrayList<>(); // 개설 검토중인 과목 리스트
    private final List<Course> openedCourses = new ArrayList<>(); // 개설된 과목 리스트

    // 과목 개설 요청
    public void requestOpenCourse(String courseId, String courseName, int credit, int participants, Professor professor) {
        Course course = new Course(courseId, courseName, credit, participants, professor);
        pendingCourses.add(course);
    }

    // 과목 폐강 요청 -> 있어야 할까?
//    public void requestCloseCourse(String courseId) {
//
//    }

    // 과목 개설
    public void openCourse(String courseId) {
        for (Course course : pendingCourses) {
            if (course.getCourseId().equals(courseId)) {
                openedCourses.add(course);
                pendingCourses.remove(course);
                break;
            }
        }
    }

    // 과목 폐강
    public void closeCourse(String courseId) {
        openedCourses.removeIf(course -> course.getCourseId().equals(courseId));
    }

    // 과목 수정
    public void modifyCourse(String courseId, String newCourseName, int newCredit, int newParticipants) {
        for (Course course : openedCourses) {
            if (course.getCourseId().equals(courseId)) {
                course.setCourseName(newCourseName);
                course.setCredit(newCredit);
                course.setParticipants(newParticipants);
                break;
            }
        }
    }

    public List<Course> getPendingCourses() {
        return pendingCourses;
    }

    public List<Course> getOpenedCourses() {
        return openedCourses;
    }
}
