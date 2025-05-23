package app;

import app.state.staff.PendingState;
import app.state.staff.StaffState;

public class StaffContext {
    private Staff staff;
    private StaffState state;

    public StaffContext(Staff staff) {
        this.staff = staff;
        this.state = new PendingState();
    }

    public Staff getStaff() {
        return staff;
    }
    public void setState(StaffState state) {
        this.state = state;
    }
    public StaffState getState() {
        return state;
    }
    public String getStateName() {
        return state.getStateName();
    }

    // 행동 위임
    public void login() {
        state.handleLogin(this);
    }
    public void approve() {
        state.handleApprove(this);
    }
    public void reject() {
        state.handleReject(this);
    }
}


