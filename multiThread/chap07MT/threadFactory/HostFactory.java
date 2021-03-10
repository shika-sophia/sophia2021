package multiThread.chap07MT.threadFactory;

import java.util.concurrent.ThreadFactory;

import multiThread.chap07MT.threadPerMessage.HelperPerMess;
import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class HostFactory extends HostPerMess {
    private final HelperPerMess helper = new HelperPerMess();
    private final ThreadFactory factory;

    public HostFactory(ThreadFactory factory) {
        this.factory = factory;
    }

    public void request(final int count, final char c) {
        System.out.printf("\t request(%d, %s) BEGIN \n", count, c);

        factory.newThread(
            new Runnable() {
                public void run() {
                    helper.handle(count, c);
                }//run()
            }
        ).start();

        System.out.printf("\t request(%d, %s) END \n", count, c);
    }//request()
}//class
