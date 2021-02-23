package multiThread.chap01MT.mutex;

public class MutexWaitOwner {
    private long lockCount = 0;
    private Thread owner = null;

    public synchronized void lock() {
        Thread me = Thread.currentThread();

        while(lockCount > 0 && owner != me) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        assert lockCount == 0 || owner == me;
        owner = me;
        lockCount++;
    }//lock()

    public synchronized void unlock() {
        Thread me = Thread.currentThread();

        if(lockCount == 0 || owner != me) {
            return;
        }
        assert lockCount > 0 && owner == me;
        lockCount--;

        if (lockCount == 0) {
            owner = null;
            notifyAll();
        }
    }//unlock()
}//class

/*
ChrisBEGIN
AliceBEGIN
BobbyBEGIN
  :
(BROKEN 出ず)
 */
