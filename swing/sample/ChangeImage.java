/**
 * @title swing / sample / ChangeImage.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.1 / p259 / イメージを表示しボタンで変える
 * @see sample / ImageLabel
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ChangeImage extends JFrame {
    ChangeImage() {
        JLabel label = new JLabel(
            new ImageIcon("WebContent/image/TakakiFantasia1200×800.jpg"));
        JScrollPane scroll = new JScrollPane(label);
        JButton button = new JButton("クリック");
        this.setLayout(new BorderLayout());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageChg = new ImageIcon("WebContent/image/sophia500.jpg");
                label.setIcon(imageChg);
            }
        });//addActionListener()

        button.setSize(100, 80);
        this.add(button, "South");
        this.getContentPane().add(scroll, "Center");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ChangeImage");
        setSize(550, 550);
        setVisible(true);
    }//construtor

    public static void main(String[] args) {
        new ChangeImage();
    }//main()

}//class

/*
//====== ChangeImage / 2021-02-18 ======
FlowLayoutだと ScrollPaneのバーが表示されない。
BorderLayoutだと、button.setSize()が機能しない。
*/