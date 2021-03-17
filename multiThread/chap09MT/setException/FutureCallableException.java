package multiThread.chap09MT.setException;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import multiThread.chap09MT.futureData.RealData;

public class FutureCallableException
        extends FutureTask<RealData> implements AbsData {

    public FutureCallableException(Callable<RealData> callable) {
        super(callable);
    }

    public String getContent() throws ExecutionException {
        String str = null;
        try {
            //戻り値である RealDataを取得して、その getContent()を呼び出し
            str = get().getContent();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return str;
    }//getContent()
}//class
