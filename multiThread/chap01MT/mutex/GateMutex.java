/**
 * @see MainMutex
 */

package multiThread.chap01MT.mutex;

public class GateMutex {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final MutexSemaphore mutex = new MutexSemaphore(3);
    //private final MutexWait mutex = new MutexWait();
    //private final MutexWaitOwner mutex = new MutexWaitOwner();
    //private final MutexReent mutex = new MutexReent();

    public void pass(String name, String address) throws InterruptedException {
        mutex.lock();

        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            mutex.unlock();
        }
    }//pass

    @Override
    public String toString() {
        String str = "";
        mutex.lock();

        try {
            str = String.format(
                "No.%d: %s, %s",counter, name, address);
        } finally {
            mutex.unlock();
        }

        return str;
    }//toString()

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("###### BROKEN ###### " + toString());
        }
    }//check()

}//class

