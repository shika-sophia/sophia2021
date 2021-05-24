/**
 * @title javaGoF / chap01JG / iterator / MainIterator.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第１章 Iterator / List 1-1 ～ 1-6
 * @content Iteratorインターフェイスを自己定義して、while(hasNext()){ next() }を作成
 * @author shika
 * @date 2021-04-03
 */
package javaGoF.chap01jgIterator.iterator;

public class MainIterator {

    public static void main(String[] args) {
        BookShelf shelf = new BookShelf(4);
        shelf.appendBook(new Book("Around the World in 80 Days"));
        shelf.appendBook(new Book("Bible"));
        shelf.appendBook(new Book("Cinderella"));
        shelf.appendBook(new Book("Daddy-Long-Legs"));

        ISimpleIterator itr = shelf.iterator();

        while(itr.hasNext()) {
            Book book = (Book) itr.next();
            System.out.println(book.getName());
        }//while iterator
    }//main()
}//class

