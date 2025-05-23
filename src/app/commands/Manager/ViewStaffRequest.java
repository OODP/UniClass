package app.commands.Manager;

import app.Auth;
import app.StaffContext;
import app.commands.Command;
import app.state.staff.PendingState;

import java.util.List;
import java.util.Scanner;

// ViewStaffRequest (Command)
public class ViewStaffRequest implements Command {
    @Override
    public void execute() {
        List<StaffContext> pending = Auth.pendingStaff;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n================ 승인 요청 목록 ====================");
        int cnt = 0;
        for (int i = 0; i < pending.size(); i++) {
            StaffContext ctx = pending.get(i);
            if (ctx.getState() instanceof PendingState) {
                cnt++;
                System.out.printf("%d. %s (%s) - 상태: %s\n", i+1, ctx.getStaff().getName(), ctx.getStaff().getUniqueId(), ctx.getStateName());
            }
        }
        if (cnt == 0) {
            System.out.println("대기 중인 요청이 없습니다.");
            return;
        }
        System.out.println("===================================================");
        System.out.print("👉 처리할 번호 (0:취소): ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx > 0 && idx <= pending.size() && pending.get(idx-1).getState() instanceof PendingState) {
            StaffContext ctx = pending.get(idx-1);
            System.out.println(" 1. 📘 승인");
            System.out.println(" 2. ❌ 거절");
            System.out.print("👉 선택하세요 (1-2): ");
            int action = sc.nextInt();
            sc.nextLine();
            if (action == 1) {
                ctx.approve(); // State 패턴으로 승인 처리
            } else if (action == 2) {
                ctx.reject(); // State 패턴으로 거절 처리
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        } else if (idx == 0) {
            System.out.println("취소합니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}

