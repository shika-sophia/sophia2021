/**
 * @title swing / sample / MouseCursor.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List8.5 / p169 / MouseCursor
 * @author shika
 * @date 2021-02-08
 */
package swing.sample;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseCursor extends JFrame {

    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Toolkit.getDefaultToolkit().beep();

            if(e.getButton() == MouseEvent.BUTTON1) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            if(e.getButton() == MouseEvent.BUTTON2) {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
            }

            if(e.getButton() == MouseEvent.BUTTON3) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }//mouseClicked()

        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }//class MyMouseListener

    MouseCursor() {
        addMouseListener(new MyMouseListener());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MouseCursor");
        this.setSize(300, 250);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new MouseCursor();
    }//main()

}//class
