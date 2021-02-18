/**
 * @title swing / sample / DrawFont.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.6 / p273 / 文字列の描画
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.JFrame;

public class DrawFont extends JFrame {
    String[] fontName = Stream.of(
        "Arial","Arial Bold","SanSerif","Courier","Century")
        .toArray(String[]::new);
    int[] fontStyle = IntStream.generate(() -> Font.PLAIN)
        .limit(fontName.length)
        .toArray();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        int y = 50;
        String str = "";
        for (int i = 0; i < fontName.length; i++) {
            int size = i * 4 + 12;
            Font font = new Font(
                fontName[i], fontStyle[i], size);
            str = font.getFontName();
            g.setFont(font);
            g.drawString(str, 20, y);
            y += size + 6;
        }//for
    }//paint()

    DrawFont() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DrawFont");
        setSize(280, 230);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new DrawFont();
    }//main()

}//class
