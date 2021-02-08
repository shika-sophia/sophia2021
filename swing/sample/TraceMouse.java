/**
 * @title swing / sample / TraceMouse.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List8.4 / p166 / TraceMouse
 * @see swing/sample/resultImage/TraceMouse.jpg
 * @author shika
 * @date 2021-02-08
 */
package swing.sample;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class TraceMouse extends JFrame {
    List<Point> posList = new ArrayList<Point>();

    public void paint(Graphics g) {
        super.paint(g);

        for(int i = 0; i < posList.size() - 1; i++) {
            int x1 = (int)posList.get(i).getX();
            int y1 = (int)posList.get(i).getY();
            int x2 = (int)posList.get(i+1).getX();
            int y2 = (int)posList.get(i+1).getY();
            g.drawLine(x1, y1, x2, y2);
        }
    }//paint()

    class MyMouseListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            Point pos = e.getPoint();
            posList.add(pos);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            posList.clear();
        }
    }//class MyMouseListener

    TraceMouse() {
        this.addMouseMotionListener(new MyMouseListener());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TraceMouse");
        this.setSize(300, 250);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new TraceMouse();
    }//main()

}//class
