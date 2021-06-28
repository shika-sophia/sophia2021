/**
 * @title javaGoF / chap21Proxy / printer / MainPrinter.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第21章 Proxy / List 21-1 ～ 21-4
 *          代理 Proxyクラスが 名前を聞くなど簡単な仕事を行い、
 *          本物のPrinterインスタンス生成は重いので、
 *          必要となってから初めて行う。
 * @content 練習問題 21-1 Printerに依存しない printerProxyを作成
 *          Proxy内で Printerインスタンスを作成しないと、
 *          必要に応じてインスタンスという仕様が変わってしまうので、
 *          newではなく、Class.forName(String).newInstance()で生成するように変更。
 *
 * @class MainPrinter / ◆main()
 * @interface IPrintable
 *            / abstract void setPrintName(String)
 *              abstract String getPrintName()
 *              abstract void print(String)
 * @class PrinterProxy implements IPrintable
 *        / String name, Printer real /
 *        setPrintName(String), getPrintName(), print(String),
 *        -realize() { new Printer(String) }
 *        -realize() { Class.forName(String).newInstance() }
 * @class Printer implements IPrintable
 *        / String name /
 *        setPrintName(String), getPrintName(), print(String),
 *        -heavyJob(String)
 * @author shika
 * @date 2021-06-28
 */
package javaGoF.chap21Proxy.printer;

public class MainPrinter {

    public static void main(String[] args) {
        //IPrintable pri = new PrinterProxy("Alice");
        IPrintable pri = new PrinterProxy("Alice", "Printer");
        System.out.printf(
            "現在の名前は %s です。 \n", pri.getPrintName());

        pri.setPrintName("Bob");
        System.out.printf(
            "現在の名前は %s です。 \n", pri.getPrintName());

        pri.print("Hello, World");
    }//main()

}//class

/*
現在の名前は Alice です。
現在の名前は Bob です。
Printerインスタンス(Bob)生成中.....完了
==== Bob ====
Hello, World

//---- 練習問題 21-1 ----
コンストラクタに文字列としてクラス名を入れるよう変更
PrinterProxy(String name, String className)
それに伴い、Mainの new PrinterProxy()に引数追加。

◆Class.forName(String)
ClassNotFoundException が出されがち、
forName(String)の引数は完全修飾名。
プロジェクト名からの相対パスではないことに注意。 -> 「src/」不要、「.java」不要。
importの「package.Class名」と同じ文字列。

◆Class.newInstance()
引数の指定不可。 -> 必要なら setXxxx()で代入。
戻り値 Object。
ここでは元々 Printer real。
Printer real に Objectを代入するならキャストが必要。

・Printerにキャストするなら、せっかく new Printer()から
    Class.newInstance()にした意味がなくなる。
    Printerのクラス名の記述をなくして、クラス依存を解消するのが修正の目的。

・Object realにすると、他メソッドの real.setPrintName()が使えなくなる。

そこで IPrintableを実装するクラスならＯＫということにして、
IPintable realに設定すると両方解決。

//---- 実行結果 ----
現在の名前は Alice です。
現在の名前は Bob です。
Printerインスタンスを生成中.....完了
==== Bob ====
Hello, World

*/

