package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManager {

    private static final List<Course> pendingCourses = new ArrayList<>(); // 개설 검토중인 과목 리스트
    private static final List<Course> openedCourses = new ArrayList<>(); // 개설된 과목 리스트

    //singleton pattern -> instance 생성
    private static CourseManager instance = new CourseManager();

    private CourseManager() {
    }

    public static CourseManager getInstance() {
        return instance;
    }

    // 초기 과목 개설 리스트 설정
    static {
        Professor professor = new Professor("prof", "1234", "교수 A", "P001");
        Course course1 = new Course("CS101", "운영체재", 3, 30, professor);
        openedCourses.add(course1);
        Course course2 = new Course("CS102", "알고리즘", 3, 30, professor);
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

    // 수강 신청 과목 보기 -> 학생
    public List<Course> viewMyCourseList(Student student) {
        List<Course> myCourseList = student.getMyCourseList();
        if (myCourseList.isEmpty()) {
            System.out.println("⚠️ 수강 신청한 과목이 없습니다.");
            return null;
        }
        System.out.println("🔷 [수강 신청 목록]");
        for (Course course : myCourseList) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }
        return myCourseList;
    }

    // 수강 신청 -> 학생
    public void applyCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        viewOpenedCourses();

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

    // 수강 취소 -> 학생
    public void cancelCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        List<Course> myCourseList = viewMyCourseList(student);

        System.out.print(" - 수강 취소할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : myCourseList) {
            if (course.getCourseId().equals(courseId)) {
                viewMyCourseList(student).remove(course);
                break;
            }
        }
        System.out.println("✅ 수강 취소 완료!");
    }

    // 개설된 과목 조회 -> 전체 메뉴
    public void viewOpenedCourses() {
        if (openedCourses.isEmpty()) {
            System.out.println("⚠️ 개설된 과목이 없습니다.");
            return;
        }
        for (Course course : openedCourses) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }
    }


    //-----------------------Iteration 3 -------------------
    // 예비 수강 신청 과목 보기 -> 학생
    public void viewMyPreliminaryCourseList(Student student) {
        List<Course> myPreliminaryCourseList = student.getMyPreliminaryCourseList();
        if (myPreliminaryCourseList.isEmpty()) {
            System.out.println("⚠️ 예비 수강 신청한 과목이 없습니다.");
            return;
        }
        System.out.println("🔷 [예비 수강 신청 목록]");
        for (Course course : myPreliminaryCourseList) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }
    }

    // 예비 수강 신청 -> 학생
    public void applyPreliminaryCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        viewOpenedCourses();

        System.out.print(" - 예비 수강 신청할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : openedCourses) {
            if (course.getCourseId().equals(courseId)) {
                student.getMyPreliminaryCourseList().add(course);
                System.out.println("✅ 예비 수강 신청 완료!");
                return;
            }
        }
        System.out.println("❗ 잘못된 과목 코드입니다.");
    }

    // 예비 수강 신청 취소 -> 학생
    public void cancelPreliminaryCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        List<Course> myPreliminaryCourseList = student.getMyPreliminaryCourseList();
        viewMyPreliminaryCourseList(student);

        System.out.print(" - 예비 수강 신청 취소할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : myPreliminaryCourseList) {
            if (course.getCourseId().equals(courseId)) {
                student.getMyPreliminaryCourseList().remove(course);
                break;
            } else {
                System.out.println("❗ 잘못된 과목 코드입니다.");
                return;
            }
        }
        System.out.println("✅ 예비 수강 신청 취소 완료!");
    }

    // 수강 대기 신청 과목 보기 -> 학생
    public void viewMyWaitingCourseList(Student student) {
        List<Course> myWaitingCourseList = student.getMyWaitingCourseList();
        if (myWaitingCourseList.isEmpty()) {
            System.out.println("⚠️ 수강 대기 신청한 과목이 없습니다.");
            return;
        }
        for (Course course : myWaitingCourseList) {
            System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                    " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
        }
    }

    // 수강 대기 신청
    public void applyWaitingCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        viewOpenedCourses();

        System.out.print(" - 수강 대기 신청할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : openedCourses) {
            System.out.println("디버깅: openedCourses에서 찾는 중 - " + course.getCourseId());
            if (course.getCourseId().equals(courseId)) {
                student.getMyWaitingCourseList().add(course);
                course.getWaitingStudentList().add(student);
                System.out.println("✅ 수강 대기 신청 완료!");
                return;
            }
        }
        System.out.println("❗ 잘못된 과목 코드입니다.");
    }

    // 수강 대기 신청 취소
    public void cancelWaitingCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        List<Course> myWaitingCourseList = student.getMyWaitingCourseList();

        System.out.print(" - 수강 대기 신청 취소할 과목 코드 입력: ");
        String courseId = sc.next();

        for (Course course : myWaitingCourseList) {
            if (course.getCourseId().equals(courseId)) {
                student.getMyWaitingCourseList().remove(course);
                course.getWaitingStudentList().remove(student);
                break;
            } else {
                System.out.println("❗ 잘못된 과목 코드입니다.");
                return;
            }
        }
        System.out.println("✅ 수강 대기 신청 취소 완료!");
    }

    //검색을 위한 openedCourse getter
    public List<Course> getOpenedCourses() {
        return openedCourses;
    }


    //    ---------------------Iteration 4 -------------------
    // 수강 대기 신청 목록 확인 및 처리 -> 교수님
    public void showAndHandleWaitingList(Professor professor) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        for (Course course : openedCourses) {
            if (course.getProfessor().equals(professor)) {
                List<Student> waitingStudentList = course.getWaitingStudentList();
                if (waitingStudentList.isEmpty()) continue;
                found = true;
                System.out.println("과목: " + course.getCourseId() + " - " + course.getCourseName());
                for (int i = 0; i < waitingStudentList.size(); ) {
                    Student student = waitingStudentList.get(i);
                    System.out.println("학생: " + student.getName() + " (" + student.getId() + ")");
                    System.out.print("수락(1)/거절(2): ");
                    int input = sc.nextInt();
                    if (input == 1) {
                        // 수락: 학생의 myCourseList에 추가, 대기 리스트에서 제거
                        student.getMyCourseList().add(course);
                        student.getMyWaitingCourseList().remove(course);
                        waitingStudentList.remove(student);
                        System.out.println("✅ 수강 대기 신청 수락 완료!");
                    } else if (input == 2) {
                        // 거절: 대기 리스트에서만 제거
                        student.getMyWaitingCourseList().remove(course);
                        waitingStudentList.remove(student);
                        System.out.println("❌ 수강 대기 신청 거절 완료!");
                    } else {
                        System.out.println("❗ 잘못된 선택입니다.");
                        i++;
                        continue;
                    }
                    // 리스트에서 학생을 제거했으므로 인덱스 증가 X
                }
            }
        }
        if (!found) {
            System.out.println("⚠️ 대기 신청한 학생이 없습니다.");
        }
    }

    // 학생 성적 입력 -> 교수님
    public void inputStudentGrade(Professor professor) {
        Scanner sc = new Scanner(System.in);
        List<Course> myCourses = new ArrayList<>();

        // 교수님 자신이 개설한 과목 목록 가져오기
        for (Course c : getOpenedCourses()) {
            if (c.getProfessor().equals(professor)) {
                myCourses.add(c);
            }
        }

        if (myCourses.isEmpty()) {
            System.out.println("⚠️ 개설한 과목이 없습니다.");
            return;
        }

        System.out.println("🔷 [학생 성적 입력]");
        for (int i = 0; i < myCourses.size(); i++) {
            System.out.println((i + 1) + ". " + myCourses.get(i).getCourseName() +
                    " (" + myCourses.get(i).getCredit() + "학점, " + myCourses.get(i).getParticipants() + "명 수강 가능)");
        }
        System.out.print("과목 번호 선택 : ");
        int index = sc.nextInt() - 1;
        if (index < 0 || index >= myCourses.size()) {
            System.out.println("❗ 잘못된 선택입니다.");
            return;
        }
        Course selectedCourse = myCourses.get(index);

        //해당 과목을 수강하는 학생 불러오기
        List<Student> studentList = new ArrayList<>();
        for (Student s : UserManager.getInstance().findAllStudents()) {
            if (s.getMyCourseList().contains(selectedCourse)) {
                studentList.add(s);
            }
        }

        if (studentList.isEmpty()) {
            System.out.println("⚠️ 해당 과목을 수강하는 학생이 없습니다.");
            return;
        }

        for (Student stu : studentList) {
            System.out.println("학생 ID: " + stu.getId() + ", 이름: " + stu.getName());
            System.out.print("성적 입력 (A, B, C, D, F): ");
            String grade = sc.next();
            if (!grade.matches("[A-F]")) {
                System.out.println("❗ 잘못된 성적 입력입니다. A, B, C, D, F 중 하나를 입력해주세요.");
                return;
            }
            selectedCourse.setGradeValue(stu, grade);
            System.out.println("✅ " + stu.getName() + " 학생의 성적이 " + grade + "로 입력되었습니다.");
        }
    }

    // 성적 수정 -> 교수님
    public void modifyStudentGrade(Professor professor) {
        Scanner sc = new Scanner(System.in);
        List<Course> myCourses = new ArrayList<>();

        // 교수님 자신이 개설한 과목 목록 가져오기
        for (Course c : getOpenedCourses()) {
            if (c.getProfessor().equals(professor)) {
                myCourses.add(c);
            }
        }

        if (myCourses.isEmpty()) {
            System.out.println("⚠️ 개설한 과목이 없습니다.");
            return;
        }

        System.out.println("🔷 [학생 성적 수정]");
        for (int i = 0; i < myCourses.size(); i++) {
            System.out.println((i + 1) + ". " + myCourses.get(i).getCourseName() +
                    " (" + myCourses.get(i).getCredit() + "학점, " + myCourses.get(i).getParticipants() + "명 수강 가능)");
        }

        System.out.print("과목 번호 선택: ");
        int index = sc.nextInt()-1;
        if (index < 0 || index >= myCourses.size()) {
            System.out.println("❗ 잘못된 선택입니다.");
            return;
        }

        Course selectedCourse = myCourses.get(index);

        // 해당 과목을 수강하는 학생 불러오기
        List<Student> studentList = new ArrayList<>();
        for (Student s : UserManager.getInstance().findAllStudents()) {
            if (s.getMyCourseList().contains(selectedCourse)) {
                studentList.add(s);
            }
        }

        if (studentList.isEmpty()) {
            System.out.println("⚠️ 해당 과목을 수강하는 학생이 없습니다.");
            return;
        }

        for (Student stu : studentList) {
            System.out.println("학생 ID: " + stu.getId() + ", 이름: " + stu.getName());
            System.out.print("수정할 성적 입력 (A, B, C, D, F): ");
            String grade = sc.next();
            if (!grade.matches("[A-F]")) {
                System.out.println("❗ 잘못된 성적 입력입니다. A, B, C, D, F 중 하나를 입력해주세요.");
                return;
            }
            selectedCourse.setGradeValue(stu, grade);
            System.out.println("✅ " + stu.getName() + " 학생의 성적이 " + grade + "로 수정되었습니다.");
        }
    }

    // 성적 조회 -> 학생
    public void viewStudentGrades(Student student) {
        List<Course> myCourses = student.getMyCourseList();
        if (myCourses.isEmpty()) {
            System.out.println("⚠️ 수강 신청한 과목이 없습니다.");
            return;
        }

        System.out.println("🔷 [학생 성적 조회]");
        for (Course course : myCourses) {
            String grade = course.getGradeValue(student);
            System.out.println("과목: " + course.getCourseName() + ", 성적: " + (grade != null ? grade : "미입력"));
        }
    }

    //-----------------------Iteration 4 -------------------

    public List<Student> getEnrolledStudents(Course course) {
        List<Student> enrolledStudents = new ArrayList<>();
        // 모든 학생을 순회하며 해당 과목을 수강 중인 학생을 찾음
        for (Student student : UserManager.getInstance().findAllStudents()) {
            if (student.getMyCourseList().contains(course)) {
                enrolledStudents.add(student);
            }
        }
        return enrolledStudents;
    }

}


