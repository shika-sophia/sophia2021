/**
 * @title javaGoF / chap15Facade / facade / MainFacade.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第15章 Facade / List 15-1 ～ 15-5
 *          シンプルな窓口: PageMakerFacadeが全てのクラスの窓口。
 *          複雑なクラス構成になっても、ここが振り分ける。
 *          呼出側は PageMakerFacadeの メソッドを呼ぶだけでいい。
 * @content 練習問題 15-1
 *          処理クラス群をカプセル化するために
 *          super PageMakerFacadeとする継承関係で結合。
 *          コンストラクタを protectedに変更。メソッドは publicのまま。
 * @content 練習問題 15-2
 *          PageMakerFacade.linkPage()を追加。
 *
 * @class MainFacade / ◆main()
 * @class PageMakerFacade
 *        / #PageMakerFacade() /
 *        +static welcomePage(String mailAd, String output)
 *        +static linkPage(String output)
 * @class HtmlWriterFacade extends PageMakerFacade
 *        / Writer writer /
 *        #HtmlWriterFacade(Writer writer)
 *        header(), message(), link(), mailto(), footer()
 * @class DaoFacade extends PageMakerFacade
 *        / #DaoFacade() /
 *        +static getProperty(String dataName)
 * @file mailData.txt
 * @file welcome.html
 * @file linkPage.html
 * @author shika
 * @date 2021-06-16, 06-17
 */
package javaGoF.chap15Facade.facade;

public class MainFacade {

    public static void main(String[] args) {
        String dir = "src/javaGoF/chap15Facade/facade/";
        PageMakerFacade.welcomePage("hyuki@hyuki.com", dir + "welcome.html");
        PageMakerFacade.linkPage(dir + "linkPage.html");
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

//---- welcome.html ---- (改行筆者)
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

//練習問題 15-2
src/javaGoF/chap15Facade/facade/linkPage.html is created.

//---- linkPage.html ---- (改行筆者)
<html>
<head>
<title> Link Page </title>
</head>
<body>
    <h1> Link Page </h1>
    <p><a href='mailto:tomura@hyuki.com'>Tomura</a></p>
    <p><a href='mailto:hanako@hyuki.com'>Hanako Sato</a></p>
    <p><a href='mailto:hyuki@hyuki.com'>Hiroshi Yuki</a></p>
    <p><a href='mailto:momoru@Htyki.com'>Mamoru Talahashi</a></p>
</body>
</html>

 */
