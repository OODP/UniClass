package app.state.staff;

import app.StaffContext;

public class ApprovedState implements StaffState {
    @Override
    public void handleLogin(StaffContext context) {
        // 로그인 성공 메시지는 Auth에서 처리
    }
    @Override
    public void handleApprove(StaffContext context) {
        System.out.println("이미 승인된 요청입니다.");
    }
    @Override
    public void handleReject(StaffContext context) {
        System.out.println("이미 승인된 요청은 거절할 수 없습니다.");
    }
    @Override
    public String getStateName() {
        return "승인";
    }
}
