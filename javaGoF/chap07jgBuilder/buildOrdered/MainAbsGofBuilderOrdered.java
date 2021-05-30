/**
 * @title javaGoF / chap07jgBuilder / buildOrdered / MainAbsGofBuilderOrdered.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第７章 Builder / p94
 * @content 練習問題 7-2 SwingGofBuilder
 *          GofBuilderの makeTitle()が
 *          他のメソッドより常に先に呼び出されるよう規定するコードに変更。
 *          GofBuilderOrderedとす。
 *
 *          makeXxxx()呼出順を制御し、
 *          旧来の makeXxxx() -> buildXxxx()に改名。
 *          BuilderDirectorクラスは変更ないので、
 *          abstractBuilderパッケージのものを利用。
 *
 * @class MainAbsBuilderOrdered / ◆main(), Scannerで作成するファイルを聞く。
 * @class abstract GofBuilderOrdered extends GofBuilder
 * @class BuilderDirector / 文字列を定義、GofBuilderの実行
 * @class TextGofBuilderOrdered extends GofBuilderOrdered
 *         / プレーンテキスト(普通のテキスト)
 * @class HtmlGofBuilderOrdered extends GofBuilderOrdered
 *         / HTMLファイルを作成
 * @class SwingGofBuilderOrdered extends GofBuilderOrdered
 *         / Swingウィンドウで表示
 *
 * @see abstractBuilder/swingBuilderResult.jpg
 * @author shika
 * @date 2021-05-30
 */
package javaGoF.chap07jgBuilder.buildOrdered;

import java.util.Scanner;

import javaGoF.chap07jgBuilder.abstractBuilder.BuilderDirector;

public class MainAbsGofBuilderOrdered {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("テキスト形式は？ plain / html / swing ");
        String input = scn.nextLine();

        if (input.equals("plain")) {
            TextGofBuilderOrdered textBuilder = new TextGofBuilderOrdered();
            BuilderDirector director = new BuilderDirector(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);

        } else if (input.equals("html")) {
            HtmlGofBuilderOrdered htmlBuilder = new HtmlGofBuilderOrdered();
            BuilderDirector director = new BuilderDirector(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + "が作成されました。");

        } else if (input.equals("swing")) {
            SwingGofBuilderOrdered swingBuilder = new SwingGofBuilderOrdered();
            BuilderDirector director = new BuilderDirector(swingBuilder);
            director.construct();
            String frameTitle = swingBuilder.getResult();
            System.out.println(frameTitle);

        } else {
            usage();
            System.exit(1);
        }

        scn.close();
    }//main()

    private static void usage() {
        System.out.println(
            "使い方: >java MainAbsGofBuilderOrdered plain \n" +
            "//プレーンテキストで文書作成");
        System.out.println();
        System.out.println(
            "使い方: >java MainAbsGofBuilderOrdered html \n" +
            "//HTMLファイルで文書作成");
    }//usage()

}//class

/*
テキスト形式は？ plain / html / swing plain
===================
『Greeting』

■朝から昼にかけて

おはようございます
こんにちは

■夜に

こんばんは
おやすみなさい
さようなら

===================

テキスト形式は？ plain / html / swing html
Greeting.htmlが作成されました。

<html><head><title>Greeting</title></head><body>
<h1>Greeting</h1>
<p>朝から昼にかけて</p>
<ul>
<li>おはようございます</li>
<li>こんにちは</li>
</ul>
<p>夜に</p>
<ul>
<li>こんばんは</li>
<li>おやすみなさい</li>
<li>さようなら</li>
</ul>
</body></html>

テキスト形式は？ plain / html / swing swing
swing: Greeting
@see abstractBuilder/swingBuilderResult.jpg
*/