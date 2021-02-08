/**
 * @title swing / sample / MouseClick.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List8.1 / p157 / MouseClick
 * @see swing/sample/resultImage/MouseClick.jpg
 * @author shika
 * @date 2021-02-08
 */
package swing.sample;

import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseClick extends JFrame {
    static TextArea txtbox;

    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            String str = String.format(
                "mouseClicked( %d, %d)\n", e.getX(), e.getY());
            txtbox.append(str);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            txtbox.append("mousePressed \n");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            txtbox.append("mouseReleased \n");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            txtbox.append("mouseEntered \n");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            txtbox.append("mouseExited \n");
        }
    }//class MyMouseListener

    MouseClick() {
        txtbox = new TextArea(20, 15);
        txtbox.addMouseListener(new MyMouseListener());
        this.getContentPane().add(txtbox);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MouseClick");
        this.setSize(300, 250);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new MouseClick();
    }//main()

}//class
