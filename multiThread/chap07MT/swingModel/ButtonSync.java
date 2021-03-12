package multiThread.chap07MT.swingModel;

public class ButtonSync {
    public static void service() {
        new Thread() {
            public void run() {
                doService();
            }//run()
        }.start();
    }//service()

    private synchronized static void doService() {
        ButtonAction.service();
    }
}//class

