/**
 * @title swing / sample / Overlay.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.9 / p125 / OverlayLayout
 * @see swing/sample/resultImage/OverlayLayout.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Overlay extends JFrame {
    Overlay() {
        JPanel panel = new JPanel();
        OverlayLayout layout = new OverlayLayout(panel);
        panel.setLayout(layout);

        JButton btn1 = new JButton("Button 1");
            btn1.setForeground(Color.RED);
            btn1.setFont(new Font("Serif", Font.BOLD, 14));
            panel.add(btn1);

        JButton btn2 = new JButton("-- Button 2 --");
            btn2.setForeground(Color.GREEN);
            btn2.setFont(new Font("Serif", Font.BOLD, 18));
            panel.add(btn2);

        JButton btn3 = new JButton("<<< Button 3 >>>");
            btn3.setForeground(Color.BLUE);
            btn3.setFont(new Font("Serif", Font.BOLD, 22));
            panel.add(btn3);

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("OverlayLayout");
        this.pack();
        this.setSize(260, 150);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Overlay();
    }//main()

}//class
