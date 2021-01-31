/**
 * @title javaPractice / swing / sample / SampleButton.java
 * @refernce 日向俊二『JavaGUIプログラミング』カットシステム, 2020
 * @content List4.4 / SmplBtn.java
 * @author shika
 * @date 2021-01-27
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SampleButton extends JFrame {

    SampleButton() {
        JLabel label = new JLabel("ボタンをクリックしてください。");
        label.setPreferredSize(new Dimension(220, 40));

        JButton button1 = new JButton("ボタン１");
        button1.setPreferredSize(new Dimension(220, 40));
        JButton button2 = new JButton("ボタン２");
        button2.setPreferredSize(new Dimension(220, 40));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("ボタン１がクリックされました。");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("ボタン２がクリックされました。");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(button1, BorderLayout.CENTER);
        panel.add(button2, BorderLayout.SOUTH);

        //JFrame
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sample Button");
        pack();
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new SampleButton();
    }//main()

}//class
