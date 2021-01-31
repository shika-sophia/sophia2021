/**
 * @title swing / sample / ChangeBounds.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.12 / p133 / change Layout
 * @see swing/sample/resultImage/ChangeBounds.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeBounds {
    ChangeBounds(){
        JFrame frame = new JFrame("ChangeBounds");
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("Button One");
        JButton btn2 = new JButton("Button Two");
        panel.add(btn1);
        panel.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn1.setBounds(20, 20, 220, 36);
                btn2.setBounds(20, 120, 220, 36);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn1.setBounds(20, 20, 220, 36);
                btn2.setBounds(20, 60, 220, 36);
            }
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 220);
        frame.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ChangeBounds();
    }//main()

}//class
