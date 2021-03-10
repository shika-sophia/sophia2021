package multiThread.chap07MT.executorInterface;

import java.util.concurrent.Executor;

import multiThread.chap07MT.threadPerMessage.HelperPerMess;
import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class HostIExecutor extends HostPerMess {
    private final HelperPerMess helper = new HelperPerMess();
    private final Executor executor;

    public HostIExecutor(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.printf("\t request(%d, %s) BEGIN \n", count, c);

        executor.execute(
            new Runnable() {
                public void run() {
                    helper.handle(count, c);
                }//run()
            }
        );

        System.out.printf("\t request(%d, %s) END \n", count, c);
    }//request()
}//class
