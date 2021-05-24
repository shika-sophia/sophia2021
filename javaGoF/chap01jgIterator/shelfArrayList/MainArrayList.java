/**
 * @title javaGoF / chap01JG / shelfArrayList / MainArrayList.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第１章 Iterator / 練習問題 1-1
 * @content BookShelfの配列を ArrayListとし、いくらでも追加可能な Shelfとする。
 * @author shika
 * @date 2021-04-04
 */
package javaGoF.chap01jgIterator.shelfArrayList;

import javaGoF.chap01jgIterator.iterator.Book;
import javaGoF.chap01jgIterator.iterator.BookShelf;
import javaGoF.chap01jgIterator.iterator.ISimpleIterator;

public class MainArrayList {

    public static void main(String[] args) {
        //BookShelf shelf = new BookShelf(4);
        BookShelf shelf = new ShelfArrayList();
        shelf.appendBook(new Book("Around the World in 80 Days"));
        shelf.appendBook(new Book("Bible"));
        shelf.appendBook(new Book("Cinderella"));
        shelf.appendBook(new Book("Daddy-Long-Legs"));
        shelf.appendBook(new Book("England History"));
        shelf.appendBook(new Book("Fortunately Blue Bird"));

        ISimpleIterator itr = shelf.iterator();

        while(itr.hasNext()) {
            Book book = (Book) itr.next();
            System.out.println(book.getName());
        }//while iterator
    }//main()
}//class

/*
Around the World in 80 Days
Bible
Cinderella
Daddy-Long-Legs
England History
Fortunately Blue Bird

【考察】 練習問題ではサンプルプログラムの変更により
どの程度の修正が必要かを体験するのが問題の趣旨のような感じなので、
元のサンプルプログラムの各クラスを利用。

BookShelfだけ新しくサブクラスとして ShelfArrayListを作る。
中身は配列を Listの記述に変更しただけ。
Mainは new BookShelf() -> new ShelfArrayList()に変更。
入れる変数は extendsしているので、そのまま BookShelf型 shelf。
継承関係にすることで、そのまま BookIteratorを使える。
*/