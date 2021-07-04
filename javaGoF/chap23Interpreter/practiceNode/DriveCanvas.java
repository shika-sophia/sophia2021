package javaGoF.chap23Interpreter.practiceNode;

import java.awt.Canvas;
import java.awt.Graphics;

public class DriveCanvas extends Canvas {
    //---- field ----
    private int x; //current position
    private int y; //current position
    private int direction;
    private String[] directionAry = new String[]
                {"North","East","South","West"};

    public DriveCanvas() {
        this.x = 300;
        this.y = 300;
        this.direction = 0;
    }//constructor

    public void paint(Graphics g) {
        g.fillOval(x, y, 5, 5);
    }//paint()

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public String[] getDirectionAry() {
        return directionAry;
    }

}//class
