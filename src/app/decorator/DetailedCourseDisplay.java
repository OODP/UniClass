package app.decorator;

import app.Course;
import java.util.List;

public class DetailedCourseDisplay extends CourseListDisplayDecorator {

    public DetailedCourseDisplay(CourseListDisplay decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void display(List<Course> courses) {
        System.out.println("🔍 [과목 상세 보기]");
        for (Course c : courses) {
            System.out.println("과목: " + c.getCourseName() + ", 학점: " + c.getCredit()
                    + ", 정원: " + c.getParticipants() + ", 교수: " + c.getProfessor().getName());
        }
    }
}
