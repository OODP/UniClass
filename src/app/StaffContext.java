package app;

public class StaffContext {
    private Staff staff;
    private String state; // "pending", "approved", "rejected"

    public StaffContext(Staff staff) {
        this.staff = staff;
        this.state = "pending";
    }

    public Staff getStaff() {
        return staff;
    }

    public String getState() {
        return state;
    }

    public void approve() {
        this.state = "approved";
        // Auth에서 userDB에 등록
        Auth.userDB.put(staff.getId(), staff);
    }

    public void reject() {
        this.state = "rejected";
    }

    public String getStateName() {
        switch (state) {
            case "pending": return "대기";
            case "approved": return "승인";
            case "rejected": return "거절";
            default: return state;
        }
    }
}

