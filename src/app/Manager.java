package app;

import app.commands.Command;
import app.invokers.ManagerCommandInvoker;
import app.commands.Manager.ViewStaffRequest;

import java.util.Scanner;

public class Manager extends User {

    public Manager(String id, String password, String name, String uniqueId) {
        super(id, password, name, uniqueId);
    }

    // Manager.java (일부)
    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        ManagerCommandInvoker invoker = new ManagerCommandInvoker();

        invoker.setCommand(1, new ViewStaffRequest());

        while (true) {
            System.out.println("\n================ 매니저 메뉴 ====================");
            System.out.println(" 1. 📋 관리자 승인 요청 목록 확인");
            System.out.println(" 2. 🔒 로그아웃");
            System.out.println("===============================================");
            System.out.print("👉 선택하세요 (1-2): ");

            int choice = sc.nextInt();
            System.out.println();

            if(choice == 2) {
                System.out.println("👋 로그아웃합니다...");
                return;
            }

            invoker.executeCommand(choice);

            System.out.println("\n[Enter 키를 눌러 계속하기...]");
            sc.nextLine(); // 남아있는 개행 제거
            sc.nextLine(); // 사용자 입력 대기

        }
    }
}
