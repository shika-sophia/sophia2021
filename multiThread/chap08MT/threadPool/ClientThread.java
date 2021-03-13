package multiThread.chap08MT.threadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

import multiThread.chap08MT.workerThread.RequestWork;

public class ClientThread extends Thread {
    private final ExecutorService exeService;
    private static Random random = new Random();

    public ClientThread(String name, ExecutorService exeService) {
        super(name);
        this.exeService = exeService;
    }

    public void run() {
        for(int i = 0; true; i++) {
            RequestWork request = new RequestPool(getName(), i);
            exeService.execute(request);
            try {
                Thread.sleep(random.nextInt(1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RejectedExecutionException e) {
                System.out.println(getName() + ": rejected.");
            }
        }//for loop
    }//run()
}//class
