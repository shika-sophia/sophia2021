/**
 * @title multiThread / securityGate / UnSecurityGate.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content SingleTreadedExecution / 練習問題 1-5解答
 *
 * @class SecurityMain   // main()
 * @class UnSecurityGate // counter, enter(), exit()
 * @class CheckThread extends Thread // Threadコンストラクタ, run()
 *
 * @author shika
 * @date 2021-02-23
 */
package multiThread.chap01MT.securityGate;

public class SecurityMain {

    public static void main(String[] args) {
        System.out.println("Testing SecurityGate...");

        loop:
        for(int trial = 0; true; trial++) {
            var gate = new UnSecurityGate();
            var chkThread = new CheckThread[5];

            //CheckTread起動
            for(int i = 0; i < chkThread.length; i++) {
                chkThread[i] = new CheckThread(gate);
                chkThread[i].start();
            }

            //CheckTread終了待ち
            for(int i = 0; i < chkThread.length; i++) {
                try {
                    chkThread[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (gate.getCounter() == 0) {
                //矛盾していない
                System.out.print(".");
            } else {
                //矛盾を発見
                System.out.println("SecurityGate is NOT safe!");
                System.out.println("counter: " + gate.getCounter());
                System.out.println("trial: " + trial);
                break loop;
            }
        }//for trial

    }//main()

}//class

/*
Testing SecurityGate...
..................................
(エラーにならない・・)
*/