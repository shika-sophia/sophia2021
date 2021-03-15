/**
 * @title multiThread / chap08MT / swingEventDispatch / CountUp.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / 練習問題 8-4
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

public class CountUp extends JFrame implements ActionListener {
    private final JLabel label = new JLabel("EvenDispatchThread Sample");
    private final JButton button = new JButton("Count Up");
    private volatile int count;

    public CountUp() {
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
        for(count = 0; count < 10; count++) {
            System.out.println(
                Thread.currentThread().getName() + " countUp: setText(" + count + ")");
            label.setText("" + count);
            //label.repaint();

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//countUp()

    public static void main(String[] args) {
        System.out.println(
            Thread.currentThread().getName() + ": BEGIN");
        new CountUp();
        System.out.println(
            Thread.currentThread().getName() + ": END");

    }//main()

}//class

/*
main: BEGIN
main: END
AWT-EventQueue-0 countUp: setText(0)
AWT-EventQueue-0 countUp: setText(1)
AWT-EventQueue-0 countUp: setText(2)
AWT-EventQueue-0 countUp: setText(3)
AWT-EventQueue-0 countUp: setText(4)
AWT-EventQueue-0 countUp: setText(5)
AWT-EventQueue-0 countUp: setText(6)
AWT-EventQueue-0 countUp: setText(7)
AWT-EventQueue-0 countUp: setText(8)
AWT-EventQueue-0 countUp: setText(9) <- ここで初めて swingの frameに「9」の表示

【論理バグ】 コンソールは ちゃんと出力されるが、
swingの frameは countUpにならず、最後に「9」だけ表示される問題。

＊label.setText()の直後に label.repaint();をしてみたが改善せず

＊SwingUtilities.invokeLater(new Rnnable() {
    public void run() {
        label.setText("" + count);
    }
  }
  上記に変更してみたが改善せず。
  Runnable.run()内に ローカル変数 iは実質 final以外不可だったので、
  countをフィールドに変更。

＊SwingUtilities.invokeAndWait()に変更。
AWT-EventQueue-0 countUp: setText(0)
java.lang.Error : Cannot call invokeAndWait from the event dispatcher thread

countUp()を呼び出しているのは
button.addActionListener(){ actionPerformed() }のため、
上記のようにスレッドは AWT-EventQueue-0
countUp()を実行しているのは EventDisptchThreadの様子。
よって上記の Error。
*/