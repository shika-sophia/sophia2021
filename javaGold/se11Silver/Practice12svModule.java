/**
 * @title javaGold / se11Silver / Practice12svModule.java
 * @reference 志賀澄人 『徹底攻略 Java SE11 Silver 問題集[1ZO-815]』 インプレス, 2019
 * @content  第12章 Module
 * @author shika
 * @date 2021-05-15
 */
/* Appendix 2021-05-15
 * @costTime 13:39 - 13:45 ( 5 分)
 * @correctRate 正答率 85.71 ％ ( 〇6問 / 全7問 )
 */
package javaGold.se11Silver;

import javaGold.PracticeEditor;

public class Practice12svModule {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-15 ======
 第12章 Module
〇 （1） A, B
〇 （2） D
〇 （3） D
〇 （4） D
〇 （5） B
〇 （6） A, C
    => 〇java --describe-module モジュールの説明を表示。
    *  〇jmod describe JMODファイル形式のモジュール設定を表示。
    *  Ｘ jdeps --list-deps モジュールの依存関係を表示。
    *  Ｘ java --show-modile-resolution
    *     実行時に依存するモジュールがどのように探されているかを表示
Ｘ （7） D -> A 一時的に exports可能にするオプション
    => --add -exports
    *      <対象モジュール / 公開パッケージ>
    *      = <利用モジュール>

開始時刻 13:39
終了時刻 13:45
所要時間 5 分
正答率 85.71 ％ ( 〇6問 / 全7問 )
*/

