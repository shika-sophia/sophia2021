/**
 * @title javaGold / se11Violet / Practice01vtJavaPrimary.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本
 * @author shika
 * @date 2021-03-23
 */
/* Appendix 2021-03-23
 * @costTime 10:59 - 11:22 ( 23 分)
 * @correctRate 正答率 66.67 ％ ( 〇10問 / 全15問 )
 */

/* Appendix 2021-05-18
 * @costTime 16:12 - 16:35 ( 22 分)
 * @correctRate 正答率 73.33 ％ ( 〇11問 / 全15問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice01vtJavaPrimary {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class

/*
//====== 2021-03-23 ======
 練習問題
〇 （1） A, D, E
〇 （2） A 0
Ｘ （3） C other -> 〇 D
    => switch()に enumは可能
        case句には 列挙定数を指定する必要がある。(indexは不可)
        -> コンパイルエラー
〇 （4） C
    => 列挙型内の abstractは必ず各列挙定数でOverrideしないとコンパイルエラー
〇 （5） D
Ｘ （6） B, D -> 〇 B, E
    => ◆Object.equals()
        null,型違い -> false
        「==」(同一性)で trueのみ true
〇 （7） E
〇 （8） A, B, D, E
Ｘ （9） C -> 〇 E
    => interface内 staticの抽象メソッドは不可
Ｘ （10） A -> 〇 E
    => defaultの@Overrideは可だが、
    ダイアモンド継承でどちらを呼び出すか明示していないときはコンパイルエラー

Ｘ （11） B -> 〇 C
    非staticのインナークラスは staticメソッドを持てない
〇 （12） E
    private Innerクラスが newされてなくてコンパイルエラーになる問題は無視している。

〇 （13） E
〇 （14） E
〇 （15） A, B, E
    => 継承時 superの Exceptionのみ throw可。
    => RuntimeExceptionなら いつでも throw可。

開始時刻 10:59
終了時刻 11:22
所要時間 23 分
正答率 66.67 ％ ( 〇10問 / 全15問 )
*/

/*
//====== 2021-05-18 ======
 JavaPrimary [２回目]
〇 （1） A, D, E
〇 （2） A
Ｘ （3） Cother -> 〇 D
    => switch()に enumは可能
    *  case句には 列挙定数を指定する必要がある。(indexは不可)
    *  コンパイルエラー

Ｘ （4） B -> C
   => enum内で定義した abstractメソッドは、
   *  各要素が必ず Overrideする必要がある。
   *  一部のみではダメ。コンパイルエラー。

〇 （5） D
〇 （6） B, E
      => boolean Object.equals(Object)
      *  null, 別オブジェクトでも false。例外なし。

〇 （7） E
〇 （8） A, B, D, E
〇 （9） E
      => interface内
      *  staticの抽象は不可。具象は可。
      *  具象は defaultを明示
Ｘ （10） A -> E
       => privateメソッドは どこからも呼び出されておらず、
       *  到達不能コードの問題は放置。
       => 多重実装で default print()はシグニチャが同じ
       *  呼出時に呼出先を特定できずコンパイルエラー。

Ｘ （11） A -> C
       => インスタンスクラスは staticメンバーを持てずコンパイルエラー。
       *  staticメンバーはどこからも参照できないのが理由ぽい。

〇 （12） E
      => private Innerがどこからもインスタンスされておらず、
      *  到達不能コードであることは放置。見なかったことにしよう。

〇 （13） E
〇 （14） E
〇 （15） A, B, E
    => 非staticを staticで Override不可。その逆も不可。
    => superで throwしていない例外を subでは無記、同例外、サブ例外なら可。
    *  RuntimeExceptionなら、superに関係なく throw可。

開始時刻 16:12
終了時刻 16:35
所要時間 22 分
正答率 73.33 ％ ( 〇11問 / 全15問 )
*/

