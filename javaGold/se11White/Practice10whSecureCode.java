/**
 * @title javaGold / se11White / Practice10whSecureCode.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  第10章 SecureCode
 * @author shika
 * @date 2021-05-09
 */
/* Appendix 2021-05-09
 * @costTime 16:21 - 16:29 ( 7 分)
 * @correctRate 正答率 14.29 ％ ( 〇1問 / 全7問 )
 */
/* Appendix 2021-05-23
 * @costTime 09:43 - 09:50 ( 7 分)
 * @correctRate 正答率 85.71 ％ ( 〇6問 / 全7問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice10whSecureCode {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-09 ======
 第10章 SecureCode
Ｘ （1） C -> D
     => ◆DoS対策
     * 不明瞭なリソースの制限
     * リソースの解放を徹底する
     * 適切な例外処理の実装
     * A: 圧縮ファイルを解凍する際にデータサイズに制限を設ける
     * B: 信頼性の高い .jarファイルや、デジタル署名のある .jarファイルを利用することで
     * 不慮の挙動を避けることができる。
     * C: プリミティブ整数型: 計算の結果暗黙的にオーバーフローが発生する可能性がある。
     * 		BigDecimalなどの任意精度の整数型はオーバーフローを検知できる。
     * Ｘ D:実行権限の制限は DoS対策としては不適切。
     *
Ｘ （2） B -> C
      => ◆入力値の妥当性チェック
          * 信頼できないソースからの入力については妥当性チェックを行う。
          * アップコールと呼ばれる上位コードの呼出には、戻り値もチェックする。
      => ◆チェックの内容
           * 整数値のオーバーフロー
           * Pathが パストラバーサルになっていなか正規化する
           * C, C++言語で記述された nativeコードは
           * 	privateに指定し、publicなラッパーメソッドを定義し、妥当性チェックを行う。
           *
           * A: java以外のnativeメソッド入力チェックを行うことは可能。
           * B: 全ての入力値に対するチェックを強制されているわけではない。
           * C: 上位コードの戻り値のステータス検証することで、正常な処理を保証できる。
           * D: 入力値がその後の演算で想定する範囲内に収まるか判定する必要がある。

Ｘ （3） B, C -> A, C
       => ◆機密性の確保
           * A: 機密性の高い情報は、必要以上の保存や、参照可能な場所に保存してはいけない。
           * 	不特定多数が検索可能なログファイルなどに記録するのは適切ではない。
           * B: カプセル化を徹底することはオブジェクト指向にとって重要だが、
           * 	アクセス修飾子の制限を行わない限り、機密性の確保とは関係がない。
           * C: 例外情報には機密情報を含むことがある。
           * 		例 FileNotFoundException: ファイルの有無やディレクトリ構造が推測できる。
           * 	例外はアプリケーション例外に変換するなど、機密情報を表に露出しない配慮が必要。
           * D: ファイルの権限チェック回数は、機密性の確保と関係がない。
           *
Ｘ （4） B, C -> C
       => ◆クラスやメソッドの拡張性
           * A: オブジェクト生成時に SecurtyManagerを使った呼出を行う。
           * 	SecurityManagerを使用することで、ポリシーファイルに基づいた挙動のみを許可。
           * 	安全なプログラムの実行が可能。
           * 	SecurityManagerは defaultで無効。
           * 	起動時のシステムプロパティの指定で有効化できる。
           * B: 継承やOverrideを行う必要がない場合は、 final修飾子を指定し
           * 	悪意を持った継承やOverrideができないようにすべき。
           * C: カプセル化はクラス設計としては適切だが、拡張性の制限には関係がない。
           * D: 継承: superの完全な拡張を可能にするが
           * 	Overrideの際に superの仕様を正しく実装しないと super同様の挙動を保証できない。
           * 	集約(Composition): 必要に応じて内包するクラスの呼出を行う。
           * 	内包するクラスを再実装する必要がないので、より安全に拡張を実装することが可能。

〇 （5） C, D
    => ◆シリアライズのガイドライン
        * 信頼性の低いクラスのシリアライズを避ける
        * シリアライズ時に機密情報を保護する。
        * デシリアライズでは、コンストラクタが機能しなため、
        * 	コンスタラクタを用いたオブジェクト構築となるよう設計する
        * シリアライズとデシリアライズにおけるセキュリティ権限を理解する。
        * デシリアライズ時にデータのフィルタリングが行える
        *
        * A: Serializable.readObject()
        *    Externalization.readExternal()
        *    において、デシリアライズ時の挙動を変更できる。
        *    不必要なフィールドの復元をフィルタリングできる。
        * B: 信頼のできないデータのデシリアライズは、
        * 	不適切な任意のオブジェクト生成を誘発する可能性があるため、行うべきではない。
        * 	ObjectOutputStream.resolveClass()を実装し、
        * 	データに含まれるクラスが信頼できるもののみであることを確認すべき。
        * C: デシリアライズ時はコンストラクタと異なる仕組みでオブジェクトが生成される。
        * 	インスタンス時に行われる初期化処理と同等の処理が行われるよう設計する。
        * D: privateなフィールドであっても、
        * 	シリアライズされたバイナリーデータは容易に復元可能なため、
        * 	機密データはシリアライズ前に適切なアルゴリズムで暗号化や署名を行う。
        * 	デシリアライズ時も、同様に復号や署名の検証を行う。

Ｘ （6） B -> A
    ◆入力値を使用したコマンドやパスの結合
    * SQLインジェクション: 不適切なコマンドやパスの結合で SQL文を改竄する攻撃
    * ファイルインクルージョン: 参照するパスを任意のパスに変更する攻撃
    *
    * 〔対策〕
    * 有効な書式を生成する。(テストされたライブラリを利用する)
    * 動的SQL文の利用を避ける。(PreparedStatemantを利用する）
    * 出力データを適切にサニタイズする。
    * 例外的な浮動小数点値が渡されることを防ぐ
    *
    * A: 独自作成したコードに、この問題に対する対応が行われている保証はない。
    * B: 入力値をもとに「+」演算子や concat()を用いたSQL文の動的な結合には
    * 	任意のSQL文を実行できてしまう可能性がある。
    * 	PreparedAtatementの「?」 INパラメタを利用することで、
    * 	SQL文における、列データへのデータ結合のみが許容される。
    * 	安全にSQL文の結合を行うことができる。
    * C: 浮動小数点数や NaN (=None of Number)は
    * 	JDBCに依存するデータ型に変換される可能性がある。
    * 	整合性の保証ができず、例外を発生させる可能性がある。
    * 	想定する範囲内の数値であるかを検証する必要がある。
    * D: 「<」「>」などの記号は Webアプリケーションにおいて、任意のタグを生成する記号。
    * 	悪意あるタグやScriptを実行される可能性がある。
    * 	「&lt;」「&gt;」などへエスケープ処理し無害化することを「サニタイジング」と云ふ
    * 	データの出力や処理内で適切にサニタイズする必要がある。

Ｘ （7） A, C -> A, D
    => ◆セキュアコーディング
        * 提供されている機能を活用して、バグやセキュリティ上の脆弱性がないよう
        * プログラミングすること。
        *
        * A: FileNotFoundException発生時に ファイルの絶対パスをコンストラクタに
        * 	渡しており、例外時に絶対パスが露出する可能性がある。 => 機密情報
        * B, C: アクセシビリティや、拡張性に関する問題はない。
        * D: FileReader.close()を行っているが、
        * 	例外発生時には close()されない。
        * 	try-with-resourcesか、try-catch-finallyで確実に close()すべき。
        * 	=> DoS攻撃に対する脆弱性

開始時刻 16:21
終了時刻 16:29
所要時間 7 分
正答率 14.29 ％ ( 〇1問 / 全7問 )
*/

/*
//====== 2021-05-23 ======
 SecureCode [２回目]
〇 （1） D?
〇 （2） C
〇 （3） A, C
〇 （4） C
Ｘ （5） D -> C, D
    => C: ここの説明は、なんだかおかしいので１つで正解とす。
    *  コンストラクタ利用時と同じように復元することは必要。
    *  ここの解説の前半にも、そう書いてある。

〇 （6） A
〇 （7） A, D

開始時刻 09:43
終了時刻 09:50
所要時間 7 分
正答率 85.71 ％ ( 〇6問 / 全7問 )
*/

