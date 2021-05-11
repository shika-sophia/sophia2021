package javaGold.se11Violet.sampleCode.chap08vtMultiThread.forkJoinTask;

import java.util.concurrent.RecursiveAction;

public class MyAction extends RecursiveAction {

    @Override
    protected void compute() {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyAction: OK");
    }//compute()

}//class
