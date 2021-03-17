package multiThread.chap09MT.webReader;

public class AsyncContentImpl
        implements AbsContent {
    private SyncContentImpl sync;
    private boolean ready = false;

    public synchronized void setContent(SyncContentImpl sync) {
        this.sync = sync;
        this.ready = true;
        notifyAll();
    }//setContent()

    @Override
    public synchronized byte[] getByteAry() {
        while(!ready) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sync.getByteAry();
    }//getByteAry()

}//class
