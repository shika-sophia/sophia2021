/**
 * @title swing / sample / ScrollImage.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 13.2 / p249 / スクロール付き画像
 * @author shika
 * @date 2021-02-17
 */
package swing.sample;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ScrollImage extends JFrame {
    ScrollImage() {
        ImageIcon image = new ImageIcon(
            "WebContent/image/TakakiFantasia1200×800.jpg");
        JLabel label = new JLabel(image);
        JScrollPane scroll = new JScrollPane(label);
        this.getContentPane().add(scroll);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ScrollImage");
        this.setSize(320, 240);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ScrollImage();
    }//main()

}//class
