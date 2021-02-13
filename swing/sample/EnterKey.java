/**
 * @title swing / sample / EnterKey.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 8.8 / p175 / Enterキーでフォーカス
 * @author shika
 * @date 2021-02-13
 */
package swing.sample;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterKey extends JFrame {
    JTextField txF1 = new JTextField(30);
    JTextField txF2 = new JTextField(30);
    JTextField txF3 = new JTextField(30);

    class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                Object src = e.getSource();
                if(src.equals(txF1))
                    txF2.requestFocus();
                if(src.equals(txF2))
                    txF3.requestFocus();
                if(src.equals(txF3))
                    txF1.requestFocus();
            }
        }//keyPressed()

        public void keyReleased(KeyEvent e) { }
        public void keyTyped(KeyEvent e) { }
    }//class MyKeyListener

    EnterKey() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 2, 2));

        JLabel label1 = new JLabel("なんとか");
        panel.add(label1);
        panel.add(txF1);
        JLabel label2 = new JLabel("かんとか");
        panel.add(label2);
        panel.add(txF2);
        JLabel label3 = new JLabel("うんとか");
        panel.add(label3);
        panel.add(txF3);

        txF1.addKeyListener(new MyKeyListener());
        txF2.addKeyListener(new MyKeyListener());
        txF3.addKeyListener(new MyKeyListener());

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GetKeys");
        this.pack();
        this.setSize(280, 100);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new EnterKey();
    }//main()

}//class
