/**
 * @title swing / sample / MousePoint.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List8.3 / p164 / MousePoint
 * @author shika
 * @date 2021-02-08
 */
package swing.sample;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MousePoint extends JFrame {
    Point pos = null;

    public void paint(Graphics g) {
        super.paint(g);

        if(pos == null) {
            return;
        }

        int x = (int)pos.getX();
        int y = (int)pos.getY();
        String str = String.format("(%d,%d)", x, y);
        g.drawString(str, x, y);
    }//paint()

    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            pos = e.getPoint();
            repaint();
        }

        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }//class MyMouseListener

    MousePoint() {
        this.addMouseListener(new MyMouseListener());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MousePoint");
        this.setSize(300, 250);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new MousePoint();
    }//main()

}//class
