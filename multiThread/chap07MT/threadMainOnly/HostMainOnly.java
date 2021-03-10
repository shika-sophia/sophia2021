package multiThread.chap07MT.threadMainOnly;

import multiThread.chap07MT.threadPerMessage.HelperPerMess;
import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class HostMainOnly extends HostPerMess {
    private final HelperPerMess helper = new HelperPerMess();

    public void request(final int count, final char c) {
        System.out.printf("\t request(%d, %s) BEGIN \n", count, c);

//        new Thread() {
//            public void run() {
                helper.handle(count, c);
//            }//run()
//        }.start();

        System.out.printf("\t request(%d, %s) END \n", count, c);
    }//request()
}//class
