package multiThread.chap07MT.swingModel;

import java.util.concurrent.ExecutorService;

public class ButtonAction {
    private final ExecutorService exeService;

    public ButtonAction(ExecutorService exeService) {
        this.exeService = exeService;
    }

    public void request() {
        exeService.execute(
            new Runnable() {
                public void run() {
                    service();
                }//run()
            }
        );
    }//request()

    public static void service() {
        System.out.print("service: ");

        for(int i = 0; i < 50; i++) {
            System.out.print(".");

            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for
        System.out.println("\n" + "done.");
    }//service()

}//class
