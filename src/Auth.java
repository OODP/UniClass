import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Auth {
    static final Map<String, User> userDB = new HashMap<>();

    static {
        userDB.put("prof", new Professor("prof", "1234", "교수 A", "P001"));
        userDB.put("staff", new Staff("staff", "1234", "교직원 A", "S001"));
        userDB.put("student", new Student("student", "1234", "학생 A", "22100434"));
    }


    //로그인 기능
    public static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID를 입력하시오 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하시오: ");
        String password = sc.nextLine();

        if(!userDB.containsKey(id) || (!userDB.get(id).getPassword().equals(password))) {
            System.out.println("id와 비밀번호가 일치하지 않습니다.");
            return null;
        }

        User user = userDB.get(id);
        System.out.println("----------------------------------------");
        System.out.println(user.getName() + "님 환영합니다!!");
        return user;
    }


    // 회원가입 기능
    public static void signUp() {
        Validate validate = new Validate();
        Scanner sc = new Scanner(System.in);
        System.out.print("새 ID: ");
        String id = sc.nextLine();

        boolean checkId = validate.isDuplicateId(id);
        if(!checkId) {
            System.out.println("ID 중복 검사 실패. 회원가입을 종료합니다.");
            return;
        }

        System.out.print("비밀번호: ");
        String pw = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("학번 혹은 직원, 교수 번호 입력(Unique ID): ");
        String uid = sc.nextLine();

        System.out.print("사용자 종류 선택 (1: 학생, 2: 교수, 3: 스태프): ");
        int type = sc.nextInt();
        sc.nextLine(); // 개행 제거

        User newUser = null;
        switch (type) {
            case 1:
                newUser = new Student(id, pw, name, uid);
                break;
            case 2:
                newUser = new Professor(id, pw, name, uid);
                break;
            case 3:
                newUser = new Staff(id, pw, name, uid);
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        userDB.put(id, newUser);
        System.out.println("회원가입이 완료되었습니다!");
    }


    // 로그아웃 기능
    public static void logout() {
        System.out.println("로그아웃 되었습니다.");
        return;
    }
}
