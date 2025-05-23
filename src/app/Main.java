package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.print("1.로그인 2.회원가입 3.종료\n=> ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    User user = Auth.login();
                    if (user != null) {
                        user.showMenu();
                    }
                    break;
                case 2:
                    Auth.signUp();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
}