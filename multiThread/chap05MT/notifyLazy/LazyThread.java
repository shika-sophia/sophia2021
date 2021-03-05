package multiThread.chap05MT.notifyLazy;

import multiThread.chap05MT.producerConsumer.CakeTable;

public class LazyThread extends Thread {
    private final CakeTableNotify table;

    public LazyThread(String name, CakeTable table) {
        super(name);
        this.table = (CakeTableNotify) table;
    }

    public void run() {
        while(true) {
            synchronized(table) {
                try {
                    table.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(getName() + " is notified!");
        }//while loop
    }//run()
}//class
