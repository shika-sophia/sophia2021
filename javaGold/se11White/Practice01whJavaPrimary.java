/**
 * @title javaGold / se11White / Practice01whJavaPrimary.java
 * @reference 日本サードパーティ  『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本
 * @author shika
 * @date 2021-03-16
 */
/* Appendix 2021-03-16
 * @content [1]-[9]
 * @costTime 16:03 - 16:23 ( 19 分)
 * @correctRate 正答率 77.78 ％ ( 〇7問 / 全9問 )
 */
/* Appendix 2021-03-18
 * @content [10]-[20]
 * @costTime 09:04 - 09:24 ( 19 分)
 * @correctRate 正答率 90.91 ％ ( 〇10問 / 全11問 )
 */
/* Appendix 2021-03-18
 * @content [21]-[36]
 * @costTime 10:17 - 10:45 ( 27 分)
 * @correctRate 正答率 50.00 ％ ( 〇8問 / 全16問 )
 */
/* Appendix 2021-05-04
 * @costTime 10:07 - 11:15 ( 68 分)
 * @correctRate 正答率 80.56 ％ ( 〇29問 / 全36問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice01whJavaPrimary {

    public static void main(String[] args) {
        new PracticeEditor();
        //Exam ex = new Gold();
        //Bronze br = (Bronze) ex;
    }//main()

}//class

//interface Exam { }
//class Bronze { }
//class Gold  extends Bronze implements Exam { }

/*
interface Foo {
    public default void func() {
        System.out.println("Foo");
    }
}
interface Bar extends Foo {
    public static void func() { //この static メソッドは Foo からのインスタンス・メソッドを隠蔽できません
        System.out.println("Bar");
    }
}

class Baz implements Bar {}
class Test {
    public static void main(String[] args) {
        Baz baz = new Baz();
        baz.func();
    }
}
*/
/*
//====== 2021-03-16 ======
 第１章 Javaの基本
〇 （1） C, E
〇 （2） C 16行目 empNoは private
〇 （3） C, D
〇 （4） A, C
Ｘ （5） A -> C
    => static と フィールドは オーバライドに関係なく、
    変数型のメソッドが呼び出される

〇 （6） B
Ｘ （7） E => D
    -> Exam と Bronzeに継承関係はないので
    Bronze b2 = (Bronze) e; は Exam e = new Gold();でも
    コンパイルエラーが出ると思うのだが・・
    => 検証の結果(上記)コンパイル通ります。
    ex内の GoldがBronzeの superなので継承関係と見なされる。
    キャストの際、exの変数型ではなく、オブジェクト型の Goldに注目してコンパイルしている。

    上記が通るとして、staticメソッドは 変数型のメソッドが呼び出される。
    非staticは 変数型ではなくオブジェクト型の @Overrideしたメソッドが呼び出される。

〇 （8） E
〇 （9） A
    => println()の引数にオブジェクトを指定すると、
    そのオブジェクトの toString()を呼び出す。
    そのオブジェクトが toString()を @Overrideしていないときは
    extends Objectの Object.toString()を呼び出す。

開始時刻 16:03
終了時刻 16:23
所要時間 19 分
正答率 77.78 ％ ( 〇7問 / 全9問 )
*/
/*
//====== 2021-03-18 ======
 1-10から続き
Ｘ （1） [1-10] D
  => F
  => StringBuffer.equals()は 参照先を比較する同一性の判定である Object.equals()。
  => String.equals()は 同値性判定をするように @Overrideされている。

〇 （2） [11] C
〇 （3） [12] A, C
〇 （4） [13] C
〇 （5） [14] A, D
〇 （6） [15] B
〇 （7） [16] A, C
〇 （8） [17] B
〇 （9） [18] D
〇 （10） [19] A
〇 （11） [20] C, E

開始時刻 09:04
終了時刻 09:24
所要時間 19 分
正答率 90.91 ％ ( 〇10問 / 全11問 )
*/

/*
//====== 2021-03-18 ======
 1-21から
Ｘ （1） [21] A -> D
    => Innerクラスは staticだが
    new Outer.Inner().increment();
    Innerの（）が必要。

Ｘ （2） [22] B 2 -> C
    => new Inner() { }は { }部分が匿名クラス
    Innerクラスを継承した匿名のサブクラス。
    => Outer$1.classという暫定的な名前のクラスファイルが生成される。

Ｘ （3） [23] B, D -> A, D
    => ローカルクラスは、変数?と同じ扱いになるので abstract, final可。

〇 （4） [24] A
    => Innerクラスの修飾子はメンバー変数(フィールド)メンバーメソッドと同じ扱い
    public,(無記入),protected, private

〇 （5） [25] C
〇 （6） [26] B
    => Enum.toString()は要素名が出力
    => コンストラクタでフィールドに入れた値を取り出すなら
    @Override
    public String toString(){
        return field;
    }

Ｘ （7） [27] B -> D
    Bronze(2, 1, 0)に対応するコンストラクタが未定義のためコンパイルエラー

〇 （8） [28] D
〇 （9） [29] D
Ｘ （10） [30] B, C, D -> C, D, E
    => A: void fly() -> interfaceは暗黙的に public abstractのため無記入はNG
    => B: abstractクラスに public void fly();
    抽象メソッドにするなら ここはクラスなので abstractの明示が必要。

〇 （11） [31] B, C
Ｘ （12） [32] C -> B
    => ダイアモンド継承であるが
    static fanc()は Fooインターフェイスに属すメソッド
    Bazに継承されるのは Bar.(default fanc())のため、Barと表示が正解。

Ｘ （13） [33] A -> C
    => オーバーライドのメソッドに staticを付けるとコンパイルエラー
    => シグニチャが同じだと Overrideと見なされる。
    *  非staticを staticで Overrdeするとコンパイルエラー。
    *  その逆も不可

〇 （14） [34] D
Ｘ （15） [35] B  -> A
    Sample.fanc1()から呼び出した fanc2()は同じクラス内の fanc2()が呼び出される。
〇 （16） [36] C

開始時刻 10:17
終了時刻 10:45
所要時間 27 分
正答率 50.00 ％ ( 〇8問 / 全16問 )
*/

/*
//====== 2021-05-04 ======
 JavaPrimary[２回目]
〇 （1） C, E
〇 （2） C
〇 （3） C, D
〇 （4） A, C
〇 （5） C
〇 （6） B
Ｘ （7） F -> D 同じ間違い ClassCastExceptionならランタイム
   => Exam と Bronzeに継承関係はないので
  Bronze b2 = (Bronze) ex; は Exam ex = new Gold();でも
    コンパイルエラーが出ると思うのだが・・

    => 検証の結果(上記)コンパイル/実行とも通ります。
     ex内の GoldがBronzeの superなので継承関係と見なされる。
        キャストの際、exの変数型ではなく、オブジェクト型の Goldに注目してコンパイルしている。

〇 （8） E
〇 （9） A
Ｘ （10） D -> F
    => StringBuffer.equals(): 参照同一性の比較。「==」と同じ

〇 （11） C
〇 （12） A, C
〇 （13） C
Ｘ （14） A, C -> A, D
    => ◆abstract class
        public abstract void foo();
        public void foo(){ } 具象クラスのみ可。
        抽象クラスは abstractを自動追加しない。

〇 （15） B
〇 （16） A, C
〇 （17） B
〇 （18） D
〇 （19） A
〇 （20） C, E
Ｘ （21） B -> D
    => static Inner from same class
    new Outer.Inner().foo()

〇 （22） C
Ｘ （23） B, D? -> A, D
    => ◆ローカルクラス = メソッド内のクラス。ローカル変数と同じ扱い。
    -> X public, protected, private不可。static不可。

    final, abstractは可。
〇 （24） A
〇 （25） C
〇 （26） B
〇 （27） D
〇 （28） D
Ｘ （29） A -> D
    => interface内のメソッドは 暗黙的に public abstract
    -> Overrideするとき、publicを付けないとコンパイルエラー。

〇 （30） C, D, E
〇 （31） B, C
    => Flyer型にすると land()を定義していないので呼び出せない。

〇 （32） B
Ｘ （33） A -> C 同じ間違い
    => default fanc() を継承し、static func()を定義
    シグニチャが同じなので Overrideと見なされるとのこと。

〇 （34） D
〇 （35） A
〇 （36） C

開始時刻 10:07
終了時刻 11:15
所要時間 68 分
正答率 80.56 ％ ( 〇29問 / 全36問 )
*/

