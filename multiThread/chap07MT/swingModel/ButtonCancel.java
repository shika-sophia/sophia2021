package multiThread.chap07MT.swingModel;

public class ButtonCancel {
    private static Thread worker = null;

    public static synchronized void service() {
        //実行中の処理があったら interrupt()でキャンセル
        if(worker != null && worker.isAlive()) {
            worker.interrupt();

            try {
                worker.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            worker = null;
        }//if

        System.out.println("ButtonCancel.service()");
        worker = new Thread() {
            public void run() {
                doService();
            }//run()
        };
        worker.start();
    }//service()

    private static void doService() {
        try {
            for(int i = 0; i < 50; i++) {
                System.out.print(".");
                Thread.sleep(100);
            }//for
            System.out.println("done.");

        } catch (InterruptedException e) {
            System.out.println(" cancelled.");
        }
    }//doService()
}//class
