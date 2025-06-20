package app.factory;

import app.Manager;
import app.User;

public class ManagerFactory extends UserFactory {
    @Override
    public User createUser(String id, String password, String name, String uniqueId) {
        return new Manager(id, password, name, uniqueId);
    }
}

