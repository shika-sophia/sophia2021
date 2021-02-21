/**
 * @title multiThread / BadBank.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content 練習問題 問題I1-4
 * @author shika
 * @date 2021-02-20
 */
package multiThread.chap00MT;

import java.awt.Toolkit;

public class BadBank extends Thread {
    private int money;
    private String userName;

    public BadBank(int money, String userName) {
        this.money = money;
        this.userName = userName;
    }

    public void run() {
        for(int i = 0; i < 10000; i++) {
            deposit(1000);
            withDraw(2000);

//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.printf("%s : %s : %d \n",
                Thread.currentThread().getName(), userName, money);
        }
    }

    public void deposit(int m) {
        money += m;
    }

    public boolean withDraw(int m) {
        if(money >= m) {
            money -= m;
            check();
            return true;
        } else {
            return false;
        }
    }

    private void check() {
        if(money < 0) {
            System.out.println("預金残高がマイナスです。 money: " + money);
            Toolkit.getDefaultToolkit().beep();
            System.exit(0);
        }
    }//check()

    public String getUserName() {
        return userName;
    }

    public static void main(String[] args) {
        Thread th1 = new BadBank(5000, "Taro");
        Thread th2 = new BadBank(5000, "Jiro");
        Thread th3 = new BadBank(5000, "Kaori");

        th1.start();
        th2.start();
        th3.start();
    }//main()

}//class

/*
問題の意図は非synchronizedだとデータレースを起こして
money = -1000になるケースを再現すること。
似たようなコードを書けたけど、データレースはなかなか起きない・・
でも synchronizedしないと、いつかそれが起こるのは理解したので良しとして次に進もう。
*/
