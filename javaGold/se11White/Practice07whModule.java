/**
 * @title javaGold / se11White / Practice07whModule.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  第７章 モジュール
 * @author shika
 * @date 2021-04-23
 */
/* Appendix 2021-04-23
 * @costTime 11:29 - 11:39 ( 9 分)
 * @correctRate 正答率 10.00 ％ ( 〇1問 / 全10問 )
 */
/* Appendix 2021-04-24
 * @costTime 09:49 - 10:06 ( 16 分)
 * @correctRate 正答率 80.00 ％ ( 〇8問 / 全10問 )
 */
/* Appendix 2021-05-15
 * @costTime 16:51 - 17:03 ( 11 分)
 * @correctRate 正答率 80.00 ％ ( 〇8問 / 全10問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice07whModule {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-23 ======
 第７章 モジュール
Ｘ （1） D
〇 （2） D
Ｘ （3） ?
Ｘ （4） C
Ｘ （5） B
Ｘ （6） ?
Ｘ （7） ?
Ｘ （8） C
Ｘ （9） ?
Ｘ （10） ?

開始時刻 11:29
終了時刻 11:39
所要時間 9 分
正答率 10.00 ％ ( 〇1問 / 全10問 )

まだ問題をやるレベルに達していない。
ちゃんと勉強してから再度挑戦すべし。
*/

/*
//====== 2021-04-24 ======
 第７章 Module
〇 （1） B
    => 自動モジュールから、無名モジュールへの参照は常に可。
    => --add-module オプションによって、自動/無名から名前付きモジュールへの参照可。

〇 （2） D
    => --add-module オプションによって、無名から名前付き/自動モジュールへの参照可。

〇 （3） B
    => module.infoを付けても exportsを記述しなければ公開されない。
    => .jarを分割し一方にだけ exportsしても、題意「すべて公開」の要件を満たさない。

Ｘ （4） C -> B
    => --generate-module-info <ディレクトリ名>
            指定したディレクトリ下に module-info.javaを作成。

〇 （5） B
    => -jdkinternals JDKの内部APIの依存関係。
            [java9-] 内部APIはモジュールにより非公開設定。
            依存関係が見つかった場合は、代替方法を出力
    => -verbose クラスレベルの依存関係をすべて出力

〇 （6） C
     => static ServiceLoader<S> ServiceLoader.load(Class<S> service)
         引数: サービスを扱う インターフェイス / 抽象クラス
         実行時の任意のタイミングで、サービス実装クラスをロードできる。

〇 （7） D
    => ◆Class<S>オブジェクトの取得
         Xxxx.class クラスリテラル
         Class.forName()
         Object.getClass()

〇 （8） D
    => モジュール内
        provides <インターフェイス> with <実装クラス>, ...
        provides <抽象クラス> with <サブクラス>, ...

〇 （9） B
    => with部に、同名のクラスを複数回記述不可。コンパイルエラー。
        インターフェイス、抽象クラスが異なっていても不可。

Ｘ （10） B, D
    => ◆ServiceLoaderから値(= 実装クラスオブジェクト)を取得
        ＊Iterator<T> iterator() / while(itr.hasNext() { itr.next() }
        ＊Iterable.forEach()
        ＊ServiceLoader.stream()
            戻り値 Stream<ServiceLoader.Provide<S>>
            Provide.get() 値を取得

開始時刻 09:49
終了時刻 10:06
所要時間 16 分
正答率 80.00 ％ ( 〇8問 / 全10問 )
*/

/*
//====== 2021-05-15 ======
 Module [２回目]
〇 （1） B
Ｘ （2） B -> D
   =>
〇 （3） B
〇 （4） B
〇 （5） B
〇 （6） C
〇 （7） D
〇 （8） D
〇 （9） B
Ｘ （10） C, D? -> A, C
  => ServiceLoader.load(Test.class).forEach(list::add);
  *  Stream<ServiceLoader.Provide<S>> ServiceLoader.stream()
  *  Provider.get()で実装クラスを取得。

開始時刻 16:51
終了時刻 17:03
所要時間 11 分
正答率 80.00 ％ ( 〇8問 / 全10問 )
*/

