package multiThread.chap07MT.newHelper;

import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class HostNewHelper extends HostPerMess {

    public void request(final int count, final char c) {
        System.out.printf("\t request(%d, %s) BEGIN \n", count, c);

        new HelperThread(helper, count, c).start();

        System.out.printf("\t request(%d, %s) END \n", count, c);
    }//request()
}//class
