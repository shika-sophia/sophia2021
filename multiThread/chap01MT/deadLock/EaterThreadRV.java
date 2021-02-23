package multiThread.chap01MT.deadLock;

public class EaterThreadRV extends Thread {
    private String eaterName;
    private MyTool left;
    private MyTool right;

    public EaterThreadRV(String eaterName, MyTool left, MyTool right) {
        this.eaterName = eaterName;
        this.left = left;
        this.right = right;
    }

    public void run() {
        while(true) {
            eat();
        }
    }//run()

    public synchronized void eat() {
        System.out.println(eaterName + " takes up " + left + "(left)");
        System.out.println(eaterName + " takes up " + right + "(right)");
        System.out.println(eaterName + " is eating now.");
        System.out.println(eaterName + " put down " + right + "(right)");
        System.out.println(eaterName + " put down " + left + "(left)");
    }//eat()
}//class
