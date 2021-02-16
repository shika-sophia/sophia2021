/**
 * @title swing / sample / ProgressBar.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 12.3 / p241 / 進捗状況を示すバー
 * @author shika
 * @date 2021-02-16
 */
package swing.sample;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProgressBar extends JFrame {
    int counter = 0;

    ProgressBar() {
        this.setLayout(new BorderLayout());
        JProgressBar bar = new JProgressBar(0, 100);
        JLabel label = new JLabel("0");
        bar.setOrientation(SwingConstants.HORIZONTAL);
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText(
                    String.format("%d%% 完了", counter));
            }
        });//addChangeListener()
        this.add(bar, "North");
        this.add(label, "South");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ProgressBar");
        this.setSize(250, 140);
        this.setVisible(true);

        for(counter = 0; counter <= 100; ) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            bar.setValue(counter);
            counter += 5;
        }//for
    }//constructor

    public static void main(String[] args) {
        new ProgressBar();
    }//main()

}//class
