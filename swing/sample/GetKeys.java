/**
 * @title swing / sample / GetKeys.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content キー操作の検出 / List 8.7 / p175
 * @see resultImage / GetKeys.jpg
 * @author shika
 * @date 2021-02-13
 */
package swing.sample;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GetKeys extends JFrame {
    static TextArea txArea;

    void dispKey(String eventName, KeyEvent e) {
        char ch = e.getKeyChar();
        String str = "";
        if (Character.isLetterOrDigit(ch)) {
            str = String.format(
                "%s:[ %c ] KeyCode= %d \n",
                eventName, ch, e.getKeyCode());
        } else {
            str = String.format(
                    "%s: KeyCode= %d \n",
                    eventName, e.getKeyCode());
        }
        txArea.append(str);
    }//dispKey()

    class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            dispKey("KeyPressed", e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            dispKey(" KeyReleased", e);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            dispKey("KeyTyped", e);
        }
    }//class MyKeyListener

    public GetKeys() {
        txArea = new TextArea(20, 15);
        txArea.addKeyListener(new MyKeyListener());
        getContentPane().add(txArea);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GetKeys");
        this.pack();
        this.setSize(250, 250);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GetKeys();
    }//main()

}//class

