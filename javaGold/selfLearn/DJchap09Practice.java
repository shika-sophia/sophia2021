/**
 * @title javaGold / selfLearn / DJchap09Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第９章 Object, 例外処理, ジェネリクス // 練習問題 9.1, 9.2, 章末問題
 * @author shika
 * @date 2021-03-08
 */
/* Appendix
 * @costTime 08:17 - 08:31 ( 13 分)
 * @correctRate 正答率 92.31 ％ ( 〇12問 / 全13問 )
 */
/* Appendix
 * @costTime 09:08 - 09:25 ( 17 分)
 * @correctRate 正答率 52.94 ％ ( 〇9問 / 全17問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap09Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-08 ======
 第９章 Object / 例外処理 // 練習問題 9.1
Ｘ （1） ① Person
    => Object
    他オブジェクトと比較するメソッドなので、他クラスも入れるように
    Objectクラスをメソッドの引数型に指定すべき。

〇 （2） ② this
〇 （3） ③ instanceof
〇 （4） ④ (Person)
〇 （5） ⑤ equals()
〇 （6） ⑥ false

 練習問題 9.2
〇 （1） Exceptionの継承関係にある 派生クラスから記述する。
〇 （2） catch ( A | B ){ }のように記述も可だが、この場合 継承関係にあるもの同士は不可。
〇 （3） [2]例外をスローする場合、解決可能な「検査例外」をスローする。
    => 解決できないものは、RuntimeExceptionとしてスロー。

〇 （4） 解決不可能な「Error」クラスをスローしても意味がないので「Exception」配下のクラスをスローする。
〇 （5） 「非検査例外」である RuntimeExceptionは プログラム上のバグであることが多いので
〇 （6） try-catchをするより、RuntimeExceptionが出ないようプログラムを見直すべきである。
〇 （7） また、自己定義の extends Exceptionを利用するより、可読性の観点から java既存の「標準例外」を利用すべき。
    => 具体的な例外の内容を識別できるように、「Exception」クラスのスローは避ける。

開始時刻 08:17
終了時刻 08:31
所要時間 13 分
正答率 92.31 ％ ( 〇12問 / 全13問 )
*/
/*
//====== 2021-03-09 ======
 ジェネリクス / 章末問題
〇 （1） Ｘ -> 発生した例外と一致するか、その派生クラスの例外も catchする。
Ｘ （2） Ｘ -> staticもありうるのでは？
    => メンバークラスは、なるべく staticにする。
    非staticは エンクロージングclassの参照を持ち続け、メモリを占有し続けるのと
    エンクロージングclassのガベージコレクションを妨げる可能性があるから。

〇 （3） 〇 -> 匿名クラスは、コンストラクタ不可だが、初期化ブロックは可。
〇 （4） Ｘ -> 列挙型すべてを得るには、Enum.values()を用いる。
〇 （5） Ｘ -> ジェネリクスは継承関係にあっても代入不可。

〇 （6） [2]① <T>
Ｘ （7） ② <? extends T>
    => <? super T>
    super（下限限界）は 出力用途のとき利用する。

Ｘ （8） ③ Object...
    => T...
〇 （9） ④ add()
    ◆「|=」 ビット論理和の代入演算子
    boolean result = false;
    result |= add();
    add()の戻り値は booleanのため、一度でもadd()が trueなら、resultは true。

〇 （10） ⑤ result

//---- clone()のところ要復習 ----
Ｘ （11） [3]① implements Copyable
    => implements Cloneable
〇 （12） ② @Override
Ｘ （13） ③ Object
    => Person
Ｘ （14） ④ new Person()
     =>(Person)super.clone()
Ｘ （15） ⑤ this.memos
    => this.memos.clone()
Ｘ （16） ⑥　？
    => CloneNotSupportException
〇 （17） [4]別紙

開始時刻 09:08
終了時刻 09:25
所要時間 17 分
正答率 52.94 ％ ( 〇9問 / 全17問 )
*/
/*
//====== 章末問題 [4] ======
③ try-catch 〇
try {

} catch (IOException | SQLException e){
    e.printStackTrace();
}

④ inner static class X -> class抜けた
public class Main {

    private static class Sub {

    }//class Sub
}//class Main

⑤任意型の可変長引数を受け取って、新規に ArrayListを生成する静的メソッド　〇
public static <T> ArrayList<T> newArrayList(T... t){
    return new ArrayList<T>(Arrays.asList(t));
}//newArrayList()
 */
