/**
 * @title multiThread / chap12MT / swingAnsConcurrent / MainFrameConcurrent.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 ActiveObject / 練習問題 12-3
 * @content 解２ List A12-14 ～ A12-18 / swingにサンプル２を利用
 * 			＊能動オブジェクト Searcher: 単語の検索というサービスを提供
 * 			＊能動オブジェクト MainFrame: JTextAreaへの表示
 * 			２つの能動オブジェクトが会話するように情報のやり取りをするモデル
 * @see result: swingAnsConcurrent.jpg
 * @author shika
 * @date 2021-03-29
 */
package multiThread.chap12MT.swingAnsConcurrent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainFrameConcurrent
        extends JFrame implements Display, ActionListener {
    private final JTextField txFld = new JTextField("word", 10);
    private final JTextArea txArea = new JTextArea(20, 30);
    private final JButton button = new JButton("Search");
    private final Searcher searcher = SearchFacory.createSearcher();
    private static String NEWLINE = System.getProperty("line.separator");

    public MainFrameConcurrent() {
        super("SwingAnsConcurrent");
        this.getContentPane().setLayout(new BorderLayout());

        //North
        JPanel north = new JPanel();
        JLabel label = new JLabel("Search: ");
        north.add(label);
        north.add(txFld);
        north.add(button);
        button.addActionListener(this);

        //Center
        JScrollPane center = new JScrollPane(txArea);

        //Layout
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);

        //JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        searchWord(txFld.getText());
    }

    private void searchWord(String word) {
        //検索の呼出
        searcher.search(word, this);
        printTextArea("Searching " + word + "...");
    }//searchWord()

    //JTextAreaに表示
    private void printTextArea(String str) {
        txArea.append(str + NEWLINE);
    }//printTextArea()

    //EventDispatchThreadに表示を依頼
    public void display(final String str) {
        SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    printTextArea(str);
                }//run()
            }
        );//invokeLater()
    }//display()

    public static void main(String[] args) {
        new MainFrameConcurrent();
    }//main()
}//class

/*
@see result: swingAnsConcurrent.jpg

//---- console ----
search(word)
..................................................seach() found.
search(word0)
..................................................seach() found.
search(shika)
..................................................seach() found.
search(shika2)
..................................................seach() found.
search(shika22)
..................................................seach() found.

*/