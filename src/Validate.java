public class Validate {
    // ID 중복 검사
    public boolean isDuplicateId(String id) {
        if (Auth.userDB.containsKey(id)) {
            System.out.println("이미 존재하는 ID입니다.");
            return false;
        }
        return true;
    }
}
