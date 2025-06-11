package app;

import java.util.*;

public class Auth {
    public static final Map<String, User> userDB = new HashMap<>();
    public static final List<StaffContext> StaffList = new ArrayList<>();

    // 초기 data
    static {
        userDB.put("prof", new Professor("prof", "1234", "교수 A", "P001"));
        userDB.put("staff", new Staff("staff", "1234", "교직원 A", "S001"));
        userDB.put("student", new Student("student", "1234", "학생 A", "22100434"));
        userDB.put("manager", new Manager("manager", "1234", "매니저 A", "M001"));

        // UserManager 인스턴스 생성
        UserManager um = UserManager.getInstance();
        um.addProfessor((Professor) userDB.get("prof"));
        um.addStudent((Student) userDB.get("student"));
        um.addStaff((Staff) userDB.get("staff"));
        um.addManager((Manager) userDB.get("manager"));
    }


    //로그인 기능
    public static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID를 입력하시오 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하시오: ");
        String password = sc.nextLine();

        // userDB에 있으면 정상 로그인

        if (userDB.containsKey(id) && userDB.get(id).getPassword().equals(password)) {
            User user = userDB.get(id);

            if (user instanceof Student) {
                Student stu = UserManager.getInstance().findStudentById(id);
                System.out.println("----------------------------------------");
                System.out.println(user.getName() + "님 환영합니다!!");
                return stu;
            } else if (user instanceof Professor) {
                Professor prof = UserManager.getInstance().findProfessorById(id);
                System.out.println("----------------------------------------");
                System.out.println(user.getName() + "님 환영합니다!!");
                return prof;
            } else if (user instanceof Staff) {
                Staff staff = UserManager.getInstance().findStaffById(id);
                System.out.println("----------------------------------------");
                System.out.println(user.getName() + "님 환영합니다!!");
                return staff;
            } else if (user instanceof Manager) {
                Manager manager = UserManager.getInstance().findManagerById(id);
                System.out.println("----------------------------------------");
                System.out.println(user.getName() + "님 환영합니다!!");
                return manager;
            }
        }



        // pendingStaff에서 대기/거절 상태인지 State 패턴으로 처리
        for (StaffContext ctx : StaffList) {
            if (ctx.getStaff().getId().equals(id) && ctx.getStaff().getPassword().equals(password)) {
                ctx.login(); // 상태별 메시지 출력
                return null;
            }
        }
        System.out.println("id와 비밀번호가 일치하지 않습니다.");
        return null;
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

        // 사용자 종류에 따라 객체 생성 및 DB에 추가
        UserManager um = UserManager.getInstance();
        User newUser = null;
        switch (type) {
            case 1:
                newUser = new Student(id, pw, name, uid);
                userDB.put(id, newUser);
                um.addStudent((Student) newUser);
                System.out.println("회원가입이 완료되었습니다!");
                break;
            case 2:
                newUser = new Professor(id, pw, name, uid);
                userDB.put(id, newUser);
                um.addProfessor((Professor) newUser);
                System.out.println("회원가입이 완료되었습니다!");
                break;
            case 3:
                Staff staff = new Staff(id, pw, name, uid);
                StaffContext ctx = new StaffContext(staff);
                StaffList.add(ctx);
                System.out.println("승인 요청이 접수되었습니다. 관리자의 승인을 기다려주세요.");
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }
    }


    // 로그아웃 기능
    public static void logout() {
        System.out.println("로그아웃 되었습니다.");
        return;
    }
}
