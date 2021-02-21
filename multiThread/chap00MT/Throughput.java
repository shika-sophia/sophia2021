/**
 * @title multiThread / Intro2.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content Introduction2 マルチスレッドの評価基準 / 練習問題I2
 * @content スレッドを２本にするとスループットは２倍になるかを検証するプログラム
 * @author shika
 * @date 2021-02-21
 */
package multiThread.chap00MT;

import java.util.Random;

public class Throughput extends Thread {
    private static final int BOUND = 10000;

    public void run() {
        @SuppressWarnings("unused")
        int sum = new Random().ints(0, 100).limit(BOUND)
            //.parallel()
            .map(i -> i + 1)
            .sum();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        Thread th1 = new Throughput();
        //Thread th2 = new Throughput();
        th1.start();
        //th2.start();

        long end = System.nanoTime();
        long costTime = end - start;
        double taskPerNano = (double)BOUND / costTime;
        //double taskPerNano = (double)BOUND * 2 / costTime;
        System.out.println("costTime: " + costTime);
        System.out.printf("taskPerNano: %.5f \n",taskPerNano);
    }//main()

}//class

/*
//###### chap00MT.Throughput / 2021-02-21 ######
//====== Test th1 only at singleStream ======
costTime: 534400
taskPerNano: 0.01871

//====== Test th1 & th2 at singleStream ======
costTime: 1135400
taskPerNano: 0.01761

//====== Test parallelStream at singleThread ======
costTime: 520700
taskPerNano: 0.01920

【考察】
マルチスレッドは処理量が２倍なので BOUND * 2
throughput: 単位時間当りの処理量は taskPerNano = 処理数 / 処理時間 で求める。

結果は上記の通りで、スループット２倍と言うには、
マルチスレッド の taskPerNano が シングルスレッドの２倍ないといけない。
むしろシングルスレッドより下がっている。

また同様の処理を parallelStremで行ったが
こちらもsingleStream(sequential:直列)と大差ない結果。

スレッドを立ち上げる際に、Threadクラスのインスタンスをする必要があり、
マルチになればその分のオーバーヘッド(= 処理負担)が掛かるのと、
Thread切り替えたりする時間が掛かるのではなかろうか。

【解答】解説 p468
一般的に２倍にはならない。
〔理由１〕
＊ハードウェアの制約により、
    真に同時に動作する(= 並列に処理をする)とは限らない。
＊その場合、スレッドの切り替えのオーバーヘッドが掛かるから

〔理由２〕
処理する仕事を全てのスレッドに均一に分担させるとは限らない。

〔理由３〕
たとえ２倍のスレッドが並列に動作したとしても、
スレッド間の排他制御を行うオーバーヘッドがあるから。
 */
