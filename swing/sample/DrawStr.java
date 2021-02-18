/**
 * @title swing / sample / DrawStr.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.6 / p273 / 文字列の描画
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyLabel extends JLabel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.drawString("ラベルに書いたテキスト", 1, 14);
    }
}//class MyLabel

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawString("パネルに書いたテキスト", 10, 50);
    }
}//class MyPanel

public class DrawStr extends JFrame {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.drawString("フレームのクライアント領域に書いたテキスト", 10, 200);
    }

    DrawStr() {
        MyLabel label = new MyLabel();
        label.setText("                             ");
        MyPanel panel = new MyPanel();
        panel.add(label);
        this.getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DrawStr");
        setSize(300, 230);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new DrawStr();
    }//main()

}//class

/*
//====== DrawStr / 2021-02-18 ======
label.setText("");の異様な空白は、
空白部分にしか、paint()で書いた文字列が描画されないため。
setText()をコメントアウトすると、「ラベルに書いたテキスト」部分は表示されない。
*/