package command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // –½—ß‚Ì—ñ
    private Deque<Command> commands = new ArrayDeque<>();

    // Às
    @Override
    public void execute() {
        for (Command cmd: commands) {
            cmd.execute();
        }
    }

    // ’Ç‰Á
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // ÅŒã‚Ì–½—ß‚ğíœ
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    // ‘S•”íœ
    public void clear() {
        commands.clear();
    }
}
