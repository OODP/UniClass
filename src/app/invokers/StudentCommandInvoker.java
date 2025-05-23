package app.invokers;

import app.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class StudentCommandInvoker {
    private final Map<Integer, Command> commandMap = new HashMap<>();

    public void setCommand(int key, Command command) {
        commandMap.put(key, command);
    }

    public void executeCommand(int key) {
        Command command = commandMap.get(key);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("❗ 잘못된 선택입니다.");
        }
    }
}