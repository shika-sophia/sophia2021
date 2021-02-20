/**
 * @title multiThread / MTchap00GoodBank.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content List I1-10 / p20
 * @author shika
 * @date 2021-02-20
 */
package multiThread;

public class MTchap00GoodBank {
    private int money;
    private String userName;

    public MTchap00GoodBank(int money, String userName) {
        this.money = money;
        this.userName = userName;
    }

    public synchronized void deposit(int m) {
        money += m;
    }

    public synchronized boolean withDraw(int m) {
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
        }
    }

    public String getUserName() {
        return userName;
    }
}//class
