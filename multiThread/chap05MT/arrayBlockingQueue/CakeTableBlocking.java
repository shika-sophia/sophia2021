package multiThread.chap05MT.arrayBlockingQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import multiThread.chap05MT.producerConsumer.CakeTable;

public class CakeTableBlocking
        extends CakeTable implements BlockingQueue<String> {
    @SuppressWarnings("rawtypes")
    private final BlockingQueue queue;

    public CakeTableBlocking(int BOUND) {
        super(BOUND);
        this.queue = new ArrayBlockingQueue<String>(BOUND);
    }

    //ケーキを置く
    @SuppressWarnings("unchecked")
    public void put(String cake)
            throws InterruptedException {
        System.out.println(
            Thread.currentThread().getName() + " puts " + cake);
        queue.put(cake);
    }//put()

    public String take()
            throws InterruptedException {
        String cake = (String) queue.take();
        System.out.println(
            Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }//take()

    @Override
    public String remove() {return null;}
    public String poll() {return null;}
    public String element() {return null;}
    public String peek() {return null;}
    public int size() {return 0;}
    public boolean isEmpty() {return false;}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Iterator iterator() {return null;}
    public Object[] toArray() {return null;}
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] a) {return null;}
    @SuppressWarnings("rawtypes")
    public boolean containsAll(Collection c) {return false;}
    @SuppressWarnings("rawtypes")
    public boolean addAll(Collection c) {return false;}
    @SuppressWarnings("rawtypes")
    public boolean removeAll(Collection c) {return false;}
    @SuppressWarnings("rawtypes")
    public boolean retainAll(Collection c) {return false;}
    public void clear() { }
    public boolean add(String e) {return false;}
    public boolean offer(String e) {return false;}
    //public void put(Object e) throws InterruptedException { }
    public boolean offer(String e, long timeout, TimeUnit unit)
            throws InterruptedException {return false;}
    public String poll(long timeout, TimeUnit unit)
            throws InterruptedException {return null;}
    public int remainingCapacity() {return 0;}
    public boolean remove(Object o) {return false;}
    public boolean contains(Object o) {return false;}
    @SuppressWarnings("rawtypes")
    public int drainTo(Collection c) {return 0;}
    @SuppressWarnings("rawtypes")
    public int drainTo(Collection c, int maxElements) {return 0;}

}//class
