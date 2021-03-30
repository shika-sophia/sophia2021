/**
 * @title multiThread / memoryModelJVM / MainVisibility.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-2, B-4
 * @content visibility: スレッドＡが変更した値を、スレッドＢがすぐに見えるとは限らない
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM;

class RunnerThread extends Thread {
    private boolean quit = false;

    public void run() {
        while(!quit) {
            System.out.print(".");
        }//while

        System.out.println("Done");
    }//run()

    public void quitRequest() {
        quit = true;
    }//quitRequest()
}//class RunnerThread

public class MainVisibility {

    public static void main(String[] args) {
        var runner = new RunnerThread();

        //スレッド起動
        runner.start();

        //スレッド停止
        runner.quitRequest();
    }//main()

}//class

/*
Done

【考察】 すぐ終了するかに見えるプログラムだが
quitRequest()で quitフラグを変更したのは mainスレッド。
mainスレッドのキャッシュは quit = true;になっていても、
いつ共有メモリに反映されるか分からないので、
RunnerThreadには、ずっとそれが見えずに終了しないかもしれない危険性がある。

インスタンスの状態変化を表すフラグ変数には volatileを付記し、
必ず全てのスレッドに変更が見えるようにしておく必要がある。
*/