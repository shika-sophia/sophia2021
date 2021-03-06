package multiThread.chap06MT.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import multiThread.chap06MT.readWriteLock.ReadWriteData;

public class ReentrantData extends ReadWriteData {
    private final ReadWriteLock lock =
            new ReentrantReadWriteLock(true); //fair = true
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public ReentrantData(int size) {
        super(size);
    }

    @Override
    public String[] read() throws InterruptedException {
        readLock.lock();
        try {
            return doRead();
        } finally {
            readLock.unlock();
        }
    }//read()

    @Override
    public void write(String str) throws InterruptedException {
        writeLock.lock();
        try {
            doWrite(str);
        } finally {
            writeLock.unlock();
        }
    }//write()
}//class
