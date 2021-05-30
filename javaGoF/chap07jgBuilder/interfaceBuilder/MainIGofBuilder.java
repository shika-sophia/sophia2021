/**
 * @title javaGoF / chap07jgBuilder / intefaceBuilder / MainIGofBuilder.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第７章 Builder / p94 / 練習問題 7-1
 *          サンプルの抽象クラスを インターフェイスに変更
 *          ２通りの IGofBuilderの実装クラスを １つのBuilderDirectorクラスで実行。
 *
 *          メソッドの中身は変更せず、extends -> implementsにしただけ。
 *          それぞれクラス名を変更したのでそれに伴う修正。
 *
 * @class MainIBuilder / ◆main(), Scannerで作成するファイルを聞く。
 * @interface IGofBuilder
 * @class IBuilderDirector / 文字列を定義、IGofBuilderの実行
 * @class TextIGofBuilder implements IGofBuilder
 *        / プレーンテキスト(普通のテキスト)
 * @class HtmlIGofBuilder implements IGofBuilder
 *        / HTMLファイルを作成
 *
 * @author shika
 * @date 2021-05-30
 */
package javaGoF.chap07jgBuilder.interfaceBuilder;

import java.util.Scanner;

public class MainIGofBuilder {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("テキスト形式は？ plain / html ");
        String input = scn.nextLine();

        if (input.equals("plain")) {
            TextIGofBuilder textBuilder = new TextIGofBuilder();
            IBuilderDirector director = new IBuilderDirector(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);

        } else if (input.equals("html")) {
            HtmlIGofBuilder htmlBuilder = new HtmlIGofBuilder();
            IBuilderDirector director = new IBuilderDirector(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + "が作成されました。");

        } else {
            usage();
            System.exit(1);
        }

        scn.close();
    }//main()

    private static void usage() {
        System.out.println(
            "使い方: テキスト形式は？ plain / html plain \n" +
            "//プレーンテキストで文書作成");
        System.out.println();
        System.out.println(
            "使い方: テキスト形式は？ plain / html html \n" +
            "//HTMLファイルで文書作成");
    }//usage()

}//class

/*
//---- テキスト出力 ----
テキスト形式は？ plain / html plain
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

//---- HTMLファイル ----
src/javaGoF/chap07jgBuilder/interfaceBuilder
/htmlIBuilder.htmlが作成されました。

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
*/
