package javaGoF.chap01JG.iterator;

public class BookIterator implements ISimpleIterator {
    private BookShelf shelf;
    private int index;

    public BookIterator(BookShelf shelf) {
        this.shelf = shelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < shelf.getLastIndex()) {
            return true;
        }

        return false;
    }//hasNext()

    @Override
    public Object next() {
        Book book = shelf.getBook(index);
        index++;

        return book;
    }//next()

}//class

/*
Around the World in 80 Days (80日間 世界一周)
Bible (聖書)
Cinderella (シンデレラ)
Daddy-Long-Legs (あしなが おじさん)

*/