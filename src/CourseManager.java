import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManager {

    private static final List<Course> pendingCourses = new ArrayList<>(); // 개설 검토중인 과목 리스트
    private static final List<Course> openedCourses = new ArrayList<>(); // 개설된 과목 리스트

    // 초기 과목 개설 리스트 설정
    static {
        Professor professor = new Professor("prof", "1234", "교수 A", "P001");
        Course course1 = new Course("CS101", "운영체재", 3, 30, professor);
        Course course2 = new Course("CS102", "알고리즘", 3, 30, professor);
        openedCourses.add(course1);
        openedCourses.add(course2);
    }

    // 과목 개설 요청
    public void requestOpenCourse(String courseId, String courseName, int credit, int participants, Professor professor) {
        Course course = new Course(courseId, courseName, credit, participants, professor);
        pendingCourses.add(course);
    }

    // 과목 폐강 요청
    public void requestCloseCourse(String courseId) {
        for (Course course : pendingCourses) {
            if (course.getCourseId().equals(courseId)) {
                pendingCourses.remove(course);
                break;
            }
        }
    }

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

    // 개설 대기중인 과목 조회
    public List<Course> getPendingCourses() {
        return pendingCourses;
    }


    // -------------------Iteration 2 -------------------
    // 수강 신청
    Scanner sc = new Scanner(System.in);
    public void applyCourse(Student student) {
        List<Course> openedCourses = getOpenedCourses();
        for(Course course : openedCourses) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() + " (" +
                    course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }

        System.out.print(" - 수강 신청할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : openedCourses) {
            if (course.getCourseId().equals(courseId)) {
                student.getCourseList().add(course);
                break;
            }
        }
        System.out.println("✅ 수강 신청 완료!");
    }

    //수강 취소
    public  void cancelCourse(Student student){
        List<Course> courseList = student.getCourseList();
        if (courseList.isEmpty()) {
            System.out.println("⚠️ 수강 신청한 과목이 없습니다.");
            return;
        }

        for (Course course : courseList) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }

        System.out.print(" - 수강 취소할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : courseList) {
            if (course.getCourseId().equals(courseId)) {
                student.getCourseList().remove(course);
                break;
            }
        }
        System.out.println("✅ 수강 취소 완료!");
    }
    //수강 과목 조회

    // 개설된 과목 조회
    public List<Course> getOpenedCourses() {
        return openedCourses;
    }

}
