import java.util.Scanner;

public class Auth {

    private String id;
    private String password;

    public static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID를 입력하시오 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하시오: ");
        String pw = sc.nextLine();

        // 테스트용 로그인 로직
        if (id.equals("prof")) return new Professor(id, pw, "교수 A", "P001");
        if (id.equals("staff")) return new Staff(id, pw, "교직원 A", "S001");
        if (id.equals("student")) return new Student(id, pw, "학생 A", "ST001");

        System.out.println("id와 비밀번호가 일치하지 않습니다.");
        return null;
    }

    public void logout() {
        System.out.println("로그아웃 되었습니다.");
        return;
    }

    public void signUp() {
        System.out.println("=====회원가입 페이지=====");
        Scanner sc = new Scanner(System.in);
        System.out.print("ID를 입력하시오 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하시오: ");
        String pw = sc.nextLine();
        System.out.print("이름을 입력하시오: ");
        System.out.println("회원가입 성공");
    }

    public void validate() {
        return;
    }
}
