/**
 * @title javaGold / selfLearn / DJchap08Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第８章 カプセル化,継承,ポリモーフィズム
 * @author shika
 * @date 2021-03-05
 */
/* Appendix
 * @costTime 13:35 - 13:48 ( 12 分)
 * @correctRate 正答率 81.82 ％ ( 〇9問 / 全11問 )
 */
/* Appendix
 * @costTime 14:09 - 14:35 ( 26 分)
 * @correctRate 正答率 83.33 ％ ( 〇20問 / 全24問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap08Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-05 ======
 第８章 カプセル化,継承,ポリモーフィズム / 練習問題 8.1
〇 （1） アクセス修飾子: クラス、フィールド、メソッドを どの範囲まで公開するかを定義する。
〇 （2） 「ユーザーに必要のないものは見せない」が原則。
〇 （3） クラスやメンバー同士の依存関係をなるべく断ち切ると、変更やデバックの際に理解しやすいコードになる。
Ｘ （4） アクセサーメソッド: 直接フィールドにはアクセスさせず、ふさわしくない値は setterで防いで入れないようにすることができる。
    =>【アクセサーメソッド】解答
        ・読み書きの制御が可能になる。
        ・フィールド値を設定する際に検証できる。
        ・フィールド値を参照する際に値を加工できる。

 練習問題 8.2
〇 （1） final修飾子
〇 （2） 継承先で本来意図していないクラスやメソッドに改変されてしまうことを防ぐため。
    =>【final class / method】解答
        ・継承可能なクラスは実装・修正に際して、
            派生クラスへの影響を考慮しなければならない。
        ・派生クラスの側からも、
            どのクラス・メソッドなら安全に継承できるかを選別する必要がある。
        ・finalが付いてることで、これらを考慮せず、
            基底・派生クラスの実装に考えるべきことを少なくすることができる。

Ｘ （3） [2]
〇 （4） Man m = new BusinessMan(); 〇
〇 （5） BusinessMan bm = (BusinessMan) m; 〇
〇 （6） StudentMan sm = (StudentMan) m;　△ ClassCastException
〇 （7） StudentMan sm2 = (StudentMan) bm; × conpile error

開始時刻 13:35
終了時刻 13:48
所要時間 12 分
正答率 81.82 ％ ( 〇9問 / 全11問 )
*/

/*
//====== 2021-03-05 ======
 章末問題
〇 （1） [1] Ｘ -> super
〇 （2） Ｘ -> @Overrideは必須ではない
〇 （3） Ｘ -> 抽象クラスは、どれか１つ abstractメソッドを持っていれば、他は実装を記述可。
〇 （4） 〇 instanceof は、左 -> 右に変換できると true
〇 （5） Ｘ -> Class extends ParentClass implements Interfaceは可能。
〇 （6） [2]① interface
Ｘ （7） ② public
    => interface内に実装を持つなら defaultを付ける。
    publicは暗黙的に付記される。

〇 （8） ③ extends
〇 （9） ④ implements
〇 （10） ⑤ IFather.super.run();
〇 （11） ⑥ IMother.super.run();
〇 （12） [3] フィールドを public -> privateにする。
〇 （13） 他コンストラクタの呼び出しは super() -> this()
     => コンストラクタの戻り値 voidが記述されているので削除。

Ｘ （14） setAge()に追加。 if(age < 0) { age = 0; }
    => setterの戻り値は void

〇 （15） String.format()内  $s,$d -> %s, %d
〇 （16） コンストラクタ内、フィールドへの代入は this.name = name; (同名変数の場合)
〇 （17） [4]① format
Ｘ （18） ② %.3f  => 結果から 123.46 -> 〇%.2f
〇 （19） ③　extends
〇 （20） ④ @Override
〇 （21） ⑤ super.show()
Ｘ （22） [5] interfaceのメソッドは public、無指定は不可。
  => interface内に実装を記述するなら default。 無指定でも public暗黙付記される。
〇 （23） extends -> implements
〇 （24） @Override をメソッド宣言の上に。修飾子の位置に書いてはいけない。

開始時刻 14:09
終了時刻 14:35
所要時間 26 分
正答率 83.33 ％ ( 〇20問 / 全24問 )
*/

