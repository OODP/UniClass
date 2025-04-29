public class Main {
    public static void main(String[] args) {
        while(true) {
            User user = Auth.login();
            if (user != null) {
                user.showMenu();
            }
        }
    }
}