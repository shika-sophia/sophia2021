/**
 * @title javaGoF / chap10Strategy / threeDeadlock / MainThreeDeadlock.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第10章 Strategy / List 10-1 ～ 10-6, 練習問題 10-1
 * @content じゃんけん [英]Jyanken, Three Hand Deadlock
 *          戦略(=アルゴリズム)をクラスで表し、インスタンスごとに切り替える
 *
 * @class MainThreeDeadlock / ◆main() new PlayerDeadlock() of Taro, Yuri
 * @class PlayerDeadlock
 * @class ThreeHand
 * @interface IThreeStrategy
 * @class WinningStrategy implements IThreeStrategy
 *        / 勝ったら次も同じものを出すアルゴリズム
 * @class HistoryStrategy implements IThreeStrategy
 *        / それぞれの手の勝ち数を記録し、
 *          前の手から勝ち数の大きいものを決めるアルゴリズム
 * @class RandomList implements IThreeStrategy
 *        / ランダムに次の手を決める
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

        //PlayerDeadlock player1 = new PlayerDeadlock(
        //    "Taro", new WinningStrategy(seed1));
        PlayerDeadlock player1 = new PlayerDeadlock(
            "Jiro", new RandomStrategy(seed1));
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
        }//for

        System.out.println("==== Total Result ====");
        System.out.println(player1.toString());
        System.out.println(player2.toString());

    }//main()

}//class

/*
Winner: [ Yuri: Game 9963, Win 3543, Lose 3190 ]
Winner: [ Yuri: Game 9964, Win 3544, Lose 3190 ]
Winner: [ Taro: Game 9965, Win 3190, Lose 3545 ]
Even..
Even..
Winner: [ Taro: Game 9968, Win 3191, Lose 3545 ]
Winner: [ Yuri: Game 9969, Win 3545, Lose 3192 ]
Even..
Winner: [ Taro: Game 9971, Win 3192, Lose 3546 ]
Winner: [ Yuri: Game 9972, Win 3546, Lose 3193 ]
Winner: [ Yuri: Game 9973, Win 3547, Lose 3193 ]
Winner: [ Taro: Game 9974, Win 3193, Lose 3548 ]
Even..
Winner: [ Yuri: Game 9976, Win 3548, Lose 3194 ]
Winner: [ Taro: Game 9977, Win 3194, Lose 3549 ]
Winner: [ Taro: Game 9978, Win 3195, Lose 3549 ]
Winner: [ Taro: Game 9979, Win 3196, Lose 3549 ]
Winner: [ Taro: Game 9980, Win 3197, Lose 3549 ]
Winner: [ Taro: Game 9981, Win 3198, Lose 3549 ]
Winner: [ Yuri: Game 9982, Win 3549, Lose 3199 ]
Winner: [ Taro: Game 9983, Win 3199, Lose 3550 ]
Even..
Winner: [ Yuri: Game 9985, Win 3550, Lose 3200 ]
Winner: [ Yuri: Game 9986, Win 3551, Lose 3200 ]
Even..
Even..
Winner: [ Yuri: Game 9989, Win 3552, Lose 3200 ]
Even..
Winner: [ Yuri: Game 9991, Win 3553, Lose 3200 ]
Winner: [ Taro: Game 9992, Win 3200, Lose 3554 ]
Winner: [ Taro: Game 9993, Win 3201, Lose 3554 ]
Even..
Winner: [ Yuri: Game 9995, Win 3554, Lose 3202 ]
Winner: [ Taro: Game 9996, Win 3202, Lose 3555 ]
Winner: [ Yuri: Game 9997, Win 3555, Lose 3203 ]
Winner: [ Taro: Game 9998, Win 3203, Lose 3556 ]
Even..
==== Total Result ====
[ Taro: Game 10000, Win 3204, Lose 3556 ]
[ Yuri: Game 10000, Win 3556, Lose 3204 ]

==== Total Result ====
[ Jiro: Game 10000, Win 3322, Lose 3290 ]
[ Yuri: Game 10000, Win 3290, Lose 3322 ]
*/