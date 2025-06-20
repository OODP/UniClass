package app.observer;

import app.CourseManager;

public interface CourseObserver {
    void onEnrollmentChanged(CourseManager courseManager);
}