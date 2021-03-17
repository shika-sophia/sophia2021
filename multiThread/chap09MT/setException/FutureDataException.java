package multiThread.chap09MT.setException;

import java.util.concurrent.ExecutionException;

import multiThread.chap09MT.futureData.RealData;

public class FutureDataException implements AbsData {
    private RealData real = null;
    private ExecutionException exception = null;
    private boolean ready = false;

    @Override
    public synchronized String getContent()
            throws ExecutionException {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while

        if(exception != null) {
            throw exception;
        }

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

    public synchronized void setException(Throwable throwable) {
        if(ready) {
            return;
        }
        this.exception = new ExecutionException(throwable);
        this.ready = true;
        notifyAll();
    }//setExeption()
}//class
