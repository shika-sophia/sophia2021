/**
 * @title multiThread / chap12MT / swingActiveObject / SearchSiteSW.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 ActiveObject /
 * @content 練習問題 12-3 / Swingで入力した文字列を検索(5秒後に用意したURL)を表示
 * @content 解答１ List A12-7 ～ A12-12 / サンプル１ ActiveObjectを利用
 * 解答２
 * 			＊能動オブジェクト searcher: 単語の検索というサービスを提供
 * 			＊能動オブジェクト MainFrame: JTextAreaへの表示
 * 			２つの能動オブジェクトが会話するように情報のやり取りをするモデル
 * @see result: swingAnsActiveObject.jpg
 * @author shika
 * @date 2021-03-28
 */
package multiThread.chap12MT.swingAnsActiveObject;

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

import multiThread.chap12MT.activeObjectPattern.activeObject.AbsResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.ActObj;
import multiThread.chap12MT.activeObjectPattern.activeObject.ActObjFactory;

public class MainFrameActiveObject
        extends JFrame implements ActionListener {
    private final JTextField txFld = new JTextField("word", 10);
    private final JTextArea txArea = new JTextArea(20, 30);
    private final JButton button = new JButton("Search");
    private final ActObj actObj = ActObjFactory.createActObj();
    private static String NEWLINE = System.getProperty("line.separator");

    public MainFrameActiveObject() {
        super("SwingActiveObject");
        getContentPane().setLayout(new BorderLayout());

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

    //Searchボタンが押されたとき
    @Override
    public void actionPerformed(ActionEvent e) {
        searchWord(txFld.getText());
    }//actionPerformed()

    //検索
    private void searchWord(final String word) {
        //検索の呼出
        final AbsResult<String> result = actObj.search(word);
        printTextArea("Searching " + word + "...");

        //検索結果を待つスレッド
        new Thread(() -> {
            //結果を待つ
            final String url = result.getResultValue();

            //結果ができたので EventDispathThreadに表示を依頼
            SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        printTextArea(
                            String.format("word = %s, URL = %s", word, url));
                    }//run()
                }
            );//invokeLater()
        }).start();
    }//searchWord()

    //TextAreaに表示
    private void printTextArea(String line) {
        txArea.append(line + NEWLINE);
    }

    public static void main(String[] args) {
        new MainFrameActiveObject();
    }//main()

}//class

/*
Servant: search(word)
Servant: found.
Servant: search(shika)
Servant: found.
Servant: search(swing)
Servant: found.
Servant: search(ddd)
Servant: found.

*/