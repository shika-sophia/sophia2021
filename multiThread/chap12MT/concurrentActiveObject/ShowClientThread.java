package multiThread.chap12MT.concurrentActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;

public class ShowClientThread extends Thread {
    private final IActObj actObj;

    public ShowClientThread(String name, IActObj actObj) {
        super(name);
        this.actObj = actObj;
    }

    public void run() {
        try {
            for(int i = 0; true; i++) {
                //戻り値のない呼出
                String str = Thread.currentThread().getName() + ": " + i;
                actObj.showStr(str);
                Thread.sleep(200);
            }//for loop

        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
