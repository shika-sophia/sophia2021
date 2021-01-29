/**
 * @title swing / sample / Border.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.2 / p106 / enum, BorderLayout
 * @see
 * @author shika
 * @date 2021-01-29
 */
package swing.sample;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Border extends JFrame {
    public enum BtnDirect {
        NORTH, SOUTH, WEST, EAST, CENTER
    }

    public Border() {
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] btnAry = new JButton[BtnDirect.values().length];
        int i = 0;
        for(BtnDirect btnDir : BtnDirect.values()) {
            btnAry[i] = new JButton(btnDir.toString());
            i++;
        }

        this.add(btnAry[0], BorderLayout.NORTH);
        this.add(btnAry[1], BorderLayout.WEST);
        this.add(btnAry[2], BorderLayout.SOUTH);
        this.add(btnAry[3], BorderLayout.EAST);
        this.add(btnAry[4], BorderLayout.CENTER);

        this.setTitle("BorderLayout");
        this.pack();
        this.setSize(300, 160);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Border();
    }//main()

}//class

/*
//###### BorgerLayout / 2021-01-29 ######
NORTH, SOUTH が frameの端までいき、
WEST, EASTを上端から下端にすることはできない様子。
定義順を変えても配置は同じ。

enum、 String配列などで、BorderLayoutの定数は表現できない。
 -> container.add(compo, LayoutManager.FIELD)に for文を使えない。

BorderLayoutクラスにのフィールドを呼び出すわけだから、
NORTHなどその名前を書かないといけない。

*/