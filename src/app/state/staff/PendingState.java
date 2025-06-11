package app.state.staff;

import app.Auth;
import app.StaffContext;
import app.UserManager;

public class PendingState implements StaffState {
    @Override
    public void handleLogin(StaffContext context) {
        System.out.println("승인 대기 중입니다. 관리자의 승인을 기다려주세요.");
    }

    @Override
    public void handleApprove(StaffContext context) {
        context.setState(new ApprovedState());
        // userDB에 staff 등록
        Auth.userDB.put(context.getStaff().getId(), context.getStaff());
        UserManager.getInstance().addStaff(context.getStaff());
        System.out.println("승인 완료!");
    }

    @Override
    public void handleReject(StaffContext context) {
        context.setState(new RejectedState());
        System.out.println("거절 처리되었습니다.");
    }

    @Override
    public String getStateName() {
        return "대기";
    }
}

