package multiThread.chap09MT.futureCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import multiThread.chap09MT.futureData.AbsData;
import multiThread.chap09MT.futureData.RealData;

public class FutureCallable
        extends FutureTask<RealData> implements AbsData{

    public FutureCallable(Callable<RealData> callable) {
        super(callable);
    }

    public String getContent() {
        String str = null;
        try {
            //戻り値である RealDataを取得して、その getContent()を呼び出し
            str = get().getContent();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch(ExecutionException e) {
            e.printStackTrace();
        }

        return str;
    }//getContent()
}//class
