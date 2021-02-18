/**
 * @title swing / sample / BarGraph.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.8 / p277 / 棒グラフの描画
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class BarGraph extends JFrame {
    int[] data = new Random().ints(0, 100).limit(11)
        .map(i -> i + 1).toArray();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //横軸
        g.drawLine(50, 250, 250, 250);
        for(int i = 0; i < data.length; i++) {
            String str = String.format("%3d", i * 10);
            g.drawString(str, (i * 20 + 50), 270);
        }
        //縦軸
        g.drawLine(50, 40, 50, 250);
        for(int i = 0; i < data.length; i++) {
            String str = String.format("%3d", i * 10);
            g.drawString(str, 28, (254 - i * 20));
        }
        //データ
        for (int i = 0; i < data.length; i++) {
            int x = i * 20 + 50;
            int y = 250 - data[i] * 2;
            int w = 20;
            int h = data[i] * 2;
            g.drawRect(x, y, w, h);
        }
    }//paint()

    BarGraph() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BarGraph");
        setSize(300, 300);
        setVisible(true);

        //System.out.println("data: " + Arrays.toString(data));
        //data: [37, 30, 36, 36, 80, 97, 10, 30, 58, 71, 33]
    }

    public static void main(String[] args) {
        new BarGraph();
    }//main()

}//class
