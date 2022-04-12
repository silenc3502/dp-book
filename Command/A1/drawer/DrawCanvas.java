package drawer;

import command.MacroCommand;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class DrawCanvas extends Canvas implements Drawable {
    // •`‰æF
    private Color color;
    // •`‰æ‚·‚é“_‚Ì”¼Œa
    private int radius;
    // —š—ğ
    private MacroCommand history;

    // ƒRƒ“ƒXƒgƒ‰ƒNƒ^
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }

    // —š—ğ‘S‘Ì‚ğÄ•`‰æ
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    // ‰Šú‰»
    @Override
    public void init() {
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    // •`‰æ
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
