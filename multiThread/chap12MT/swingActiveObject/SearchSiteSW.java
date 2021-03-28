/**
 * @title multiThread / chap12MT / swingActiveObject / SearchSiteSW.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 ActiveObject /
 * @content 練習問題 12-3 / Swingで入力した文字列を検索(5秒後に用意したURL)を表示
 *			検索中も制御は戻っており、文字列を入力可。
 * @content actionPerformed()で startSeach()を呼出。new Threadを起動し、制御はすぐ帰る。
 * 			JTextAreaは更新するので、EvaentDispatchThreadに実行してもらう。
 * @content EvaentDispatchで実行する内容を executorで定義し
 * 			SwingUtilities.invokeLater()で　EvaentDispatchに読み込ませる。
 *			Runnable executor = new Runnable(){ run(){ txArea.append() } }
 *			SwingUtilities.invokeLater(executor);
 *
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @see swing / sample / TxtField.java
 * @see multiThread / chap08MT / swingEventDispatch / CountUpAns.java
 * @see result: swingSearchSiteSW.jpg
 * @author shika
 * @date 2021-03-28
 */
package multiThread.chap12MT.swingActiveObject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class SearchSiteSW extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Query Word: ");
    JTextField txFld = new JTextField(20);
    JTextArea txArea = new JTextArea(20, 80);
    JScrollPane scroll = new JScrollPane(txArea);
    JButton button = new JButton("Search");

    public SearchSiteSW() {
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(txFld);
        panel.add(button);
        button.addActionListener(this);

        this.getContentPane().setLayout(new BorderLayout());
        this.add(panel, "North");
        this.add(scroll, "Center");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(300, 400);
        this.pack();
        this.setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = txFld.getText();
        txFld.setText("");
        txArea.append("Searching... \n");
        if(e.getSource() == button) {
            startSearch(str);
        }
    }//actionPerformed()

    //5秒後に 検索語を入れた固定文字列をイベントQueueにアップする新スレッド
    private void startSearch(String str) {
        System.out.println(
            Thread.currentThread().getName() + " startSearch: BEGIN");

        new Thread("SearchThread") {
            public void run() {
                System.out.println(
                    Thread.currentThread().getName() + " SearchThread: BEGIN");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //executorは EventDispatchThreadから呼ばれる
                final Runnable executor = new Runnable() {
                    public void run() {
                        System.out.println(
                            Thread.currentThread().getName() + ": executor() BEGIN");

                        String searchResult = "https://www.somewhere." + str + ".com/index.html \n";
                        txArea.append(searchResult);

                        System.out.println(
                            Thread.currentThread().getName() + ": executor() END");
                    }//Runnable.run()
                }; //executor

                //executorを EventDispatchThreadに呼び出させる
                SwingUtilities.invokeLater(executor);

                System.out.println(
                    Thread.currentThread().getName() + " SearchThread: END");
            }//SearchThread.run()
        }.start(); //SearchThread
    }//startSearch()

    public static void main(String[] args) {
        System.out.println(
            Thread.currentThread().getName() + ": BEGIN");

        new SearchSiteSW();

        System.out.println(
            Thread.currentThread().getName() + ": END");
    }//main()
}//class

/*
main: BEGIN
main: END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END
AWT-EventQueue-0 startSearch: BEGIN
SearchThread SearchThread: BEGIN
SearchThread SearchThread: END
AWT-EventQueue-0: executor() BEGIN
AWT-EventQueue-0: executor() END

*/