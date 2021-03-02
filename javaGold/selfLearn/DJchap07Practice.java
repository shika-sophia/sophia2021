/**
 * @title javaGold / selfLearn / DJchap07Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第７章 オブジェクト指向 基本 Class / 練習問題 7.1
 * @author shika
 * @date 2021-03-02
 */
/* Appendix
 * @costTime 15:38 - 15:47 ( 9 分)
 * @correctRate 正答率 100.00 ％ ( 〇8問 / 全8問 )
 */
/* Appendix 
 * @costTime 07:42 - 07:59 ( 16 分) 
 * @correctRate 正答率 100.00 ％ ( 〇23問 / 全23問 )
 */ 
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap07Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-02 ======
 第７章 オブジェクト指向 基本 Class / 練習問題 7.1
〇 （1） フィールドに varは不可
〇 （2） 重複ローカル変数。引数で定義された dataを 再度 var dataしている。
〇 （3） class宣言に protected不可。public or nothing(= package-private) only
〇 （4） フィールドは class直下で宣言し、class全体が有効範囲。
〇 （5） ローカル変数はメソッドや節ブロックの中で宣言し、宣言場所以降ブロック内のみ有効。

 練習問題 7.2
〇 （1） 別紙

 練習問題 7.3
〇 （1） 別紙

 練習問題 7.4
〇 （1） 別紙

開始時刻 15:38
終了時刻 15:47
所要時間 9 分
正答率 100.00 ％ ( 〇8問 / 全8問 )
*/

/* 
//====== 2021-03-03 ====== 
 ◆章末問題 p331
〇 （1） [1]① アクセス修飾子   
〇 （2） protected   
〇 （3） private   
〇 （4） static   
〇 （5） クラスメンバー   
〇 （6） フィールド   
〇 （7） private static final   
〇 （8） 可変長   
〇 （9） ...   
〇 （10） 配列   
〇 （11） [2]Ｘ -> フィールドは private, メソッドは publicが一般的。他も可。   
〇 （12） Ｘフィールドのシグニチャは名前のみなので、同名は不可。   
〇 （13） Ｘフィールドとローカルの名前重複はありえるし、値も別々だが、可読性の観点から避けるべき。   
〇 （14） Ｘ for内で定義されたブロック変数は forブロック内のみ有効。   
〇 （15） Ｘ javaで推奨しているのはドメイン逆順だが、自由に命名可能。   
〇 （16） [3]① String   
〇 （17） ② age   
〇 （18） ③ this   
〇 （19） ④ "権兵衛", 0   
〇 （20） ⑤ void   
〇 （21） ⑥ printf   
〇 （22） [4]① 100, ② 100   
〇 （23） new ① 100, ② 10   

開始時刻 07:42
終了時刻 07:59
所要時間 16 分
正答率 100.00 ％ ( 〇23問 / 全23問 )
*/ 

