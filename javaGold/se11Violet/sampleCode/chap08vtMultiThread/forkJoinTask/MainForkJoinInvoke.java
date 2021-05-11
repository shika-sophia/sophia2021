/**
 * @title javaGold / se11Violet / sampleCode / chap08vtMultiThread / forkJoinTask / MainForkJoinInvoke.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第８章 MultiThread
 * @content ForkJoinPool / p368 / List 8-22
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content ForkJoinPool / p300
 *          戻り値を返す RecursiveTask<V>による ForkJoinTaskの定義
 * @class MainForkJoinInvoke //◆main() new ForkJoinPool(), invoke()
 * @class MyTask extends RecusiveTask<Integer> //compute()
 *
 * @author shika
 * @date 2021-05-11
 */
package javaGold.se11Violet.sampleCode.chap08vtMultiThread.forkJoinTask;

import java.util.concurrent.ForkJoinPool;

public class MainForkJoinInvoke {

    public static void main(String[] args)
            throws InterruptedException {
        var exe = new ForkJoinPool(4);
        Integer result = exe.invoke(new MyTask());
        System.out.println("Main: OK");

        Thread.sleep(3000);
        System.out.println("Main: done / result = " + result);
    }//main()

}//class

/*
MyTask: Begin
MyTask: OK
Main: OK
Main: done / result = 1
*/