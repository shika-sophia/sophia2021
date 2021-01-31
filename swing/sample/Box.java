/**
 * @title swing / sample / Border.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.3 / p108 / BoxLayout
 * @see
 * @author shika
 * @date 2021-01-29
 */
package swing.sample;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Box extends JFrame {
    Box() {
        JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton[] btn = new JButton[5];
        for(int i = 0; i < btn.length; i++) {
            btn[i] = new JButton("Button" + (i + 1));
            panel.add(btn[i]);
        }

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BoxLayout");
        this.pack();
        this.setSize(220, 180);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Box();
    }//main()

}//class

/*
//###### BoxLayout / 2021-01-29 ######
Y_AXIS で左端に寄った１列のボタン。
ウィンドゥを狭くしても折り返さず、隠れてしまう。

*/