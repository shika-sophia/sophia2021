/**
 * @title javaGoF / chap08AbstractFactory / Practice08JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第８章 練習問題 8-1, 8-2, 8-3, 8-4
 * @author shika
 * @date 2021-06-02
 */
/* Appendix 2021-06-02
 * @costTime 11:42 - 12:01 ( 18 分)
 * @correctRate 正答率 35.71 ％ ( 〇5問 / 全14問 )
 */
package javaGoF.chap08AbstractFactory;

import javaGold.PracticeEditor;

public class Practice08JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-02 ======
 第８章 練習問題 8-1
〇 （1） 問 AbsTrayの itemListが protectedになっているが、privateにすると
Ｘ （2） (良い点) 他クラスから参照不可となり、変更を加えられないのでマルチスレッド時はデータレースを起こしにくい。
Ｘ （3） (悪い点) 継承クラスで参照できなくなるのでコンパイルエラーが起きる。
    => (良い点) Trayのサブクラスが、
    *  フィールド itemListに依存したクラスにならない点。
    => (悪い点) privateにすると、getterメソッドを用意する必要がある。
    *  一般に protectedより、privateにして必要な getterを用意したほうが
    *  安全なプログラムになる。

 8-2
Ｘ （1） 問 AbsFactoryに createYahooPage(String caption, String url)を定義。
Ｘ （2） 各具体的工場にも、createYahooPage()を設置。
Ｘ （3） 各パッケージの具体的部品に ListYahooPage.makeHtml()を用意する必要がある。
    => Factory, Mainの修正だけで済む。
    *  Link, Tray, Pageの既存のクラスで createYahooPage()を定義すれば、
    *  新たな部品の追加は必要なくなる。
    *  〔サンプルに追加 MainYahooPage, AbsFactory.createYahooPage(String select)〕

 8-3
〇 （1） 問 具体的クラスの super()はなぜあるか
〇 （2） Mainのデータを ListFactoryが受け、そこでコンストラクタ ListLinkなどを呼出するから
〇 （3） superクラスもインタンスするので、super()がないとコンパイルエラー。
〇 （4） 具体クラスのフィールドは Absクラスにあるので、それをコンストラクタで初期化
    => 継承クラスにコンストラクタは継承されない。

 8-4
Ｘ （1） 問 Pageと Trayは似た動きをするのに、なぜ Page extends Trayとしないのか。
Ｘ （2） Pageクラスは Htmlページ全体の生成。 Trayは部品のHtml生成。
Ｘ （3） 継承した場合 item.makeHtml()で部品の生成がしずらくなるからかな？
Ｘ （4） ここ、解答で要確認。
    => Pageは Trayに add()できない。
    *  HTML文法上、Page <html></html>を、
    *  Tray.itemList()の Link <a href=""></a>,
    *  Tray <li></li>の要素にはできない。
    *
    => Pageを Trayのサブクラスにすると、AbsItemのサブクラスにもなり、
    *  java文法上は itemList.add(AbsItem)に
    *  Pageをadd()することが可能になってしまう。
    *
    => なので、Pageは AbsItemを継承しないほうがいいが
    *  すると、Pageで新たに makeHtml()を宣言する必要があった。
    *    interface Htmlable {
    *        public abstract makeHtml();
    *    }
    *  を用意して、AbsItem, AbsPageに implementsさせると、
    *  よりすっきりまとめられる。

開始時刻 11:42
終了時刻 12:01
所要時間 18 分
正答率 35.71 ％ ( 〇5問 / 全14問 )
*/

