/**
 * @title javaGoF / chap02JG / adapterDevolve / MainAdapterDevolve.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第２章 Adapter / List 2-5, 2-6
 * @content サンプルプログラム２ / 委譲(devolve)を用いた Adapterパターン
 * @author shika
 * @date 2021-04-06
 */
package javaGoF.chap02jgAdapter.adapterDevolve;

public class MainAdapterDevolve {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }//main()

}//class

/*
(Hello)
*Hello*

【考察】 MainAdapterの名前は違うが、全く同じもの。(= 全く変更していない)
こちらは Printクラス, 委譲版の PrintBannerを 同packageから参照している。

*/