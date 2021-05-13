/**
 * @title javaGold / se11Silver / Practice08svFunctionLambda.java
 * @reference 志賀澄人 『徹底攻略 Java SE11 Silver 問題集[1ZO-815]』 インプレス, 2019
 * @content  第８章 Functon, Lambda
 * @author shika
 * @date 2021-05-13
 */
/* Appendix 2021-05-13
 * @costTime 20:25 - 20:31 ( 6 分)
 * @correctRate 正答率 100.00 ％ ( 〇8問 / 全8問 )
 */
package javaGold.se11Silver;

import javaGold.PracticeEditor;

public class Practice08svFunctionLambda {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-13 ======
 第８章 Functon, Lambda
〇 （1） B, D
     => ◆ GoF ||Strategyパターン||
     *  集約した Algorithmインターフェイスを、各Logicクラスで置き換える。
     *  Logic implements Algorithm のため、他のLogicクラスに置換しても
     *  プログラムコードの修正は不要。

〇 （2） B, C
〇 （3） C
      => ローカル内で宣言された変数と同名の変数をラムダ内の引数で使うと、
 *  本来はラムダ式で変数宣言しているので、重複ローカル変数によりコンパイルエラー。

〇 （4） D
    => ラムダ内で利用するローカル変数は実質finalのみ。
    *  ラムダ式の外で変更をしてもコンパイルエラー。

〇 （5） A
〇 （6） C
〇 （7） B
〇 （8） A

開始時刻 20:25
終了時刻 20:31
所要時間 6 分
正答率 100.00 ％ ( 〇8問 / 全8問 )
*/

