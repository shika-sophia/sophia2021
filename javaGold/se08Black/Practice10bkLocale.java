/**
 * @title javaGold / se08Black / Practice10bkLocale.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第10章 Locale
 * @author shika
 * @date 2021-05-13
 */
/* Appendix 2021-05-13
 * @costTime 11:19 - 11:29 ( 9 分)
 * @correctRate 正答率 78.57 ％ ( 〇11問 / 全14問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice10bkLocale {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-13 ======
 第10章 Locale
〇 （1） C
Ｘ （2） A, C, E
       => ◆Locale コンストラクタ
       *  Locale(String lanruage)
       *  Locale(String language, String country)
       *  Locale(String language, String country, String variant)
       *    language: 言語コード
       *    country: 国コード
       *    variant: OS依存のファイルシステムコード "BASIC","DOS","POSIX"

〇 （3） D
       => Locale Locale.getDefault()
       *  JVM起動時にホスト環境に応じた環境変数
       *  user.country, user.language, user.variantを設定。
       *  getDefault()は これらの値に基づく Localeを生成。

〇 （4） C
      => Locale.Builder staticメンバークラス
      *  Builderクラスのセッターメソッドは妥当性チェックを行うため
      *  引数が言語コード・国コードの定数による整形式でなければ、
      *  java.util.IlformedLocaleException
      *
      *  new Locale("123");などもコンパイルを通ってしまう。

〇 （5） A
Ｘ （6） D, E -> A, D
   => ◆Propertiesクラス
   *  標準対応: xmlファイル, テキストファイル

〇 （7） D
Ｘ （8） B, D -> C, D
    => ◆Properties extends Hashtable<Object,Object>
    *       Hashtable implements Map<K,V>
    *  Map.forEach(BiConsumer(K,V))
    *
    *  Properties.list(PrintStream/PrintWriter)
    *      Properties.list(System.out);

〇 （9） B
〇 （10） D
    => ResourceBundle.Control
    *      getTimeToLive(String baseName, Locale)
    *        default: TTL_EXPIRATION_CONTROL 無制限にキャッシュ
    *        @Override: TTL_DONT_CACHE キャッシュしない

〇 （11） D
〇 （12） E
〇 （13） B
〇 （14） A

開始時刻 11:19
終了時刻 11:29
所要時間 9 分
正答率 78.57 ％ ( 〇11問 / 全14問 )
*/

