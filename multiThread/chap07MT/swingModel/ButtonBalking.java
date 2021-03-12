package multiThread.chap07MT.swingModel;

public class ButtonBalking {
    private static volatile boolean working = false;

    public static synchronized void service() {
        System.out.println("ButtonBalking.service()");

        if(working) {
            System.out.println(" is balked.");
            return;
        }
        working = true;
        new Thread() {
            public void run() {
                doService();
            }//run()
        }.start();

    }//service()

    private static void doService() {
        try {
            ButtonAction.service();
        } finally {
            working = false;
        }
    }//doService()
}//class
