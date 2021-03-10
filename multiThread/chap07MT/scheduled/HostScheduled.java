package multiThread.chap07MT.scheduled;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import multiThread.chap07MT.threadPerMessage.HelperPerMess;
import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class HostScheduled extends HostPerMess {
    private final HelperPerMess helper = new HelperPerMess();
    private final ScheduledExecutorService scheduled;

    public HostScheduled(ScheduledExecutorService scheduled) {
        this.scheduled = scheduled;
    }


    public void request(final int count, final char c) {
        System.out.printf("\t request(%d, %s) BEGIN \n", count, c);

        scheduled.schedule(
            new Runnable() {
                public void run() {
                    helper.handle(count, c);
                }//run()
            },
            3L,
            TimeUnit.SECONDS
        );

        System.out.printf("\t request(%d, %s) END \n", count, c);
    }//request()
}//class
