package app.commands.professor;

import app.CourseManager;
import app.Course;
import app.Professor;
import app.commands.Command;

import java.util.List;
import java.util.Scanner;

public class HandleWaitingListCommand implements Command {
    private CourseManager courseManager;
    private Professor professor;


    public HandleWaitingListCommand(CourseManager courseManager, Professor professor) {
        this.courseManager = courseManager;
        this.professor = professor;
    }

    @Override
    public void execute() {

// 기능 주석처리된 상태입니다. 구현이 완성되면 여기에 추가하세요.
// 예시: courseManager.showAndHandleWaitingList(professor);
        System.out.println("❗ 기능이 아직 구현되지 않았습니다.");

    }
}
