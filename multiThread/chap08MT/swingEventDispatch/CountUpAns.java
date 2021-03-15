/**
 * @title multiThread / chap08MT / swingEventDispatch / CountUpAns.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / 練習問題 8-4, 解 List A8-5
 * @content swingで countUpを表示させる
 * @author shika
 * @date 2021-03-15
 */
package multiThread.chap08MT.swingEventDispatch;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CountUpAns extends JFrame implements ActionListener {
    private final JLabel label = new JLabel("EvenDispatchThread Sample");
    private final JButton button = new JButton("Count Up");

    public CountUpAns() {
        super("CountUp");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        getContentPane().add(button);
        button.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            countUp();
        }
    }//actionPerformed()

    private void countUp() {
        System.out.println(
            Thread.currentThread().getName() + " countUp: BEGIN");

        //invokerThread: 10秒sleep()後、SwingUtilities.invokeLater()を呼ぶ
        new Thread("invokerThread") {
            public void run() {
                System.out.println(
                    Thread.currentThread().getName() + " invokerThread: BEGIN");

                for(int i = 0; i < 10; i++) {
                    final String str = "" + i;

                    try {
                        //executorは EventDispatchThreadから呼ばれる
                        final Runnable executor = new Runnable() {
                            public void run() {
                                System.out.println(
                                    Thread.currentThread().getName() + " executor: BEGIN");
                                label.setText(str);
                                System.out.println(
                                    Thread.currentThread().getName() + " executor: END");
                            }//run()
                        };//executor

                        //executorを EventDispatchThreadに呼び出させる
                        SwingUtilities.invokeLater(executor);
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//for

                System.out.println(
                    Thread.currentThread().getName() + " invokerThread: END");
            }//run()
        }.start();//invokeThread

        System.out.println(
            Thread.currentThread().getName() + " countUp: END");
    }//countUp()

    public static void main(String[] args) {
        System.out.println(
            Thread.currentThread().getName() + ": BEGIN");
        new CountUpAns();
        System.out.println(
            Thread.currentThread().getName() + ": END");

    }//main()

}//class

/*
main: BEGIN
main: END
AWT-EventQueue-0 countUp: BEGIN
AWT-EventQueue-0 countUp: END
invokerThread invokerThread: BEGIN
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
AWT-EventQueue-0 executor: BEGIN
AWT-EventQueue-0 executor: END
invokerThread invokerThread: END

【実況】今度は ちゃんと swing frameで countUpできました。
*/