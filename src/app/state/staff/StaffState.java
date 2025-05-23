package app.state.staff;

import app.StaffContext;

// State 인터페이스
public interface StaffState {
    void handleLogin(StaffContext context);
    void handleApprove(StaffContext context);
    void handleReject(StaffContext context);
    String getStateName();
}

