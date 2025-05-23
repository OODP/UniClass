package app.state.staff;

import app.StaffContext;

public class RejectedState implements StaffState {
    @Override
    public void handleLogin(StaffContext context) {
        System.out.println("승인 요청이 거절되었습니다. 관리자에게 문의하세요.");
    }
    @Override
    public void handleApprove(StaffContext context) {
        System.out.println("거절된 요청은 승인할 수 없습니다.");
    }
    @Override
    public void handleReject(StaffContext context) {
        System.out.println("이미 거절된 요청입니다.");
    }
    @Override
    public String getStateName() {
        return "거절";
    }
}

