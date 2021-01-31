/**
 * @title javaPractice / swing / sample / ScrollLabel.java
 * @refernce 日向俊二『JavaGUIプログラミング』カットシステム, 2020
 * @content List4.3 / ScrollLbl.java
 * @see swing/sample/resultImage/ScrollLabel.jpg
 * @date 2021-01-26
 */
package swing.sample;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ScrollLabel extends JFrame {
    ScrollLabel() {
        JLabel label = new JLabel(
            new ImageIcon("WebContent/image/TakakiFantasia1200×800.jpg"));
        JScrollPane scroll = new JScrollPane(label);

        //JFrame
        add(scroll);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Scroll Label");
        setSize(720, 560);
        setVisible(true);

    }//constructor

    public static void main(String[] args) {
        new ScrollLabel();
    }//main()

}//class
