/**
 * @title swing / sample / MouseBtn.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List8.2 / p160 / MouseBtn
 * @see swing/sample/resultImage/MouseBtn.jpg
 * @author shika
 * @date 2021-02-08
 */
package swing.sample;

import java.awt.TextArea;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseBtn extends JFrame {
    static TextArea txtbox;

    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            StringBuilder bld = new StringBuilder();
            //押されているマウス
            int btnNow = e.getButton();
            if(btnNow == MouseEvent.BUTTON1) {
                bld.append("左ボタン ");
            }

            if(btnNow == MouseEvent.BUTTON2) {
                bld.append("中央ボタン ");
            }

            if(btnNow == MouseEvent.BUTTON3) {
                bld.append("右ボタン ");
            }

            //押されているキー
            int modifier = e.getModifiersEx();
            if((modifier & InputEvent.SHIFT_DOWN_MASK)
                == InputEvent.SHIFT_DOWN_MASK) {
                bld.append("Shift ");
            }

            if((modifier & InputEvent.CTRL_DOWN_MASK)
                    == InputEvent.CTRL_DOWN_MASK) {
                    bld.append("Ctrl ");
            }

            if((modifier & InputEvent.ALT_DOWN_MASK)
                    == InputEvent.ALT_DOWN_MASK) {
                    bld.append("Alt ");
            }

            if((modifier & InputEvent.META_DOWN_MASK)
                    == InputEvent.META_DOWN_MASK) {
                    bld.append("Meta ");
            }

            bld.append("\n");
            txtbox.append(bld.toString());
        }//mouseClicked()

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }//class MyMouseListener

    MouseBtn() {
        txtbox = new TextArea(20, 15);
        txtbox.addMouseListener(new MyMouseListener());
        this.getContentPane().add(txtbox);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MouseBtn");
        this.setSize(300, 250);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new MouseBtn();
    }//main()

}//class
