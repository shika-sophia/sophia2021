/**
 * @title javaGoF / chap02JG / adapterInheritance / MainAdapterInheritance.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第２章 Adapter / List 2-1, 2-2, 2-3, 2-4
 * @content サンプルプログラム１ / 継承(inheritance)を用いた Adapterパターン
 * @author shika
 * @date 2021-04-06
 */
package javaGoF.chap02JG.adapterInheritance;

public class MainAdapterInheritance {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }//main()

}//class

/*
(Hello)
*Hello*

【解説】 p20
Printインターフェイスの変数に PrintBannerクラスのインスタンスを代入。
Bunnerクラスの showWithParen(), showWithAster()は Mainからは見れずに隠蔽。
Mainは PrintBannerのことしか知らない。(その先のことは知らない)
=> Mainを全く変更せずに PrintBannerの実装を変更できる。

*/