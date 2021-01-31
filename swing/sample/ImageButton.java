/**
 * @title javaPractice / swing / sample / ImageButton.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List4.5 / ImageBtn.java
 * @author shika
 * @date 2021-01-27
 */
package swing.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageButton extends JFrame {

    ImageButton() {
        ImageIcon image = new ImageIcon("WebContent/image/iconUN.gif");
        JButton button = new JButton("Button", image);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ImageIcon("WebContent/image/iconFraulein.jpg");
                button.setIcon(image);
            }
        });

        //JFrame
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Image Button");
        setSize(520, 240);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ImageButton();
    }//main()

}//class
