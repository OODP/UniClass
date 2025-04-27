public class Auth {

    private String id;
    private String password;

    public boolean login(String id, String password) {
        if (id == null || password == null) {
            return false;
        }

        if (id.equals(this.id) && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        return;
    }

    public void signUp(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void validate() {
        return;
    }
}
