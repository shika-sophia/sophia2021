/**
 * @title javaGoF / chap01JG / shelfArrayList / MainArrayList.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第１章 Iterator /
 * @content Collection内にある Iteratorを利用。
 * @author shika
 * @date 2021-04-04
 */

package javaGoF.chap01jgIterator.shelfArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javaGoF.chap01jgIterator.iterator.Book;

public class MainCollectionIterator {

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>(
            Arrays.asList(
                new Book("Around the World in 80 Days"),
                new Book("Bible"),
                new Book("Cinderella"),
                new Book("Daddy-Long-Legs"),
                new Book("East of Eden"),
                new Book("Fortunately Blue Bird"),
                new Book("Gulliver\'s Travels"),
                new Book("Hamlet")
            )
        );//bookList

//        //---- Collection.iterator() ----
//        Iterator<Book> itr = bookList.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next().getName());
//            //bookList.remove(itr.next()); //ConcurrentModificationException
//            itr.remove();
//        }//while
//
//      //---- 拡張for ----
//      for(Book book : bookList) {
//          System.out.println(book.getName());
//          //bookList.remove(book); //ConcurrentModificationException
//      }
//        System.out.println("bookList: " + bookList);

        //---- ListIterator extends Iterator ----
        ListIterator<Book> listItr = bookList.listIterator(bookList.size());
        while(listItr.hasPrevious()) {
            System.out.println(listItr.previous().getName());
            listItr.remove();
        }//while
        System.out.println("bookList: " + bookList);
    }//main()

}//class

/*
//====== Collection.iterator() ======
Around the World in 80 Days
Bible
Cinderella
Daddy-Long-Legs
England History
Fortunately Blue Bird

//====== for(Book book : bookList) ======
Around the World in 80 Days
Bible
Cinderella
Daddy-Long-Legs
England History
Fortunately Blue Bird

//====== itr.remove() ======
Around the World in 80 Days
Bible
Cinderella
Daddy-Long-Legs
England History
Fortunately Blue Bird
bookList: []

//====== ListIterator<Book>.previous() ======
Hamlet
Gulliver's Travels
Fortunately Blue Bird
East of Eden
Daddy-Long-Legs
Cinderella
Bible
Around the World in 80 Days
bookList: []


【考察】順次実行なら Iteratorでなく 拡張forでいい。
内部的に Iteratorを使って処理しているとのこと。

for文内で remove()するなら Iteratorでないと例外出ます。
逆順にするなら Itrratorのサブインターフェイス ListIteratorを利用する。
 */
