package multiThread.chap10MT.swingExeCancel;

import multiThread.chap10MT.gracefulThread.GracefulThread;

public class ServiceAns {
    private static GracefulThread thread = null;

    //サービス実行開始(実行中なら Balkingする)
    public synchronized static void service() {
        System.out.print("Service");

        if(thread != null && thread.isAlive()) {
            //Balking
            System.out.println(" is balked.");
            return;
        }

        //Thread-Per-Message
        thread = new ServiceAnsThread();
        thread.start();
    }//service()

    //サービス中止
    public synchronized static void cancel() {
        if(thread != null) {
            System.out.println(" cancel.");
            thread.shutdownRequest();
        }
    }//cancel()
}//class
