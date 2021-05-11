/**
 * @title javaGold / se11Violet / sampleCode / chap08vtMultiThread / recursive / MainForkJoinPool.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第８章 MultiThread
 * @content ForkJoinPool / p368 / List 8-22
 * @author shika
 * @date 2021-05-11
 */
package javaGold.se11Violet.sampleCode.chap08vtMultiThread;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class MainForkJoinPool {

    public static void main(String[] args) {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("core: " + core);

        ForkJoinPool common = ForkJoinPool.commonPool();
        int parallelism = common.getParallelism();
        System.out.println("parallelism: " + parallelism);

        ForkJoinPool executor = new ForkJoinPool(4);
        int paraLimit = executor.getParallelism();
        System.out.println("paraLimit: " + paraLimit);

        IntStream.range(0, 100).parallel()
            .forEach(i -> System.out.printf("%s: %d \n",
                    Thread.currentThread().getName(), i));
    }//main()

}//class

/*
【考察】
これだと実行結果出ず。
    ForkJoinTask<?> task = ForkJoinTask.adapt(new Runnable() {
        public void run() {
            IntStream.range(0, 100).parallel()
                 .forEach(～);
        }
    });
    executor.execute(task);

parallel()を実行する主体が ForkJoinPoolだからか？
parallel()を削除して、sequential(=直列)で実行してみたが、やはり同じ。
IntStreamからを素のままにして実行するだけで、
ForkJoinPoolを呼び出していることが判る。

実行環境のプロセッサコア数と、commonPoolの並行数を調べてみた。
コンストラクタで ForkJoinPoolを生成すると、並行プール数を指定できる。

【実行結果】
core: 12
parallelism: 11
paraLimit: 4

main: 65
ForkJoinPool.commonPool-worker-7: 4
ForkJoinPool.commonPool-worker-7: 5
ForkJoinPool.commonPool-worker-5: 90
ForkJoinPool.commonPool-worker-31: 1
ForkJoinPool.commonPool-worker-31: 2
ForkJoinPool.commonPool-worker-31: 0
ForkJoinPool.commonPool-worker-31: 88
ForkJoinPool.commonPool-worker-31: 89
ForkJoinPool.commonPool-worker-19: 32
ForkJoinPool.commonPool-worker-19: 33
ForkJoinPool.commonPool-worker-19: 31
ForkJoinPool.commonPool-worker-17: 21
ForkJoinPool.commonPool-worker-17: 22
ForkJoinPool.commonPool-worker-9: 15
ForkJoinPool.commonPool-worker-9: 16
ForkJoinPool.commonPool-worker-9: 17
ForkJoinPool.commonPool-worker-9: 13
ForkJoinPool.commonPool-worker-9: 14
ForkJoinPool.commonPool-worker-9: 12
ForkJoinPool.commonPool-worker-3: 3
ForkJoinPool.commonPool-worker-23: 57
ForkJoinPool.commonPool-worker-23: 58
ForkJoinPool.commonPool-worker-23: 56
ForkJoinPool.commonPool-worker-21: 7
ForkJoinPool.commonPool-worker-21: 8
ForkJoinPool.commonPool-worker-21: 6
ForkJoinPool.commonPool-worker-13: 44
ForkJoinPool.commonPool-worker-13: 45
ForkJoinPool.commonPool-worker-13: 43
ForkJoinPool.commonPool-worker-27: 82
ForkJoinPool.commonPool-worker-27: 83
ForkJoinPool.commonPool-worker-27: 81
ForkJoinPool.commonPool-worker-13: 48
ForkJoinPool.commonPool-worker-13: 49
ForkJoinPool.commonPool-worker-21: 26
ForkJoinPool.commonPool-worker-21: 27
ForkJoinPool.commonPool-worker-21: 25
ForkJoinPool.commonPool-worker-21: 29
ForkJoinPool.commonPool-worker-21: 30
ForkJoinPool.commonPool-worker-21: 34
ForkJoinPool.commonPool-worker-21: 53
ForkJoinPool.commonPool-worker-21: 54
ForkJoinPool.commonPool-worker-21: 55
ForkJoinPool.commonPool-worker-21: 51
ForkJoinPool.commonPool-worker-21: 52
ForkJoinPool.commonPool-worker-23: 60
ForkJoinPool.commonPool-worker-23: 61
ForkJoinPool.commonPool-worker-23: 59
ForkJoinPool.commonPool-worker-3: 10
ForkJoinPool.commonPool-worker-3: 11
ForkJoinPool.commonPool-worker-9: 28
ForkJoinPool.commonPool-worker-17: 23
ForkJoinPool.commonPool-worker-17: 24
ForkJoinPool.commonPool-worker-17: 19
ForkJoinPool.commonPool-worker-17: 20
ForkJoinPool.commonPool-worker-17: 18
ForkJoinPool.commonPool-worker-17: 93
ForkJoinPool.commonPool-worker-17: 69
ForkJoinPool.commonPool-worker-17: 70
ForkJoinPool.commonPool-worker-17: 68
ForkJoinPool.commonPool-worker-17: 73
ForkJoinPool.commonPool-worker-17: 74
ForkJoinPool.commonPool-worker-17: 98
ForkJoinPool.commonPool-worker-17: 99
ForkJoinPool.commonPool-worker-17: 40
ForkJoinPool.commonPool-worker-19: 35
ForkJoinPool.commonPool-worker-19: 36
ForkJoinPool.commonPool-worker-31: 87
ForkJoinPool.commonPool-worker-5: 91
ForkJoinPool.commonPool-worker-5: 92
ForkJoinPool.commonPool-worker-7: 96
ForkJoinPool.commonPool-worker-7: 97
main: 66
main: 67
ForkJoinPool.commonPool-worker-7: 78
ForkJoinPool.commonPool-worker-7: 79
ForkJoinPool.commonPool-worker-7: 80
ForkJoinPool.commonPool-worker-7: 76
ForkJoinPool.commonPool-worker-7: 77
ForkJoinPool.commonPool-worker-7: 75
ForkJoinPool.commonPool-worker-5: 62
ForkJoinPool.commonPool-worker-31: 38
ForkJoinPool.commonPool-worker-19: 63
ForkJoinPool.commonPool-worker-19: 64
ForkJoinPool.commonPool-worker-17: 41
ForkJoinPool.commonPool-worker-9: 94
ForkJoinPool.commonPool-worker-9: 95
ForkJoinPool.commonPool-worker-3: 9
ForkJoinPool.commonPool-worker-23: 71
ForkJoinPool.commonPool-worker-23: 72
ForkJoinPool.commonPool-worker-21: 50
ForkJoinPool.commonPool-worker-13: 46
ForkJoinPool.commonPool-worker-13: 47
ForkJoinPool.commonPool-worker-27: 85
ForkJoinPool.commonPool-worker-27: 86
ForkJoinPool.commonPool-worker-17: 42
ForkJoinPool.commonPool-worker-31: 39
ForkJoinPool.commonPool-worker-5: 37
ForkJoinPool.commonPool-worker-7: 84

*/
