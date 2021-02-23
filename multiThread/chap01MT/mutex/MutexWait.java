package multiThread.chap01MT.mutex;

public class MutexWait {
    private boolean busy;

    public synchronized void lock() {
        while(busy) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }//while

        busy = true;
    }//lock()

    public synchronized void unlock() {
        busy = false;
        notifyAll();
    }//unlock()
}//class

/*
AliceBEGIN
ChrisBEGIN
BobbyBEGIN
  :
(BROKEN 出ず)
 */