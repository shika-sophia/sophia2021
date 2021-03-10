package multiThread.chap07MT.threadPerMessage;

public class HelperPerMess {

    public void handle(int count, char c) {
        System.out.printf("\t handle(%d, %s) BEGIN \n", count, c);

        for(int i = 0; i < count; i++) {
            slowly(100L);
            System.out.print(c);
        }
        System.out.println();
        System.out.printf("\t handle(%d, %s) END \n", count, c);
    }//handle()

    private void slowly(long rest) {
        try {
            Thread.sleep(rest);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//slowly
}//class
