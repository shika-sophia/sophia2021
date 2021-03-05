package multiThread.chap05MT.heavyTask;

public class HeavyHost {
    public static void execute(int count)
            throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if(Thread.interrupted()) {
                throw new InterruptedException();
            }

            doHeavyJob();
        }//for
    }//execute()

    private static void doHeavyJob() {
        //重い処理(10秒間のループ)
        System.out.println("doHeavyJob() BEGIN");
        long start = System.currentTimeMillis();

        while(start + 10000 > System.currentTimeMillis()) {
            //busy loop
        }//while
        System.out.println("doHeavyJob() END");
    }//doHeavyJob
}//class
