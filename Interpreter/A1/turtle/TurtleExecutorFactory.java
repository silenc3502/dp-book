package turtle;

import language.Executor;
import language.ExecutorFactory;

public class TurtleExecutorFactory implements ExecutorFactory {
    private final TurtleCanvas canvas;

    // �����N���X�i"go"�����s�j
    private class GoExecutor implements Executor {
        @Override
        public void execute() {
            canvas.go(TurtleCanvas.UNIT_LENGTH);
        }
    }

    // �����N���X�i"left"�����s�j
    private class LeftExecutor implements Executor {
        @Override
        public void execute() {
            canvas.setRelativeDirection(TurtleCanvas.RELATIVE_DIRECTION_LEFT);
        }
    }

    // �����N���X�i"right"�����s�j
    private class RightExecutor implements Executor {
        @Override
        public void execute() {
            canvas.setRelativeDirection(TurtleCanvas.RELATIVE_DIRECTION_RIGHT);
        }
    }

    // �R���X�g���N�^
    public TurtleExecutorFactory(TurtleCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Executor createExecutor(String name) {
        if (name.equals("go")) {
            return new GoExecutor();
        } else if (name.equals("right")) {
            return new RightExecutor();
        } else if (name.equals("left")) {
            return new LeftExecutor();
        } else {
            throw new IllegalArgumentException("Error: Unknown <primitive command>: '" + name + "'");
        }
    }
}
