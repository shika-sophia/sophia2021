/**
 * @title swing / sample / DrawShape.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.3 / p266 / 図形の描画
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawShape extends JFrame {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawLine(40, 45, 240, 45);

        g.setColor(Color.BLACK);
        g.drawRect(70, 90, 120, 80);

        g.setColor(Color.BLUE);
        g.drawOval(50, 50, 200, 150);
    }//paint()

    DrawShape() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DrawShape");
        setSize(280, 230);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new DrawShape();
    }//main()

}//class

/*
//====== DrawShape / 2021-02-18 ======
疑問点
@Overrideした paint()を どこからも呼び出していないのに、
勝手に描画している。なんじゃこりゃ。

JFrameのほうのコンストラクタ内に paint()を起動する記述があるのだろうか？

*/