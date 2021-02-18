/**
 * @title swing / sample / ColorDlg.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.5 / p271 / 色選択ダイアログボックス
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorDlg extends JFrame {
    ColorDlg() {
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button = new JButton("色の選択");
        button.addActionListener(new ActionListener() {
            @Override
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorCho = new JColorChooser();
                Color color = colorCho.showDialog(frame, "色の選択", Color.WHITE);
                panel.setBackground(color);
            }
        });//addActionListener()
        panel.add(button);
        this.getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ColorDlg");
        setSize(350, 200);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ColorDlg();
    }//main()

}//class
