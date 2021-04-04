package javaGoF.chap01JG.shelfArrayList;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javaGoF.chap01JG.iterator.Book;
import javaGoF.chap01JG.iterator.BookIterator;
import javaGoF.chap01JG.iterator.BookShelf;
import javaGoF.chap01JG.iterator.IAggregate;
import javaGoF.chap01JG.iterator.ISimpleIterator;

public class ShelfArrayList
        extends BookShelf implements IAggregate {
    private final List<Book> bookList;
    private int index;

    public ShelfArrayList() {
        super(0); //BookShelfの配列は利用しない
        this.bookList = new ArrayList<Book>();
        this.index = 0;
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
        index = getIndex() + 1;
    }//appendBook()

    @Override
    public ISimpleIterator iterator() {
        return new BookIterator(this);
    }

    public int getIndex() {
        return index;
    }

}//class
