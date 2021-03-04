/**
 * @title multiThread / chap05MT / Practice05MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第５章 Producer-Consumer / 練習問題 5-1, 5-2, 5-3, 5-9
 * @author shika
 * @date 2021-03-04
 */
/* Appendix
 * @costTime 15:01 - 15:24 ( 23 分)
 * @correctRate 正答率 87.50 ％ ( 〇14問 / 全16問 )
 */
package multiThread.chap05MT;

import javaGold.PracticeEditor;

public class Practice05MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-04 ======
 第５章 Producer-Consumer / 練習問題 5-1
〇 （1） super(name)は Threadクラスのコンストラクタを呼び出し。〇
〇 （2） nextId()の synchroniized Ｘ -> 呼ばれているのは MakerThreadからだけだが、static idにアクセスするので、他MakerThreadとの競合を防止している。
〇 （3） Ｘ -> CakeTableに一つもないときは、take()を wait()される。
〇 （4） CakeTableにひとつもないとき、count == 0 〇
Ｘ （5） テーブルがいっぱいのとき、count == buffer.length - 1 〇
    => count == buffer.lengthが正しい。-1するのは indexのとき。

〇 （6） headは buffre.length以上にならない。〇

 練習問題 5-2
〇 （1） CakeTableインスタンスを別々に作ったので、片方は作り続け、いっぱいになり、片方はテーブルに何もなく、ともに待つ続けるデッドロック。

 練習問題 5-3
〇 （1） synchronizedにするのは、MakerThread, EaterThreadともに３つずつあるから。
〇 （2） wait(), notifyAll()するには、そのインスタンスのロックを取ってないといけない。

 練習問題 5-4
〇 （1） 別紙

 練習問題 5-5
〇 （1） 別紙

 練習問題 5-6
〇 （1） 別紙

 練習問題 5-7
〇 （1） 別紙

 練習問題 5-8
Ｘ （1） 解らない

 練習問題 5-9
〇 （1） method(long x)は 引数xの分だけ wait(x)するメソッド。
〇 （2） 時間経過前に、interrupt()は可能。
    => Thread.sleep(x);と同じメソッド。

開始時刻 15:01
終了時刻 15:24
所要時間 23 分
正答率 87.50 ％ ( 〇14問 / 全16問 )
*/

