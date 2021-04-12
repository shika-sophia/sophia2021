/**
 * @title javaGoF / chap03JG / templateMethod / MainTemplate.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第３章 TemplateMethod / List 3-1, 3-2, 3-3, 3-4
 * @author shika
 * @date 2021-04-12
 */
package javaGoF.chap03JG.templateMethod;

public class MainTemplate {

    public static void main(String[] args) {
        //charDisplay, StringDisplayの各インスタンス生成
        AbsDisplay dis1 = new CharDisplay('H');
        AbsDisplay dis2 = new StringDisplay("Hello World");
        AbsDisplay dis3 = new StringDisplay("こんにちは");

        //各インスタンスで AbsDisplay.display()を呼出
        dis1.display();
        dis2.display();
        dis3.display();
    }//main()

}//class

/* ５回ずつ繰り返し
<<HHHHH>>
+-----------+
|Hello World|
|Hello World|
|Hello World|
|Hello World|
|Hello World|
+-----------+
+---------------+
|こんにちは|
|こんにちは|
|こんにちは|
|こんにちは|
|こんにちは|
+---------------+

【考察】
「こんにちは」のほうの widthが大きすぎて枠が崩れている。
str.getBytes().lengthが原因と思われる。
半角英数のほうは、ちゃんとできている。

str.length()でいいのでは？やってみる。

+-----+
|こんにちは|
|こんにちは|
|こんにちは|
|こんにちは|
|こんにちは|
+-----+

width 小さすぎ。全角文字だからそりゃそうか。
String.length()は 全角でも５文字になる。
やっぱ、str.getBytes().lengthで正解。
この Font「consolas」は全角が細く見えるからフォントの問題かも

Gitも consolasを使っているのか、
0, o / 1, i, l, | の区別ができて見やすい。
「,」「.」「;」「:」も 太字で強調してくれて見やすいフォント。

ただ、欧文フォントなので、全角文字は 普通のＭＳゴシック。
0, ０, O, Ｏ 全角ゼロと オーの区別は付かない。

*/