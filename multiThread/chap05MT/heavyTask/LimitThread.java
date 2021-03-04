package multiThread.chap05MT.heavyTask;

public class LimitThread extends Thread {
    private final Thread thHeavy;

    public LimitThread(Thread thHeavy) {
        super("LimitThread");
        this.thHeavy = thHeavy;
    }

    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thHeavy.interrupt();
    }//run()
}//class
