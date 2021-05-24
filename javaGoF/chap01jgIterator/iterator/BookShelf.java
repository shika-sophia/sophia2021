package javaGoF.chap01jgIterator.iterator;

import java.awt.Toolkit;

public class BookShelf implements IAggregate {
    private Book[] bookAry;
    private final int maxSize;
    private int index = 0;

    public BookShelf(int maxSize) {
        this.bookAry = new Book[maxSize];
        this.maxSize = maxSize;
    }

    public Book getBook(int index) {
        if(0 <= index && index < bookAry.length) {
            ;
        } else {
            Toolkit.getDefaultToolkit().beep();
            System.out.printf(
                "< ! > indexが不正です。 [0 - %d]で指定してください。\n",
                bookAry.length);
            return null;
        }

        return bookAry[index];
    }//getBook()

    public void appendBook(Book book) {
        if(index == maxSize) {
            Toolkit.getDefaultToolkit().beep();
            System.out.printf(
                "< ! > 本棚がいっぱいです。 [0 - %d]で収納してください。\n", maxSize);
            return;
        }

        bookAry[index] = book;
        index++;
    }//appendBook()

    @Override
    public ISimpleIterator iterator() {
        return new BookIterator(this);
    }

    public int getIndex() {
        return index;
    }

}//class
