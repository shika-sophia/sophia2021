/**
 * @title javaGold / se11Violet / sampleCode / chap08vtMultiThread / forkJoinTask / MainForkJoinExe.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第８章 MultiThread
 * @content ForkJoinPool / p368 / List 8-22
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content ForkJoinPool / p298
 *          戻り値を返さない RecursiveActionによる ForkJoinTaskの定義
 * @class MainForkJoinExe //◆main() new ForkJoinPool(), execute()
 * @class MyAction extends RecusiveAction //compute()
 *
 * @author shika
 * @date 2021-05-11
 */
package javaGold.se11Violet.sampleCode.chap08vtMultiThread.forkJoinTask;

import java.util.concurrent.ForkJoinPool;

public class MainForkJoinExe {

    public static void main(String[] args) {
        ForkJoinPool executor = new ForkJoinPool(4);
        executor.execute(new MyAction());

        System.out.println("Main: OK");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main: done");
    }//main()

}//class

/*
Main: OK
MyAction: OK
Main: done

ForkJoinPool.execute()によって、
RecursiveAction.compute()も呼び出されている。
*/