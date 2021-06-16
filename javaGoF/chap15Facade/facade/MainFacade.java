/**
 * @title javaGoF / chap15Facade / facade / MainFacade.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第15章 Facade / List 15-1 ～ 15-5
 *          シンプルな窓口: PageMakerFacadeが全てのクラスの窓口。
 *          複雑なクラス構成になっても、ここが振り分ける。
 *          呼出側は PageMakerFacadeの メソッドを呼ぶだけでいい。
 *
 * @class MainFacade / ◆main()
 * @class PageMakerFacade
 *        / -PageMakerFacade() /
 *        +static welcomePage(String mailAd, String fileName)
 * @class HtmlWriterFacade
 *        / Writer writer /
 *        header(), message(), link(), mailto(), footer()
 * @class DaoFacade
 *        / -DaoFacade() /
 *        +static getProperty(String dataName)
 * @file mailData.txt
 * @file welcome.html
 * @author shika
 * @date 2021-06-16
 */
package javaGoF.chap15Facade.facade;

public class MainFacade {

    public static void main(String[] args) {
        String dir = "src/javaGoF/chap15Facade/facade/";
        PageMakerFacade.welcomePage("hyuki@hyuki.com", dir + "welcome.html");
    }//main()

}//class

/*
src/javaGoF/chap15Facade/facade/welcome.html
    is created for hyuki@hyuki.com(Hiroshi Yuki)

//---- mailData.txt ----
hyuki@hyuki.com=Hiroshi Yuki
hanako@hyuki.com=Hanako Sato
tomura@hyuki.com=Tomura
momoru@Htyki.com=Mamoru Talahashi

//---- welcome.html ----
<html>
<head>
<title> Welcome to Hiroshi Yuki's Page! </title>
</head>
<body>
<h1> Welcome to Hiroshi Yuki's Page! </h1>
<p>Hiroshi Yukiのページに ようこそ</p>
<p>メール待ってますね</p>
<p><a href='mailto:hyuki@hyuki.com'>Hiroshi Yuki</a></p>
</body>
</html>

 */
