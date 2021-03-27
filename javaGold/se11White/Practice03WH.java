/**
 * @title javaGold / se11White / Practice03WH.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第３章 例外処理
 * @author shika
 * @date 2021-03-27
 */
/* Appendix 2021-03-27
 * @costTime 15:33 - 16:05 ( 31 分)
 * @correctRate 正答率 60.00 ％ ( 〇9問 / 全15問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice03WH {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-27 ======
 ) 第３章 例外処理
〇 （1） E
    => RuntimeExceptionは throws句が明記されていなくても呼出元に転送される。
    => thow eで転送される前に finally節が実行される。

Ｘ （2） B -> E
    => 継承関係にある Exceptionを 親側を先に catchするとコンパイルエラー。
    エラー: 例外 FileNotFoundExceptionはすでに捕捉されています。

Ｘ （3） B -> A
    => null.toString()は NullPointerException
    => Throws RuntimeExceptionで NullPoは Runtimeのため、NullPoが呼出元に転送される。

〇 （4） A, B, D
    => OutOfMemoryError extends VirtualMachineError
    => ClassNotFoundExeceptionは IOEexceptionと継承関係にない。
    => FileNotFoundExceotion extends IOException
Ｘ （5） D -> A
    => main() throws Exceptionで main()での処理がされていないが
    fanc()で catchしているから問題ないのか？
    => そのまま ArraysIndexOutOfBoundsException
    e.getClass()は
    「 class java.lang.ArraysIndexOutOfBoundsException」と出力

〇 （6） C
    => e.getMessage()で Exception("文字列")の文字列を出力。

Ｘ （7） A -> C
    => マルチキャッチで捕捉する eはそれぞれの型の superになる
    => 設問では e.func()を呼び出しており、定義されていないメソッドの呼出でコンパイルエラー。


〇 （8） A, D
Ｘ （9） A -> D
    => try-with-resourceの ()に 2文以上ある場合は「;」で区切る
    => close()が呼ばれる順は インスタンス作成順の逆順で呼ばれる

〇 （10） C
    => try-with-resourceの外で宣言した オブジェクトも close()の対象。

〇 （11） D
    => try-with-resourceの()内で宣言した変数は final扱い。
    再代入するとコンパイルエラー。

Ｘ （12） D -> B
    => main() throws Exceptionでいいそうだ
    catchせんでもいいんかな
    => func() throws Exceptionのため、main() catch(サブクラス)はコンパイルエラー
〇 （13） D
〇 （14） A
〇 （15） A

開始時刻 15:33
終了時刻 16:05
所要時間 31 分
正答率 60.00 ％ ( 〇9問 / 全15問 )
*/

