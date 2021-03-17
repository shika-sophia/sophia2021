package multiThread.chap09MT.webReader;

import java.util.concurrent.Callable;

public class Retriever {
    public static AbsContent retrieve(String urlStr) {
        //---- ◇AsyncCallable / multiThread, FutureTask ----
        var future = new AsyncCallableImpl(
                new Callable<SyncContentImpl>() {
                   public SyncContentImpl call() {
                       return new SyncContentImpl(urlStr);
                   }//call
               }
           );

           new Thread(future).start();

           return future;

        //---- ◇AsyncContentImpl / multiThread ----
//        final AsyncContentImpl future = new AsyncContentImpl();
//
//        new Thread() {
//            public void run() {
//                future.setContent(new SyncContentImpl(urlStr));
//            }//run()
//        }.start();
//
//        return future;

        //---- ◇SyncContentImple ONLY / singleThread ----
        //return new SyncContentImpl(urlStr);
    }//retrieve()
}//class
