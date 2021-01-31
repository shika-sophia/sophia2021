/**
 * @title swing / sample / Spliter.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.11 / p131 / Divide Panel
 * @see swing/sample/resultImage/Spliter.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Spliter extends JFrame {
    Spliter(){
        JTextArea txArea = new JTextArea(15, 10);
        txArea.setText("こちらはテキスト");

        JLabel label = new JLabel(new ImageIcon("WebContent/image/iconUN.gif"));
        JScrollPane scroll = new JScrollPane(label);

        JSplitPane spliter = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT, true, txArea, scroll);


        this.add(spliter);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Spliter");
        this.pack();
        this.setSize(360, 280);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Spliter();
    }//main()

}//class
