/**
 * @title javaGoF / chap12Decorator / decoBorder / MainLineSide.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第12章 Decorator / 練習問題 12-2
 * @content 複数行テキストを登録できる機能 MultiTextDisplayDecoを追加
 * @see MainDecoBorder / class summary
 * @author shika
 * @date 2021-06-10
 */
package javaGoF.chap12Decorator.decoBorder;

public class MainMultiText {

    public static void main(String[] args) {
        MultiTextDisplayDeco multi = new MultiTextDisplayDeco();
        multi.add("Good Morning.");
        multi.add("Good Afternoon.");
        multi.add("Good Night.");
        multi.show();

        AbsDisplayDeco side = new SideBorderDeco(multi, "#");
        AbsDisplayDeco full = new FullBorderDeco(multi);
        side.show();
        full.show();
    }//main()

}//class

/*
Good Morning.
Good Afternoon.
Good Night.

【修正前】
#Good Morning.#
#Good Afternoon.#
#Good Night.#

+---------------+
|Good Morning.|
|Good Afternoon.|
|Good Night.|
+---------------+

【修正後】
#Good Morning.  #
#Good Afternoon.#
#Good Night.    #
+---------------+
|Good Morning.  |
|Good Afternoon.|
|Good Night.    |
+---------------+

【考察】
MultiTextDisplayDeco.add()は AbsDisplayDecoには未定義なので、
変数の型は MultiTextDisplayDecoとする。
AbsDisplayDecoに abstract add()を追加すると、
TextDisplayDecoにも add()を追加しなければいけなくなる。

修正前は上記のように、文字列の前後に sideDecoの飾り文字が付いていた。
    return sideDeco + display.getText(row) + sideDeco;
としていたことが原因。

MultiTextDisplay.main()の単体テストで
getColumn()の maxLengthの値は取れている。
なので、maxLengthと textLengthの差を取って、
その分の「" "」を挿入する必要がある。

SideBorder, FullBorder共通の処理なので、
AbsBorderに ||TemplateMethod||を作ることにした。
insertBlank()を追加。

    String text = insertBlank(display.getText(row));
    return sideDeco + text + sideDeco;
修正後、ちゃんと枠線が出ました。

【解答】
insertBlank()を MultiTextDisplayのほうに入れていました。
MultiText特有の問題だから、こちらに入れたほうがいい。
display.getText()で取得する Stringに すでに後半の空白が入っている状態にする。
SideBorder, FullBorderを修正する必要がなくなる。

*/