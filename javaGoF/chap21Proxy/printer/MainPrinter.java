/**
 * @title javaGoF / chap21Proxy / printer / MainPrinter.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第21章 Proxy / List 21-1 ～ 21-4
 *          代理 Proxyクラスが 名前を聞くなど簡単な仕事を行い、
 *          本物のPrinterインスタンス生成は重いので、
 *          必要となってから初めて行う。
 * @class MainPrinter / ◆main()
 * @interface IPrintable
 *            / abstract void setPrintName(String)
 *              abstract String getPrintName()
 *              abstract void print(String)
 * @class PrinterProxy implements IPrintable
 *        / String name, Printer real /
 *        setPrintName(), getPrintName(), print(),
 *        -realize() { new Printer(String) }
 * @class Printer implements IPrintable
 *        / String name /
 *        setPrintName(), getPrintName(), print(), -heavyJob(String)
 * @author shika
 * @date 2021-06-28
 */
package javaGoF.chap21Proxy.printer;

public class MainPrinter {

    public static void main(String[] args) {
        IPrintable pri = new PrinterProxy("Alice");
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
*/

