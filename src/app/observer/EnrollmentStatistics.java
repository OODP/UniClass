package app.observer;

import app.Course;
import app.CourseManager;

public class EnrollmentStatistics implements CourseObserver {

    @Override
    public void onEnrollmentChanged(CourseManager courseManager) {

        // 수강 인원과 대기 학생 수를 출력하는 메소드
        System.out.println("Enrollment Statistics:");
        for (Course course : courseManager.getCourses()) {
            int totalCapacity = course.getParticipants();
            int registeredStudents = course.getRegisteredStudents();
            int waitingStudents = course.getWaitingStudentList().size();
            System.out.printf("Course ID: %s, Total Capacity: %d, Registered Students: %d, Waiting Students: %d%n",
                    course.getCourseId(), totalCapacity, registeredStudents, waitingStudents);
        }
    }
}