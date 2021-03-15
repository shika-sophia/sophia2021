package multiThread.chap09MT.futureData;

public class FutureData implements AbsData {
    private RealData real = null;
    private boolean ready = false;

    @Override
    public synchronized String getContent() {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while

        return real.getContent();
    }//getContent()

    public synchronized void setRealData(RealData real) {
        if(ready) {
            return; //balking twice;
        }
        this.real = real;
        ready = true;
        notifyAll();
    }//setRealData
}//class
