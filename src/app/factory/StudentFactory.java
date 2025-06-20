package app.factory;

import app.Student;
import app.User;

public class StudentFactory extends UserFactory {
    @Override
    public User createUser(String id, String password, String name, String uniqueId) {
        return new Student(id, password, name, uniqueId);
    }
}

