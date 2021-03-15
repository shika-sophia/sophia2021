/**
 * @title javaGold / selfLearn / DJchap11Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第11章 マルチスレッド / アノテーション / モジュール
 * @author shika
 * @date 2021-03-15
 */
/* Appendix
 * @costTime 14:56 - 15:09 ( 13 分)
 * @correctRate 正答率 90.91 ％ ( 〇10問 / 全11問 )
 */
/* Appendix 2021-03-15
 * @costTime 15:22 - 15:40 ( 18 分)
 * @correctRate 正答率 73.68 ％ ( 〇14問 / 全19問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap11Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-15 ======
 第11章 マルチスレッド
〇 （1） synchronaize(obj){ }は、objに対し、複数のスレッドから同時にアクセスできないようにロックを掛ける仕組み
〇 （2） 複数のsynchronizedブロックは、ロックを取った１つのスレッドだけが占有して処理をする。
〇 （3） synchronized{ }ブロックを外れたところで、ロックも必ず解放する。
〇 （4） [2]① Thread.start(10000) -> Thread.sleep(10000)
〇 （5） finally { sche.shutdown(); }
    => schedule()は 1回のみ実行。
    => scheduleAtFixedRate()で繰り返し実行。

 / アノテーション
Ｘ （1） @Deprecate("since=9")
〇 （2） [2]① class
〇 （3） ② getConstructor()
〇 （4） ③ newInstance()
〇 （5） ④ getMethod()
〇 （6） ⑤ invoke()

 / モジュール
Ｘ （1） @Deprecate("since=9")
     => @Deprecated(since="9")

〇 （2） [2]① class
〇 （3） ② getConstructor()
〇 （4） ③ newInstance()
〇 （5） ④ getMethod()
〇 （6） ⑤ invoke()

開始時刻 14:56
終了時刻 15:09
所要時間 13 分
正答率 90.91 ％ ( 〇10問 / 全11問 )
*/

/*
//====== 2021-03-15 ======
 章末問題
〇 （1） [1]① Ｘ -> 毎回、new Thread()の処理をするより、ThreadPoolで保持しておくほうがパフォーマンスは向上する
〇 （2） ② Ｘ ->明示的ロックは、java.util.concurrent.locks.ReentrantLockクラス。
〇 （3） ③ Ｘ -> アノテーション属性は、基本型、文字列、クラス、列挙型、アノテーション
〇 （4） ⑤ Ｘ -> 標準ライブラリは java.baseモジュール
〇 （5） ⑥ Ｘ -> モジュールパス上の無名モジュールは、自動モジュールとして扱われる。
Ｘ （6） [2]① newSingleThread()
    => newSingleThreadExecutor

〇 （7） ② () -> { }
〇 （8） ③ Random
〇 （9） ④ sleep()
〇 （10） ⑤ get()
〇 （11） [3]① implements -> extends Thread
〇 （12） ② 〇
Ｘ （13） ③ newScheduledSingleThreadExecutor
      => newScheduledThreadPool(2)
〇 （14） ④ 〇
〇 （15） ⑤ opens -> open
Ｘ （16） [4]① ConpletedFuture
    => ConpletableFuture
Ｘ （17） ② applyAsync()
    => thenApplyAsync()
〇 （18） ③ data ->
Ｘ （19） ④ acceptAsync()
     => thenAcceptAsync()

開始時刻 15:22
終了時刻 15:40
所要時間 18 分
正答率 73.68 ％ ( 〇14問 / 全19問 )
*/

