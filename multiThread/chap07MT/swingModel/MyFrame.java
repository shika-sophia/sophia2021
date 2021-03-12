/**
 * @title multiThread / chap07MT / swingModel / MyFrame.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / 練習問題 7-5 / List 7-15, 7-16, 7-17
 * @content swingにおける ActionListenerの応答性改善
 * @class ButtonAction / SingleThread, MultiThreadパターン
 * @class ButtonThread / 解答 List A7-5 / 毎回 new Threadする buttonAction
 * @class ButtonSync / 解答 List A7-6 / synchronized doService() 干渉しないが応答もしない。
 * @class ButtonBalking / 解答 List A7-7 / Balkingパターン。実行は最初の１回だけ。
 * @class ButtonCancel / 解答 List A7-8 / interruput()でキャンセルする。
 * @author shika
 * @date 2021-03-10, 3-12
 */
package multiThread.chap07MT.swingModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //---- new Thread per each called ----
        //ButtonThread.service();

        //---- synchronized doService ----
        //ButtonSync.service();

        //---- Balking Pattern ----
        //ButtonBalking.service();

        //---- interrupt() ----
        ButtonCancel.service();

//        //---- Thread per Message Pattern ----
//        ExecutorService exeService
//            = Executors.newCachedThreadPool();
//
//        var btnAct = new ButtonAction(exeService);
//
//        try {
//            btnAct.request();
//        } finally {
//            exeService.shutdown();
//        }
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

//====== 解答 A7-5 ButtonThread / new Thread per each call ======
service: ..........service: ........................
service: ......................................................................................
done.
...................
done.
...........
done.

//====== synchronized doService() ======
ボタン連打しても干渉しないが、応答もしない
service: ..................................................
done.
service: ..................................................
done.
service: ..................................................
done.

//====== Balking Pattern ======
ButtonBalking.service()
service: .........ButtonBalking.service()
 is balked.
..............ButtonBalking.service()
 is balked.
...........................
done.
ButtonBalking.service()
service: ....................ButtonBalking.service()
 is balked.
..............................
done.
ButtonBalking.service()
service: ..................................................
done.

//====== ButtonCancel ======
..................... cancelled.
ButtonCancel.service()
.............. cancelled.
ButtonCancel.service()
..................................................done.
*/
