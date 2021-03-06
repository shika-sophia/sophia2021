/**
 * @title multiThread / Intro2.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content Introduction2 マルチスレッドの評価基準 / 練習問題
 * @author shika
 * @date 2021-02-21
 */
/* Appendix
 * @costTime 08:09 - 08:26 ( 16 分)
 * @correctRate 正答率 66.67 ％ ( 〇4問 / 全6問 )
 */
package multiThread.chap00MT;

import javaGold.PracticeEditor;

public class Intro2 {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-02-21 ======
 Introduction2 マルチスレッドの評価基準 / 練習問題
Ｘ （1） メソッドには synchronizedを付けておけばよい。
    -> 排他制御したいときはそれでいいが、スレッドを同時に利用したい設計もあるのでは
    =>【安全性】synchronized で下がることはないが、上がるとも限らない。
        publicなフィールドにしたら、メソッドが synchronizedにしても安全性は保証されない。
    =>【生存性】機械的にsynchronizedをするとデッドロックが起こりやすくなり、生存性は下がる。
    =>【パフォーマンス】synchronizedの呼び出しは一般メソッドより時間が掛かるので
        throughputは下がる。

〇 （2） synchronized内で無限ループになっているのは悪いこと
    -> 無限ループは一般的に避けるべきだが、条件を満たすまで synchronizedで他スレッドを待機させるプログラムもありうる。
    =>【安全性】synchronizedの無限ループで安全性が下がることはない。
    =>【生存性】synchronizedで無限ループしたら、他スレッドは全てブロックされるので
        必要な処理ができず生存性は下がる。
    =>【パフォーマンス】生存性が下がるなら、throuputも下がる。

〇 （3） 無限ループのスレッドを100個
    -> やりすぎ。条件で離脱できないループは意味がないどころか、メモリや処理能力を低下させて有害。設計から見直すべき。
    =>【安全性】無限ループがたくさんあっても安全性は下がらない。
    =>【生存性】ループだけなら下がらないが、
        メモリ消費によって必要なスレッドが起動できなくなるので生存性は下がる。
    =>【パフォーマンス】スレッドを動かしておくメモリ、計算処理をするＣＰＵ時間という
        リソースを消費しパフォーマンスは下がる。
〇 （4） サーバは同時に１クライアントのみ
    -> これは確かに不便だけど、気密性の高い情報などはこういう設計もあるのでは
    =>【パフォーマンス】キャパシティを問題にしているなら必要。

〇 （5） いったん検索したら、全部終わるまでキャンセルできない。
    -> 時間の掛かる処理はマルチスレッドでActionListenerを設け
        キャンセルなど他処理ができるようにしておきたいところ
    =>【パフォーマンス】応答性を問題にしてるケース

Ｘ （6） クラスＡとクラスＢが排他処理を意識している
    -> 互いに影響のあるクラスでデッドロックにならなければいいのでは、デッドロックは気を付けねば
    => 【再利用性】起動するスレッドに関するコードを片方に閉じ込めることで
        クラスの依存関係が無くなり、部品としての再利用性は上がる。

開始時刻 08:09
終了時刻 08:26
所要時間 16 分
正答率 66.67 ％ ( 〇4問 / 全6問 )
*/

