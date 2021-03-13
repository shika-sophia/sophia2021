package multiThread.chap08MT.workerThread;

import java.util.Random;

public class RequestWork {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public RequestWork(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(
            Thread.currentThread().getName() + " executes " + this);

        try {
            Thread.sleep(random.nextInt(1000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//execute()

    public String toString() {
        return String.format(
                "[Request from %s No.%d]", name, number);
    }//toString()
}//class
