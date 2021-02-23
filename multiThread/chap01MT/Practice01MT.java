/**
 * @title multiThread / chap01MT / Practice01MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content SingleTreadedExecution / 練習問題
 * @author shika
 * @date 2021-02-23
 */
/* Appendix
 * @costTime 09:50 - 10:06 ( 16 分)
 * @correctRate 正答率 92.31 ％ ( 〇12問 / 全13問 )
 */
package multiThread.chap01MT;

import javaGold.PracticeEditor;

public class Practice01MT {
    public static void main(String[] args) {
        new PracticeEditor();
    }//main()
}//class
/*
//====== 2021-02-23 ======
 SingleTreadedExecution / 練習問題 1-1
Ｘ （1） if()の条件文だと思うが、この問は解らない。
    => エラーを起こしやすくするには
    critical sectionを長くすることで起こしやすくできる。
    Thread.sleep()など

    Thread.yield()でスレッド切り替えを促す方法もある。

 問題 1-2
〇 （1） privateは 他クラスからのフィールド代入を防ぐため、publicにすると synchronizedした意味がなくなる可能性がある。
    => privateはプログラマが 安全性を確認する範囲を定めており、
        privateなら、そのクラスだけチェックすればよく、
        protected だと、継承関係やパッケージ
        publicは、そのクラスにアクセスする全てのクラスをチェックする必要がある。

 問題 1-3
〇 （1） toString()にも synchronizedがあるのは、
〇 （2） このメソッドでフィールドを参照して文字列を出力しているので、
〇 （3） pass()時点のスレッドとずれる可能性があるので、pass(),toSting()両方を synchronized

 問題 1-4
〇 （1） サブクラスを作れない。〇
〇 （2） privateだけど、コンストラクタなら代入可 Ｘ
〇 （3） synchronized move()は1度に1つのスレッド。〇
〇 （4） 途中までしか読まれてないので、
    以下にフィールドの代入・参照があれば安全とは言い切れない。
〇 （5） デッドロックは他クラスとの依存関係を見ないと判断できない。Ｘ

 問題 1-5
〇 （1） SharedResourceなので、synchronizedがないと ThreadSafeではない。

 問題 1-6
〇 （1） 別紙

 問題 1-7
〇 （1） 別紙

開始時刻 09:50
終了時刻 10:06
所要時間 16 分
正答率 92.31 ％ ( 〇12問 / 全13問 )
*/

