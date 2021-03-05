package multiThread.chap05MT.notifyLazy;

import multiThread.chap05MT.producerConsumer.CakeTable;
import multiThread.chap05MT.producerConsumer.EaterThread;
import multiThread.chap05MT.producerConsumer.MakerThread;

public class MainLazy {

    public static void main(String[] args) {
        CakeTable table = new CakeTableNotify(3);
        new MakerThread("MakerThread-1", table, 31415L).start();
        new MakerThread("MakerThread-2", table, 92653L).start();
        new MakerThread("MakerThread-3", table, 58979L).start();
        new EaterThread("EaterThread-1", table, 32384L).start();
        new EaterThread("EaterThread-2", table, 62643L).start();
        new EaterThread("EaterThread-3", table, 38327L).start();
        new LazyThread("LazyThread-1", table).start();
        new LazyThread("LazyThread-2", table).start();
        new LazyThread("LazyThread-3", table).start();
        new LazyThread("LazyThread-4", table).start();
        new LazyThread("LazyThread-5", table).start();
        new LazyThread("LazyThread-6", table).start();
        new LazyThread("LazyThread-7", table).start();
    }//main()

}//class
