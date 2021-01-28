/**
 * @title javaPractice / swing / sample / TextArea.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List5.3 / TxtArea.java
 * @see swing / sample / resultImage / TxtArea.jpg
 * @author shika
 * @date 2021-01-28
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TxtArea extends JFrame {

    public static void main(String[] args) {
        TxtArea frame = new TxtArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(3, 1));
        JLabel label = new JLabel("TextAreaサンプル");
        TextArea textarea = new TextArea("", 5, 40);
        textarea.setText("表示するテキスト\n");
        textarea.append("２行目のテキスト");

        JButton button = new JButton("Close");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

        panel.add(label, BorderLayout.NORTH);
        panel.add(textarea, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setTitle("TextArea");
        frame.pack();
        frame.setVisible(true);
    }//main()

}//class

/*
//###### TxtArea / 2021-01-28 ######
@see swing / sample / resultImage / TxtArea.jpg
スクロールＢＡＲを標準装備。複数行のテキストを表示・編集。

*/