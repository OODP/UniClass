package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;

import java.util.List;
import java.util.Scanner;

/**
 * 통계 기능을 위한 Template Method 패턴의 추상 클래스입니다.
 */
public abstract class StatisticsCommand {
    protected CourseManager courseManager;
    protected Professor professor;

    public StatisticsCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    // Template Method
    public final void execute() {
        Course course = selectCourse();
        if (course == null) {
            System.out.println("과목 선택이 취소되었습니다.");
            return;
        }
        showStatistics(course);
        afterShow();
    }

    // Hook method for optional extension
    protected void afterShow() {}

    // CourseManager에 교수별 과목 조회 메서드가 없으므로, 전체 개설 과목 중 교수의 과목만 필터링
    protected Course selectCourse() {
        List<Course> openedCourses = courseManager.getOpenedCourses(); // 전체 개설 과목 리스트 반환
        // 교수 본인이 담당한 과목만 필터링
        List<Course> myCourses = openedCourses.stream()
                .filter(c -> c.getProfessor().equals(professor))
                .toList();

        if (myCourses.isEmpty()) {
            System.out.println("개설한 과목이 없습니다.");
            return null;
        }
        System.out.println("과목을 선택하세요:");
        for (int i = 0; i < myCourses.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, myCourses.get(i).getCourseName());
        }
        System.out.print("번호 입력 (취소: 0): ");
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        if (idx < 1 || idx > myCourses.size()) return null;
        return myCourses.get(idx - 1);
    }

    // 실제 통계 출력은 하위 클래스에서 구현
    protected abstract void showStatistics(Course course);
}
