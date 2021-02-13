/**
 * @title swing / sample / ChkBox.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 9.1 / p187 / チェックボックス
 * @author shika
 * @date 2021-02-13
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChkBox extends JFrame {
    JPanel panel = new JPanel();
    JTextArea txArea = new JTextArea("こんにちは Java");
    JCheckBox chk = new JCheckBox("ボールド", false);

    ChkBox() {
        panel.setLayout(new BorderLayout());
        panel.add(chk, "North");
        panel.add(txArea, "Center");

        Font font = txArea.getFont();
        String fontName = font.getName();
        int fontSize = font.getSize();
        Font fontBold = new Font(fontName, Font.BOLD, fontSize);
        this.add(panel);

        chk.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(chk.isSelected()) {
                    txArea.setFont(fontBold);
                } else {
                    txArea.setFont(font);
                }
            }
        });//addChangeListener()

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ChkBox");
        this.pack();
        this.setSize(300, 180);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ChkBox();
    }//main()

}//class
