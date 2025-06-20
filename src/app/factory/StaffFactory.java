package app.factory;

import app.Staff;
import app.User;

public class StaffFactory extends UserFactory {
    @Override
    public User createUser(String id, String password, String name, String uniqueId) {
        return new Staff(id, password, name, uniqueId);
    }
}

