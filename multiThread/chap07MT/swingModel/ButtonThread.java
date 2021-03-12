package multiThread.chap07MT.swingModel;

public class ButtonThread {

    public static void service() {
        new Thread() {
            public void run() {
                doService();
            }//run()
        }.start();
    }//service()

    private static void doService() {
        ButtonAction.service();
    }
}//class
