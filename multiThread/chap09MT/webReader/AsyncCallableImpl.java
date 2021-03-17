package multiThread.chap09MT.webReader;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncCallableImpl
        extends FutureTask<SyncContentImpl> implements AbsContent {

    public AsyncCallableImpl(Callable<SyncContentImpl> callable) {
        super(callable);
    }

    @Override
    public byte[] getByteAry() {
        byte[] byteAry = null;

        try {
            byteAry = get().getByteAry();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return byteAry;
    }//getByteAry()

}//class
