package multiThread.chap09MT.webReader;

public class Retriever {
    public static AbsContent retrieve(String urlStr) {
        //---- AsyncContentImpl / multiThread ----
//        final AsyncContentImpl future = new AsyncContentImpl();
//
//        new Thread() {
//            public void run() {
//                future.setContent(new SyncContentImpl(urlStr));
//            }//run()
//        }.start();
//
//        return future;

        //---- SyncContentImple ONLY / singleThread ----
        return new SyncContentImpl(urlStr);
    }//retrieve()
}//class
