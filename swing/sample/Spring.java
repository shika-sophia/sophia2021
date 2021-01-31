/**
 * @title swing / sample / Spring.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.7 / p120 / SpringLayout
 * @see swing/sample/resultImage/SpringLayout.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Spring extends JFrame {
    Spring() {
        SpringLayout layout = new SpringLayout();

        JPanel panel = new JPanel(layout);
        JLabel labelName = new JLabel("Dog Name: ");
        JTextField txfName = new JTextField(20);
        panel.add(labelName);
        panel.add(txfName);

        layout.putConstraint(
            SpringLayout.WEST, labelName, 5, SpringLayout.WEST, panel);
        layout.putConstraint(
                SpringLayout.NORTH, labelName, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(
                SpringLayout.NORTH, txfName, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(
                SpringLayout.WEST, txfName, 10, SpringLayout.EAST, labelName);

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SpringLayout");
        this.pack();
        this.setSize(330, 120);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Spring();
    }//main()

}//class

/*
layout.putConstraint(
    SpringLayout.WEST, txfName, 10, SpringLayout.EAST, labelName);

２つのコンポーネントの記述位置を入れ替えると、ちゃんと表示されなかったので
この引数順は大事。
感覚的に txfNameが左(前)にあるのは表示結果と違うので不思議な気がする。
*/