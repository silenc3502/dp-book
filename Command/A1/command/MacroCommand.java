package command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // ���߂̗�
    private Deque<Command> commands = new ArrayDeque<>();

    // ���s
    @Override
    public void execute() {
        for (Command cmd: commands) {
            cmd.execute();
        }
    }

    // �ǉ�
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // �Ō�̖��߂��폜
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    // �S���폜
    public void clear() {
        commands.clear();
    }
}
