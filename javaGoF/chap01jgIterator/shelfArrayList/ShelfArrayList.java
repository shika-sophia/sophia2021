package javaGoF.chap01jgIterator.shelfArrayList;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javaGoF.chap01jgIterator.iterator.Book;
import javaGoF.chap01jgIterator.iterator.BookIterator;
import javaGoF.chap01jgIterator.iterator.BookShelf;
import javaGoF.chap01jgIterator.iterator.IAggregate;
import javaGoF.chap01jgIterator.iterator.ISimpleIterator;

public class ShelfArrayList
        extends BookShelf implements IAggregate {
    private final List<Book> bookList;

    public ShelfArrayList() {
        super(0); //BookShelfの配列は利用しない
        this.bookList = new ArrayList<Book>();
    }

    public Book getBook(int index) {
        if(0 <= index && index < bookList.size()) {
            ;
        } else {
            Toolkit.getDefaultToolkit().beep();
            System.out.printf(
                "< ! > indexが不正です。 [0 - %d]で指定してください。\n",
                bookList.size());
            return null;
        }

        return bookList.get(index);
    }//getBook()

    public void appendBook(Book book) {
        bookList.add(book);
    }//appendBook()

    @Override
    public ISimpleIterator iterator() {
        return new BookIterator(this);
    }

    public int getIndex() {
        return bookList.size();
    }

}//class
