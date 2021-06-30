package javaGoF.chap22Command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javaGoF.chap22Command.command.MacroCommand;

public class DrawCanvas extends Canvas implements IDrawable {
    private Color color;//描点の初期色
    private int radius; //描点の半径
    private MacroCommand history;

    public DrawCanvas(
            int width, int height, MacroCommand history) {
        super.setSize(width, height);
        super.setBackground(Color.WHITE);
        this.history = history;
        init();
    }

    public void init() {
        color = Color.RED;
        radius = 6;
    }

    //履歴全体を再描画
    public void paint(Graphics g) {
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }//draw()

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}//class
