/**
 * @title swing / sample / LineGraph.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.10 / p281 / 円グラフの描画
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

public class Piechart extends JFrame {
    int[] data = new Random().ints(0, 100).limit(6)
            .map(i -> i + 1).toArray();
    int total = Arrays.stream(data).sum();
    final double PIE = 3.1416;

    @Override
    public void paint(Graphics g) {
        //円を描く
        g.drawArc(40, 40, 200, 200, 0, 360);
        double angle = -0.5 * PIE;
        double sweepAngle = 0;
        //最初の線
        g.drawLine(140, 140, 140, 40);

        //dataの個数だけ線を描く
        for (int i = 0; i < data.length; i++) {
            sweepAngle = 2 * PIE * data[i] / total; //ラジアン単位
            angle += sweepAngle;
            int x = 140 + (int)(100.0 * Math.cos(angle));
            int y = 140 + (int)(100.0 * Math.sin(angle));
            g.drawLine(140, 140, x, y);
        }
    }//paint()

    Piechart() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Piechart");
        setSize(280, 270);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Piechart();
    }//main()

}//class
