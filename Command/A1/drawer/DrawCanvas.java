package drawer;

import command.MacroCommand;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class DrawCanvas extends Canvas implements Drawable {
    // �`��F
    private Color color;
    // �`�悷��_�̔��a
    private int radius;
    // ����
    private MacroCommand history;

    // �R���X�g���N�^
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }

    // ����S�̂��ĕ`��
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    // ������
    @Override
    public void init() {
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    // �`��
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
