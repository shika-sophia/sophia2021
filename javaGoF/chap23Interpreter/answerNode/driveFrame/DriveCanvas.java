package javaGoF.chap23Interpreter.answerNode.driveFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javaGoF.chap23Interpreter.answerNode.language.INodeExeFactory;
import javaGoF.chap23Interpreter.answerNode.language.INodeExecutor;
import javaGoF.chap23Interpreter.answerNode.language.NodeExeException;

public class DriveCanvas
        extends Canvas implements INodeExeFactory {
    static final int LENGTH = 30;     //goの長さ
    static final int DIRE_UP = 0;   //上方向
    static final int DIRE_RIGHT = 3;//右方向
    static final int DIRE_DOWN = 6; //下方向
    static final int DIRE_LEFT = 9; //左方向
    static final int TURN_RIGHT = +3;//右へ回頭
    static final int TURN_LEFT = -3; //左へ回頭
    static final int RADIUS = 3;//点の半径

    private int direction;   //方向
    private Point position;  //点の位置
    private INodeExecutor executor;

    public DriveCanvas(int width, int height) {
        super.setSize(width, height);
        initialize();
    }

    public void initialize() {
        Dimension display = getSize();
        this.position = new Point(display.width / 2, display.height / 2);
        this.direction = 0;
        super.setForeground(Color.RED);
        super.setBackground(Color.WHITE);

        Graphics g = getGraphics();
        if (g != null) {
            g.clearRect(0, 0, display.width, display.height);
        }
    }//initialize()

    public void paint(Graphics g) {
        initialize();
        if (executor != null) {
            try {
                executor.execute();
            } catch (NodeExeException e) {
                e.printStackTrace();
            }
        }
    }//paint()

    void setTurnDirection(int turnDirection) {
        setDirection(direction + turnDirection);
    }

    void setDirection(int direction) {
        if(direction < 0) {
            direction = 12 - (-direction) % 12;
        } else {
            direction = direction % 12;
        }

        this.direction = direction % 12;
    }//setDirection()

    void go(int length) {
        int newX = position.x;
        int newY = position.y;

        switch(direction) {
            case DIRE_UP:
                newY -= length;
                break;
            case DIRE_RIGHT:
                newX += length;
                break;
            case DIRE_LEFT:
                newX -= length;
                break;
            case DIRE_DOWN:
                newY += length;
                break;
            default:
                break;
        }//switch

        Graphics g = getGraphics();
        if(g != null) {
            g.drawLine(position.x, position.y, newX, newY);
            g.fillOval(
                newX - RADIUS, newY - RADIUS, (RADIUS * 2 + 1), (RADIUS * 2 + 1));
        }

        position.x = newX;
        position.y = newY;
    }//go()

    public void setExecutor(INodeExecutor executor) {
        this.executor = executor;
    }

    @Override
    public INodeExecutor createExecutor(String order) {
        if(order.equals("go")) {
            return new GoExecutor(this);
        } else if(order.equals("right")) {
            return new DirectionExecutor(this, TURN_RIGHT);
        } else if(order.equals("left")) {
            return new DirectionExecutor(this, TURN_LEFT);
        } else {
            return null;
        }
    }//createExecutor()

}//class
