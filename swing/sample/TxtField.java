/**
 * @title javaPractice / swing / sample / TxtField.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List5.2 / TxtField.java
 *
 * @author shika
 * @date 2021-01-28
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TxtField extends JFrame {

    public static void main(String[] args) {
        TxtField frame = new TxtField();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(3, 1));
        JLabel label = new JLabel("Text Field");
        TextField textField = new TextField(40);
            textField.setText("表示するテキスト");

        JButton button = new JButton("クリック！");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textField.getText();
                label.setText(str);
            }
        });

        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setTitle("TextField");
        frame.pack();
        frame.setVisible(true);

    }//main()

}//class

/*
//###### TxtField.java / 2021-01-28 ######
自分で入れた文字列を読み取って、Labelに表示するGUIアプリ。

 */
