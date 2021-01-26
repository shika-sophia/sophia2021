/**
 * @title javaPractice / swing / sample / ImageLabel.java
 * @refernce 日向俊二『JavaGUIプログラミング』カットシステム, 2020
 * @content List4.2 / ImageLbl.java
 * @see swing/sample/resultImage/ImageLabel.jpg
 * @date 2021-01-26
 */

package swing.sample;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabel extends JFrame {
    public ImageLabel() {
        ImageIcon image = new ImageIcon(
            "WebContent/image/TakakiFantasia1200×800.jpg");
        JLabel label = new JLabel(image);
        JButton button = new JButton("クリック");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    ImageIcon image = new ImageIcon(
                        "WebContent/image/sophia500.jpg");
                    label.setIcon(image);
                }//actionPerformed()
            });
            button.setSize(100, 40);

        //JFrame
        setLayout(new GridLayout(2, 1, 5, 5));
        add(label);
        add(button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ImageLabel");
        pack();
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ImageLabel();
    }//main()

}//class

/*
//###### ImageLabel / 2021-01-26 ######
@see  swing/sample/resultImage/ImageLabel.jpg

【考察】
・イメージのpath: 「WebContent/image/sophia500.jpg」
     src内に imageフォルダを置いても読み込んでくれない。
     WebContent内に imageフォルダを置いて上記のように
     「WebContent/」の記述が必要。

・button のサイズが異様に大きいが setSize()をしても、
たぶん、setLayout()が優先されている様子。
*/