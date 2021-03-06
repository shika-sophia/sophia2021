package multiThread.chap06MT.readWriteLock;

public final class ReadWriteLock {
    private int readingThread = 0;
    private int waitWrite = 0;
    private int writingThread = 0;
    private boolean preferWrite = true; //書くのを優先するなら true

    public synchronized void readLock()
            throws InterruptedException {
        while(writingThread > 0 || (preferWrite && waitWrite > 0)) {
            wait();
        }

        readingThread++;
    }//readRock()

    public synchronized void readUnlock() {
        readingThread--;
        preferWrite = true;
        notifyAll();
    }//readUnlock()

    public synchronized void writeLock()
            throws InterruptedException {
        waitWrite++;

        try {
            while(readingThread > 0 || writingThread > 0) {
                wait();
            }
        } finally {
            waitWrite--;
        }

        writingThread++;
    }//writeLock()

    public synchronized void writeUnlock() {
        writingThread--;
        preferWrite = false;
        notifyAll();
    }//writeUnlock()

}//class
