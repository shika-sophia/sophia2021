/**
 * @title multiThread / chap07MT / swingModel / MyFrame.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / 練習問題 7-5 / List 7-15, 7-16, 7-17
 * @content swingにおける ActionListenerの応答性改善
 * @author shika
 * @date 2021-03-10
 */
package multiThread.chap07MT.swingModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {

    public MyFrame() {
        super("MyFrame");
        JLabel label = new JLabel("Thread-Per-Message Sample");
        JButton button = new JButton("Execute");
        button.addActionListener(this);

        this.setLayout(new FlowLayout());
        this.add(label);
        this.add(button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        //---- SingleThread (mainThread only) ----
        //ButtonAction.service();

        //---- Thread per Message Pattern ----
        ExecutorService exeService
            = Executors.newCachedThreadPool();

        var btnAct = new ButtonAction(exeService);

        try {
            btnAct.request();
        } finally {
            exeService.shutdown();
        }
    }//actionPerformed()

    public static void main(String[] args) {
        new MyFrame();
    }//main()
}//class

/*
//====== Single Thread (mainThread only) ======
service: ..................................................
done.
service: ..................................................
done.

//====== Thread per Message Pattern ======
service: ..........service: .......................
service: .................................
service: ..........................................................................
done.

【考察】
SingleThreadでは「...」が出ている間、Button, closeなどの応答が遅延する。

Thread per Messageパターンにすると、「...」の途中でもボタンが反応し、
新しい serviceを始める。応答性は すごく向上する。
*/