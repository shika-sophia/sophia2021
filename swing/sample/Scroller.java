/**
 * @title swing / sample / Scroller.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 12.2 / p238 / スクロールバー
 * @author shika
 * @date 2021-02-16
 */
package swing.sample;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Scroller extends JFrame {
    JScrollBar redScroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 255);
    JScrollBar greenScroll = new JScrollBar(JScrollBar.HORIZONTAL, 128, 1, 0, 255);
    JScrollBar blueScroll = new JScrollBar(JScrollBar.HORIZONTAL, 128, 1, 0, 255);
    JPanel panel = new JPanel();

    Scroller() {
        this.setLayout(new GridLayout(4, 1));
        AdjustmentListener listener = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int red = redScroll.getValue();
                int green = greenScroll.getValue();
                int blue = blueScroll.getValue();
                panel.setBackground(new Color(red, green, blue));
            }
        };//listener

        redScroll.addAdjustmentListener(listener);
        greenScroll.addAdjustmentListener(listener);
        blueScroll.addAdjustmentListener(listener);
        add(redScroll);
        add(greenScroll);
        add(blueScroll);
        add(panel);
        redScroll.setValue(128); //初期値を表示

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Scroller");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Scroller();
    }//main()

}//class
