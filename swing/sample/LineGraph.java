/**
 * @title swing / sample / LineGraph.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.9 / p279 / 折れ線グラフの描画
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class LineGraph extends JFrame {
    int[] data = new Random().ints(0, 100).limit(11)
            .map(i -> i + 1).toArray();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //横軸
        g.drawLine(50, 250, 250, 250);
        for(int i = 0; i < data.length; i++) {
            String str = String.format("%3d", i * 10);
            g.drawString(str, (i * 20 + 40), 270);
        }
        //縦軸
        g.drawLine(50, 40, 50, 250);
        for(int i = 0; i < data.length; i++) {
            String str = String.format("%3d", i * 10);
            g.drawString(str, 28, (250 - i * 20));
        }
        //データ
        for (int i = 0; i < (data.length - 1); i++) {
            int x1 = i * 20 + 50;
            int y1 = 250 - data[i] * 2;
            int x2 = (i + 1) * 20 + 50;
            int y2 = 250 - data[i + 1] * 2;
            g.setColor(Color.RED);
            g.drawLine(x1, y1, x2, y2);
        }
    }//paint()

    LineGraph() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LineGraph");
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LineGraph();
    }//main()

}//class
