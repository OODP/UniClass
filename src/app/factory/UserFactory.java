package app.factory;

import app.User;

public abstract class UserFactory {
    public abstract User createUser(String id, String password, String name, String uniqueId);
}
