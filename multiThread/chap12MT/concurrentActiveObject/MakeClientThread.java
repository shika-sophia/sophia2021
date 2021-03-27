package multiThread.chap12MT.concurrentActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class MakeClientThread extends Thread {
    private final IActObj actObj;
    private final char fillchar;

    public MakeClientThread(String name, IActObj actObj) {
        super(name);
        this.actObj = actObj;
        this.fillchar = name.charAt(0);
    }

    public void run() {
        try {
            for(int i = 0; true; i++) {
                //戻り値のある呼出
                Future<String> future = actObj.makeStr(i, fillchar);

                Thread.sleep(10);
                String realResult = future.get();
                System.out.printf("%s: realResult = %s \n",
                    Thread.currentThread().getName(), realResult);
            }//for loop

        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
