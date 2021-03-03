package multiThread.chap05MT.producerConsumer;

import java.util.Random;

public class MakerThread extends Thread {
    private final Random random;
    private final CakeTable table;
    private static int id = 0;

    public MakerThread(String name, CakeTable table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(random.nextInt(1000));
                String cake =
                    "[Cake No." + nextId() + " by " + getName() + "]";
                table.put(cake);
            }//while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()

    private static synchronized int nextId() {
        return id++;
    }//nextId()

}//class
