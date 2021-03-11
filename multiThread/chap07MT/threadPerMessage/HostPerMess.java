package multiThread.chap07MT.threadPerMessage;

public class HostPerMess {
    protected final HelperPerMess helper = new HelperPerMess();

    public void request(final int count, final char c) {
        System.out.printf("\t request(%d, %s) BEGIN \n", count, c);

        new Thread() {
            public void run() {
                helper.handle(count, c);
            }//run()
        }.start();

        System.out.printf("\t request(%d, %s) END \n", count, c);
    }//request()
}//class
