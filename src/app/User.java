package app;

abstract public class User {

    private final String id;
    private final String password;
    private final String name;
    private final String uniqueId;

    public User(String id, String password, String name, String uniqueId) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.uniqueId = uniqueId;
    }

    // 템플릿 메소드 패턴
    public final void userTemplate() {
        showMenu();
    }

    //메뉴 보여주기
    protected abstract void showMenu();

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

}
