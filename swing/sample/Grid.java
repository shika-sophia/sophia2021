/**
 * @title swing / sample / Grid.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.4 / p110 / GridLayout
 * @see swing/sample/resultImage/GridLayout.jpg
 * @author shika
 * @date 2021-01-29
 */
package swing.sample;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Grid extends JFrame {

    Grid() {
        GridLayout layout = new GridLayout(3, 4, 5, 5);
        this.setLayout(layout);

        JButton[] btn = new JButton[10];

        for(int i = 0; i < btn.length; i++) {
            btn[i] = new JButton("Button" + (i + 1));
            this.add(btn[i]);
        }//for

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GridLayout");
        this.pack();
        this.setSize(380, 180);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Grid();
    }//main()

}//class
