/**
 * @title multiThread / chap10MT / swingExeCancel / MainExeCancelSW.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Termination / List 10-10, 10-11, 10-12
 * @content 練習問題 10-4 / ボタンを押すと Execute, Cancelができる swingモデル
 * @author shika
 * @date 2021-03-21
 */
package multiThread.chap10MT.swingExeCancel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainExeCancelSW
        extends JFrame implements ActionListener {
    private final JButton exeButton = new JButton(" Execute ");
    private final JButton cancelButton= new JButton(" Cancel ");

    public MainExeCancelSW() {
        super("MainExeCancelSW");
        JLabel label = new JLabel("Two-Phase-Termination");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(label);
        pane.add(exeButton);
        pane.add(cancelButton);

        exeButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object source = ev.getSource();
        if (source == exeButton) {
            //サービス実行開始
            ServiceAns.service();

        } else if(source == cancelButton) {
            //サービス中止
            ServiceAns.cancel();
        }
    }//actionPerformed()

    public static void main(String[] args) {
        new MainExeCancelSW();
    }//main()

}//class

/*
//====== ServiceAns, ServiceAnsThread ======
//---- Answer version ----
Service...........Service is balked.
..................... cancel.
 done/
【考察】
cancelで ちゃんと終了。

//---- Stream version ----
Service................Service is balked.
................ cancel.
.................. done/
【考察】　cancelしても 50個するまで止まらないのは Streamで書いたからのようだ。
 */
