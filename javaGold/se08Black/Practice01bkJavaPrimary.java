/**
 * @title javaGold / se08Black / Practice01bkJavaPrimary.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第１章 Java Primary
 * @see se11Violet/sampleCode/chap01VT/ MainClassLoader.java
 * @see se11Violet/sampleCode/chap01VT/ SampleImmutable.java
 * @author shika
 * @date 2021-05-02
 */
/* Appendix 2021-05-02
 * @costTime 08:13 - 08:36 ( 22 分)
 * @correctRate 正答率 76.00 ％ ( 〇19問 / 全25問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice01bkJavaPrimary {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-02 ======
 第１章 Java Primary
〇 （1） A
  => 堅牢性 Rebustness:
          ・挙動が安定していて、常に想定通りの動作をする。
          ・どのような利用においても、挙動が崩れない
          ・フィールドを private化し、他クラスから状態を変化する際は setterでチェック

  => 保守性 Maintainability:
          ・デバッグ時の原因特定と修正が容易
          ・要件の変化により変更/修正が必要な場合、最小限の変更で済む
          ・カプセル化により、クラス間の依存関係を小さくしておくことで保守性を高める

〇 （2） C
    => ◆継承 inheritance 引き継ぐもの
            ・フィールド
            ・メソッド
            ・インターフェイス
            ・内部クラス
            ・列挙型
        ×コンストラクタは継承しない

    => 継承 inheritance: 「is-aの関係」「kind-of-a関係」 AはBの一種
    => 集約 aggregation: 「has-aの関係」  AはBを持っている
                フィールドに他クラスのオブジェクトを保持/参照
                クラスのライフサイクルを共にしていない互いに独立した関係
    => 構成集約 composition: 「is-a-part-ofの関係」 Aは Bの一部
                クラスのライフサイクルを共にする。

Ｘ （3） A -> D
    => ◆ポリモーフィズム
    => A: 「実行時に決定する単一の型で、コンパイル時に決定する複数の型を扱う」は説明が逆。
                変数の型はコンパイル時に決まる静的な型。
                インスタンス時に生成されるの様々な型は、実行時に決まる動的な型。
                それをひとつの型として扱える。

Ｘ （4） A -> D
    => @Overrideを付しながら、
    引数が違うオーバーロードになっているため、コンパイルエラー。

〇 （5） B, C
〇 （6） D
〇 （7） A
    => ◆Object.equals()のデフォルト設定は比較演算子「==」と同じ
    => public boolean equals(Object obj){
            return (this == obj);
       }

〇 （8） B
    => ◆hashCode()
            ・不可逆性、一方向性
            ・javaの実装要件は、オブジェクトの検索のため、識別できればよい
            ・equals()で等しいオブジェクトは必ずhash値を返す。
            ・equals()で等しくないと判定されても、必ずしも違うhash値になるとは限らない
            hash値は被ることがある。
            ・equals()判定基準に変更がない場合、
           全ての フィールドが等しければ、hash値は同じ値になる

〇 （9） B, D ◆final
〇 （10） D ◆static
〇 （11） C ◆static{ }
    => ◆ClassLoader <クラス名>.class.getClassLoader());
    => ◆Class<?> Class.forName()
            Class.forName(
                String className,
                boolean initialize,
                ClassLoader
            );
     => 〔@see se11Violet/sampleCode/chap01VT/ MainClassLoader.java〕

〇 （12） D, F
    => ◆Singleton
            ・private コンストラクタ
            ・private staticフィールドに保存
            ・public staticな getInstance()

〇 （13） C
    => ◆Immutable
        java.lang.String
        java.util.regex.Pattern
        java.lang.Integerなどラッパークラス
        java.math.BigDecimal/BigInteger
        java.time.LocalDate系
        java.awt.Color
        java.lang.Enum<T>

〇 （14） B, C
    => interfaceの staticメソッドは、インターフェイス名.メソッド名で呼び出す。
    実装クラス名や、そのインスタンス変数では呼出不可。

Ｘ （15） C -> A
    => 同じシグニチャを持つ defaultの継承はコンパイルエラー
    => クラスCで 当該メソッドを Overrideすれば解決する。

Ｘ （16） D -> A
    => ダイアモンド継承で同じシグニチャのメソッドはコンパイルエラー
    => 型階層の距離が異なる場合は距離の近いほうが呼び出されるため問題ない。

〇 （17） A ◆抽象クラス
〇 （18） E ◆NestedClass
〇 （19） D 他クラスからの InnerClass呼出
〇 （20） D 匿名クラス
〇 （21） C 列挙型
Ｘ （22） C -> B
    => Enumは コンパイル後に、 class A extends Enum<T>
        java.lang.Enumクラスを継承するので、他クラスの継承は不可。
        -> インターフェイスは可。
    => 暗黙的に public static finalを付与。final, abstractを記述不可。

Ｘ （23） B -> A, C
    => 題意「列挙定数名」: 定数のほう。name(), toString()
        E valueOf(String): 列挙型名
        E[] values(): 全列挙定数を要素とする配列

〇 （24） B
〇 （25） A, C
    => Enum<T>インスタンスは Singleton かつ 不変オブジェクトとしての設計を求められる。
    定数であることを考えれば、それも納得できる。
    よって、privateコンストラクタ、private フィールド、getterのみ

開始時刻 08:13
終了時刻 08:36
所要時間 22 分
正答率 76.00 ％ ( 〇19問 / 全25問 )
*/

