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

    // --------------------Iteration 1 -------------------
    // 과목 개설 요청 -> 교수님
    public void requestOpenCourse(String courseId, String courseName, int credit, int participants, Professor professor) {
        Course course = new Course(courseId, courseName, credit, participants, professor);
        pendingCourses.add(course);
    }

    // 과목 폐강 요청 -> 교수님
    public void requestCloseCourse(String courseId) {
        for (Course course : pendingCourses) {
            if (course.getCourseId().equals(courseId)) {
                pendingCourses.remove(course);
                break;
            }
        }
    }

    // 과목 개설 -> 교직원
    public void openCourse(String courseId) {
        for (Course course : pendingCourses) {
            if (course.getCourseId().equals(courseId)) {
                openedCourses.add(course);
                pendingCourses.remove(course);
                break;
            }
        }
    }

    // 과목 폐강 -> 교직원
    public void closeCourse(String courseId) {
        openedCourses.removeIf(course -> course.getCourseId().equals(courseId));
    }

    // 과목 수정 ->  교수님
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

    // 개설 대기중인 과목 조회 -> 교수님, 교직원
    public List<Course> getPendingCourses() {
        return pendingCourses;
    }


    // -------------------Iteration 2 -------------------
    // 수강 신청 -> 학생
    public void applyCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        getOpenedCourses();

        System.out.print(" - 수강 신청할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : openedCourses) {
            if (course.getCourseId().equals(courseId)) {
                student.getMyCourseList().add(course);
                break;
            }
        }
        System.out.println("✅ 수강 신청 완료!");
    }

    //수강 취소 -> 학생
    public  void cancelCourse(Student student){
        Scanner sc = new Scanner(System.in);
        List<Course> myCourseList = student.getMyCourseList();

        System.out.print(" - 수강 취소할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : myCourseList) {
            if (course.getCourseId().equals(courseId)) {
                student.getMyCourseList().remove(course);
                break;
            }
        }
        System.out.println("✅ 수강 취소 완료!");
    }

    //수강 과목 조회 -> 학생
    void showCourseList(Student student) {
        student.getMyCourseList();
    }

    // 개설된 과목 조회 -> 전체 메뉴
    public void getOpenedCourses() {
        if (openedCourses.isEmpty()) {
            System.out.println("⚠️ 개설된 과목이 없습니다.");
            return;
        }
        for (Course course : openedCourses) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }
    }


}
