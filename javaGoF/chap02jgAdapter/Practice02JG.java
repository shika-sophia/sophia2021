/**
 * @title javaGoF / chap02JG / Practice02JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第２章 Adapter / 練習問題
 * @author shika
 * @date 2021-04-06
 */
package javaGoF.chap02jgAdapter;

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
    別名を付けた BannerPrintクラス型群の変数だと同じ配列に入れられない。
    あいや、そんなことはない。
    配列には「共変」という性質があり、
    親クラスの配列に、個別の子クラスは要素として入れられる。

    それなら、 PrintBanner型の変数にしても同じということ・・・
    ポリモーフィズム(多態性)って何のためにするんだろう。

    もし別名の PrintBannerクラス名を付けるなら、Mainの newのところも修正が必要だな。
    このサンプルでは利用していないが
  PrintBannerクラスを コンストラクタやメソッドの引数にする場合、
    別名のクラス名だと、型が違うのでクラス名を変更するたびに、
    別の型用のコンストラクタや メソッドを用意するか、型の部分を書き換えなければいけないけど

    コンストラクタやメソッドの引数を Print型にしておけば、
  PrintBannerクラスの別名をいくら増やしても、Print型で同一視して
    同じコンストラクタやメソッドで扱える。
    ポリモーフィズムの最大の利点はココだ思う。

＊解答 Text Answer
    「Printインターフェイス/抽象クラスのメソッドだけを用いる」
    「PrintBannerクラスのメソッドではなく、Printのメソッドを利用している」
    というプログラマ(= 設計者)の意図をはっきり明示するためとのこと。

    PrintBannerクラスのメソッドを用いたいときは、
    (PrintBanner) p.method() とキャストすれば呼び出せる。
*/