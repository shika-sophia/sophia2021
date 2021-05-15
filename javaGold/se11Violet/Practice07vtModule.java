/**
 * @title javaGold / se11Violet / Practice07vtModule.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第７章 Module
 * @author shika
 * @date 2021-04-24
 */
/* Appendix 2021-04-24
 * @costTime 18:56 - 19:17 ( 20 分)
 * @correctRate 正答率 72.73 ％ ( 〇8問 / 全11問 )
 */
/* Appendix 2021-05-15
 * @costTime 18:34 - 18:45 ( 11 分)
 * @correctRate 正答率 81.82 ％ ( 〇9問 / 全11問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice07vtModule {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-24 ======
 第７章 Module
〇 （1） D
〇 （2） A, E
    => module A { requires B } Aは Bに依存している。

〇 （3） B
     => 要件「xyz.test/binに ディレクトリを作成して」 -> -d オプション

Ｘ （4） C -> A
      => java --module-path <モジュールのある場所のパス>
              --module <モジュール名>/<mainクラスの完全修飾名>
              略号: java -p -m

Ｘ （5） D -> A
    => ◆jarファイルの実行
        java
        --module-path  .jarファイルのある場所のパス
        --module モジュール名 / main()を持つクラスの完全修飾名
〇 （6） B, D
Ｘ （7） A, D, E -> A, D, F
    => 無名モジュールがあるのはクラスパス上
        モジュールパス上の全てのモジュールを requiresする。
        全てのパッケージを exportsする。
        名前付きから、無名は参照不可。無名から名前付きは参照可。

〇 （8） B
    => jdeps -s / -summary 要約を出力
    => jdeps -m / --module? ルートモジュールを指定
〇 （9） C
〇 （10） B, E
〇 （11） E
   => インターフェイスと実装クラスが異なるパッケージのため、
           両方のパッケージを exportsする必要がある。

開始時刻 18:56
終了時刻 19:17
所要時間 20 分
正答率 72.73 ％ ( 〇8問 / 全11問 )
*/

/*
//====== 2021-05-15 ======
 Module [２回目]
〇 （1） D
〇 （2） A, E
〇 （3） B
〇 （4） A
Ｘ （5） D?
〇 （6） B, D
Ｘ （7） A, D, E
〇 （8） B
〇 （9） C
〇 （10） B, E
〇 （11） E

開始時刻 18:34
終了時刻 18:45
所要時間 11 分
正答率 81.82 ％ ( 〇9問 / 全11問 )
*/

