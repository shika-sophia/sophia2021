package javaGold.se11Violet.sampleCode.chap08vtMultiThread.forkJoinTask;

import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {
        System.out.println("MyTask: Begin");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyTask: OK");
        return 1;
    }//compute()

}
