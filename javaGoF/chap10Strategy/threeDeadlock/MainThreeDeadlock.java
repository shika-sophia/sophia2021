/**
 * @title javaGoF / chap10Strategy / threeDeadlock / MainThreeDeadlock.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第10章 Strategy / List 10-1 ～ 10-6
 * @content じゃんけん Three Hand Deadlock
 *          戦略(=アルゴリズム)をクラスで表し、切り替える
 *
 * @author shika
 * @date 2021-06-05
 */
package javaGoF.chap10Strategy.threeDeadlock;

public class MainThreeDeadlock {

    public static void main(String[] args) {
        int fightTimes = 10000;
        int seed1 = 12345;
        int seed2 = 67890;

        PlayerDeadlock player1 = new PlayerDeadlock(
            "Taro", new WinningStrategy(seed1));
        PlayerDeadlock player2 = new PlayerDeadlock(
            "Yuri", new HistoryStrategy(seed2));

        for(int i = 0; i < fightTimes; i++) {
            ThreeHand nextHand1 = player1.nextHand();
            ThreeHand nextHand2 = player2.nextHand();

            if(nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();

            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner: " + player2);
                player2.win();
                player1.lose();

            } else {
                System.out.println("Even..");
                player1.even();
                player2.even();
            }//if

            System.out.println("==== Total Result ====");
            System.out.println(player1.toString());
            System.out.println(player2.toString());
        }//for
    }//main()

}//class

