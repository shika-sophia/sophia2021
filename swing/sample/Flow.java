/**
 * @title javaPractice / swing / sample / Flow.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.1 / p103 / Flow.java
 * @see swing/sample/resultImage/FlowLayout.jpg
 * @author shika
 * @date 2021-01-29
 */
package swing.sample;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Flow extends JFrame {
    public Flow() {
        JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final int BTN_BOUND = 5;
        JButton[] btnAry = new JButton[BTN_BOUND];

        for(int i = 0; i < btnAry.length; i++) {
            btnAry[i] = new JButton("Button " + (i + 1));
            panel.add(btnAry[i]);
        }//for

        this.getContentPane().add(panel);
        this.setTitle("FlowLayout");
        this.pack();
        this.setSize(220, 180);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Flow();
    }//main()

}//class
