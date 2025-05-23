package app.commands.student;

import app.Course;
import app.CourseManager;
import app.commands.Command;
import app.strategy.CourseCodeSearchStrategy;
import app.strategy.CourseNameSearchStrategy;
import app.strategy.CourseSearchContext;
//import app.strategy.ProfessorNameSearchStrategy;

import java.util.List;
import java.util.Scanner;

public class SearchCourseCommand implements Command {
    private CourseManager cm;

    public SearchCourseCommand(CourseManager cm) {
        this.cm = cm;
    }


    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        CourseSearchContext context = new CourseSearchContext();
        List<Course> courseList = cm.getOpenedCourses();

        System.out.println("검색 기준을 선택하세요:");
        System.out.println("1. 과목명  2. 과목코드");
        System.out.print("=> ");
        int type = sc.nextInt();
        sc.nextLine(); // 개행 제거

        switch (type) {
            case 1:
                context.setStrategy(new CourseNameSearchStrategy());
                break;
            case 2:
                context.setStrategy(new CourseCodeSearchStrategy());
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        System.out.print("검색어를 입력하세요: ");
        String keyword = sc.nextLine();

        List<Course> result = context.search(courseList, keyword);

        System.out.println("\n🔎 [검색 결과]");
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        }
        else{
            for (Course course : result) {
                System.out.println(" - " + course.getCourseId() + ": " + course.getCourseName() +
                        " (" + course.getCredit() + "학점, " + course.getParticipants() + "명 수강 가능)");
            }
        }
    }
}
