package multiThread.chap07MT.newHelper;

import multiThread.chap07MT.threadPerMessage.HelperPerMess;

public class HelperThread extends Thread {
    private final HelperPerMess helper = new HelperPerMess();
    private final int count;
    private final char c;

    public HelperThread(int count, char c) {
        this.count = count;
        this.c = c;
    }

    public void run() {
        helper.handle(count, c);
    }//run()
}//class
