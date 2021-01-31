/**
 * @title javaPractice / swing / sample / TxtPane.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List5.5 / TxtPane.java
 * @see swing / sample / resultImage / TxtPane.jpg
 * @author shika
 * @date 2021-01-28
 */
package swing.sample;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class TxtPane extends JFrame {
    TxtPane() {
        JTextPane textPane = new JTextPane();
        JScrollPane scroll = new JScrollPane(textPane);
        this.getContentPane().add(scroll);

        StyleContext sc = new StyleContext();
        DefaultStyledDocument doc = new DefaultStyledDocument(sc);
        textPane.setDocument(doc);

        //表示するドキュメントを作成
        var bld = new StringBuilder();
        bld.append("このテキストをボールドにしたり、イタリックにしたりする。\n");
        bld.append("２行目\n");
        bld.append("タブを使うと\tこうなります。");

        try {
            doc.insertString(0, bld.toString(),
                sc.getStyle(StyleContext.DEFAULT_STYLE));

        } catch (BadLocationException e ) {
            e.printStackTrace();
        }

        //スタイルを変更する
        MutableAttributeSet attribute = new SimpleAttributeSet();
        StyleConstants.setBold(attribute, true);
        doc.setCharacterAttributes(7, 4, attribute, false);

        StyleConstants.setItalic(attribute, true);
        StyleConstants.setForeground(attribute, Color.RED);
        doc.setCharacterAttributes(16, 5, attribute, false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TxtPane");
        this.setSize(360, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new TxtPane();
    }//main()

}//class
