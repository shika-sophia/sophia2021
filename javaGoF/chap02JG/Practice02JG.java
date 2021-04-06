/**
 * @title javaGoF / chap02JG / Practice02JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第２章 Adapter / 練習問題
 * @author shika
 * @date 2021-04-06
 */
package javaGoF.chap02JG;

import utility.ioFileDiv.BuildFilePage;

public class Practice02JG {

    public static void main(String[] args) {
        new BuildFilePage("第２章 Adapter / 練習問題");
    }//main()

}//class

/*
//==== 練習問題 2-1 ====
＊問 PrintBannerのインスタンスを作るとき、Print型の変数に代入したが、
    Print p = new PrintBanner();

なぜ下記のように PrintBanner型の変数に代入しないのか
    PrintBanner p = new PrintBanner();

＊回答 My Answer
    この後、PrintBannerクラスの別versionができても、
    Printの継承/実装にしておけば、Print型の変数として扱うことができ、
    PrintBannerクラスの変更で Mainクラスに影響を及ぼすことがなくなるから。
    (= Mainを全く変更しなくていい)

    ああ、でもそれは PrintBannerの変数にしても同じか・・・

    ポリモーフィズム(多態性)って何のためにするんだろう。
    PrintBannerの変更をクラスごと上書きするなら、同じクラス名の newで行けるけど、
    普通は PrintBannerと別クラスにして、別versionを別名で管理する。
    そのとき、旧versionと 新versionは 全く別のクラス同士だが、
    Printを継承/実装すると、同一視できて 同じものとして扱える。

    後に必要なら Print[] 配列に入れられる。
    別名を付けた BannerPrintクラス群の変数だと同じ配列に入れられない。

＊解答 Text Answer

*/