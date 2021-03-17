package multiThread.chap09MT.setException;

import java.util.concurrent.Callable;

import multiThread.chap09MT.futureData.RealData;

public class HostException {

    public AbsData request(final int count, final char c) {
        System.out.printf(
            "    request(%d, %c) BEGIN \n", count, c);

        //(1) FutureDataのインスタンス
        //---- FutureDataException ----
        //final FutureDataException future = new FutureDataException();

        //---- FutureCallableException ----
        final FutureCallableException future = new FutureCallableException(
            new Callable<RealData>() {
                public RealData call() {
                    return new RealData(count, c);
                }//call()
            }
        );

        //(2) RealDataをつくるための 新しいThreadを起動
        //----FutureDataException ----
//        new Thread() {
//            public void run() {
//                try {
//                    RealData real = new RealData(count, c);
//                    future.setRealData(real);
//                } catch (Exception e) {
//                    future.setException(e);
//                }
//            }//run()
//        }.start();

        //---- FutureCallableException ----
        new Thread(future).start();


        System.out.printf(
            "    request(%d, %c) BEGIN \n", count, c);

        //(3)futureを戻り値として返す
        return future;
    }//request()
}//class
