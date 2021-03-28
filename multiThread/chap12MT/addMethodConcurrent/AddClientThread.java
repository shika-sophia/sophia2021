package multiThread.chap12MT.addMethodConcurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import multiThread.chap12MT.concurrentActiveObject.IActObj;

public class AddClientThread extends Thread {
    private final IActObj actObj;
    private String x = "1";
    private String y = "1";

    public AddClientThread(String name, IActObj actObj) {
        super(name);
        this.actObj = actObj;
    }

    public void run() {
        try {
            while(true) {
                //戻り値のある呼出
                Future<String> future = actObj.add(x, y);
                Thread.sleep(100);
                String z = future.get();
                System.out.printf("%s: %s + %s = %s \n",
                        Thread.currentThread().getName(), x, y, z);
                x = y;
                y = z;
            }//while loop

        } catch (RejectedExecutionException e) {
            System.out.println(e.getClass());
        } catch (CancellationException e) {
            System.out.println(e.getClass());
        } catch (ExecutionException e) {
            System.out.println(e.getClass());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
