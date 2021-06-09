/**
 * @title javaGoF / chap12Decorator / decoBorder / MainDecoBorder.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第12章 Decorator / List 12-1 ～ 12-6
 * @content 飾り枠と中身の同一視
 *
 * @class MainDecoBorder / ◆main()
 * @class AbsDisplayDeco
 *        / abstract getColumn(), getRow, getText()
 *        show() ||TemplateMethod||
 * @class TextDiplayDeco extends AbsDisplayDeco
 *        / getColumn(), getRow(), getText()
 * @class AbsBorderDeco extends AbsDisplayDaco
 *        / AbsDiplayDeco display /
 *        #AbsBorderDeco(AbsDisplayDeco)
 * @class SideBorderDeco extends AbsBorderDeco
 *        / getColumn(), getRow(), getText()
 * @class FullBorderDeco extends AbsBorderDeco
 *        / String line /
 *        / getColumn(), getRow(), getText(), -buildLine()
 *
 * @author shika
 * @date 2021-06-09
 */
package javaGoF.chap12Decorator.decoBorder;

public class MainDecoBorder {

    public static void main(String[] args) {
        AbsDisplayDeco text = new TextDisplayDeco("Hello, World");
        AbsDisplayDeco side = new SideBorderDeco(text, "#");
        AbsDisplayDeco full = new FullBorderDeco(side);
        text.show();
        side.show();
        full.show();

        AbsDisplayDeco deco =
            new SideBorderDeco(
                new FullBorderDeco(
                    new TextDisplayDeco("This is a Deco.")), "*");
        deco.show();

        AbsDisplayDeco deco2 =
            new SideBorderDeco(
                new FullBorderDeco(
                    new FullBorderDeco(
                        new SideBorderDeco(
                            new FullBorderDeco(
                                new TextDisplayDeco("This is a Deco.")), "*")
                    )
                )
            ,"/");
        deco2.show();
    }//main()

}//class

/*
Hello, World
#Hello, World#
+--------------+
|#Hello, World#|
+--------------+
*+-----------------------------+*
*|こんにちは Decoです。|*
*+-----------------------------+*

【考察】
フォント [consolas]だと全角文字が細く表示されるため、ズレて見える
String.getBytes().lengthで、文字のバイト数を出しているので
全角文字は多くなるのかも。

試しに 半角文字だけ実行してみたらいい。
*+---------------+*
*|This is a Deco.|*
*+---------------+*
*
/+---------------------+/
/|+-------------------+|/
/||*+---------------+*||/
/||*|This is a Deco.|*||/
/||*+---------------+*||/
/|+-------------------+|/
/+---------------------+/
デコりすぎや
*/