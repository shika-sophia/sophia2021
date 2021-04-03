package javaGoF.chap01JG.iterator;

import java.awt.Toolkit;

public class BookShelf implements IAggregate {
    private Book[] bookAry;
    private final int maxSize;
    private int lastIndex = 0;

    public BookShelf(int maxSize) {
        this.bookAry = new Book[maxSize];
        this.maxSize = maxSize;
    }

    public Book getBook(int index) {
        if(0 <= index && index < maxSize) {
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
        if(lastIndex == maxSize) {
            Toolkit.getDefaultToolkit().beep();
            System.out.printf(
                "< ! > 本棚がいっぱいです。 [0 - %d]で収納してください。\n", maxSize);
            return;
        }

        bookAry[lastIndex] = book;
        lastIndex++;
    }//appendBook()

    @Override
    public ISimpleIterator iterator() {
        return new BookIterator(this);
    }

    public int getLastIndex() {
        return lastIndex;
    }

}//class
