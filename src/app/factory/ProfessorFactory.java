package app.factory;

import app.Professor;
import app.User;

public class ProfessorFactory extends UserFactory {
    @Override
    public User createUser(String id, String password, String name, String uniqueId) {
        return new Professor(id, password, name, uniqueId);
    }
}

