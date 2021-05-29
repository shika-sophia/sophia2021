/**
 * @title javaGoF / chap07jgBuilder / abstractBuilder / MainAbsGofBuilder.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第７章 Builder / p82 / List 7-1 ～ 7-5
 *          ２通りの GofBuilderのサブクラスを １つのBuilderDirectorクラスで実行。
 *
 * @class MainAbsBuilder / ◆main(), Scannerで作成するファイルを聞く。
 * @class abstract GofBuilder
 * @class BuilderDirector / 文字列を定義、GofBuilderの実行
 * @class TextGofBuilder / プレーンテキスト(普通のテキスト)
 * @class HtmlGofBuilder / HTMLファイルを作成
 *
 * @author shika
 * @date 2021-05-29
 */
package javaGoF.chap07jgBuilder.abstractBuilder;

import java.util.Scanner;

public class MainAbsGofBuilder {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("テキスト形式は？ plain / html ");
        String input = scn.nextLine();

        if (input.equals("plain")) {
            TextGofBuilder textBuilder = new TextGofBuilder();
            BuilderDirector director = new BuilderDirector(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);

        } else if (input.equals("html")) {
            HtmlGofBuilder htmlBuilder = new HtmlGofBuilder();
            BuilderDirector director = new BuilderDirector(htmlBuilder);
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
            "使い方: >java MainAbsGofBuilder plain \n" +
            "//プレーンテキストで文書作成");
        System.out.println();
        System.out.println(
            "使い方: >java MainAbsGofBuilder html \n" +
            "//HTMLファイルで文書作成");
    }//usage()

}//class

/*
【考察】
サンプル原文は args.length, args[0].equals()の if文であったが
Eclipseの [実行の構成]->[VM引数],[ワークスペース]を合わせても
ClassNotFoundExceptionが throwされ、classファイルを見つけられない様子。

コマンドプロンプトで各ファイルをコンパイルしようと思ったが、
GofBuilderは成功。
TextGofBuilderのコンパイルが
@Overrideのところで失敗するので

Scanner入力方式に変更。

【実行結果】
使い方: >java MainAbsGofBuilder plain
//プレーンテキストで文書作成

使い方: >java MainAbsGofBuilder html
//HTMLファイルで文書作成

テキスト形式は？ plain / html
plain
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

テキスト形式は？ plain / html html
src/javaGoF/chap07jgBuilder/abstractBuilder/htmlBuilder.htmlが作成されました。
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