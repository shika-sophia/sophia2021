package multiThread.chap09MT.futureCallable;

import java.util.concurrent.Callable;

import multiThread.chap09MT.futureData.RealData;

public class HostCallable {
    public FutureCallable request(final int count, final char c) {
        System.out.printf(
            "    request(%d, %c) BEGIN \n", count, c);

        FutureCallable future = new FutureCallable(
            new Callable<RealData>() {
                public RealData call() {
                    return new RealData(count, c);
                }//call()
            }
        );

        new Thread(future).start();

        System.out.printf(
            "    request(%d, %c) END \n", count, c);

        return future;
    }//request()
}//class
