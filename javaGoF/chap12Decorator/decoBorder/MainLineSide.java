/**
 * @title javaGoF / chap12Decorator / decoBorder / MainLineSide.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第12章 Decorator / 練習問題 12-1
 * @content 上下にラインを加える LineBorderDecoを追加
 * @see MainDecoBorder / class summary
 * @author shika
 * @date 2021-06-10
 */
package javaGoF.chap12Decorator.decoBorder;

public class MainLineSide {

    public static void main(String[] args) {
        AbsDisplayDeco text = new TextDisplayDeco("Hello, World.");
        AbsDisplayDeco line = new LineBorderDeco(text, "-");
        AbsDisplayDeco side = new SideBorderDeco(line, "*");
        text.show();
        line.show();
        side.show();

        AbsDisplayDeco deco =
            new FullBorderDeco(
                new LineBorderDeco(
                    new SideBorderDeco(
                        new LineBorderDeco(
                            new SideBorderDeco(
                                new TextDisplayDeco("This is deco too.")
                            ,"*")
                        ,"=")
                    ,"|")
                ,"/")
            );
        deco.show();
    }//main()

}//class

/*
Hello, World.

-------------
Hello, World.
-------------

*-------------*
*Hello, World.*
*-------------*

+---------------------+
|/////////////////////|
||===================||
||*This is deco too.*||
||===================||
|/////////////////////|
+---------------------+

【解答】
buildLine()は FullBorderにも登場したので、
AbsBorderに TemplateMethodとして入れても良い。てかそうすべき。

=> 解答のように修正
buildLine()を AbsBorderに入れ、
buildLine(String)に変更。
FullBorderは lineの前後に「+」が付くので、
lineだけ buildLine()で出して、
FullBorderにだけ、"+" + buildLine("-") + "+";と修正。
*/