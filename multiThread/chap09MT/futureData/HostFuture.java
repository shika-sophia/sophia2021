package multiThread.chap09MT.futureData;

public class HostFuture {

    public AbsData request(final int count, final char c) {
        System.out.printf(
            "    request(%d, %c) BEGIN \n", count, c);

        //(1) FutureDataのインスタンス
        FutureData future = new FutureData();

        //(2) RealDataをつくるための 新しいThreadを起動
        new Thread() {
            public void run() {
                RealData real = new RealData(count, c);
                future.setRealData(real);
            }//run()
        }.start();
        System.out.printf(
            "    request(%d, %c) BEGIN \n", count, c);

        //(3)futureを戻り値として返す
        return future;
    }//request()
}//class
