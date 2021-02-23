package multiThread.chap01MT.deadLock;

public class EaterThread extends Thread {
    private String eaterName;
    private MyTool left;
    private MyTool right;

    public EaterThread(String eaterName, MyTool left, MyTool right) {
        this.eaterName = eaterName;
        this.left = left;
        this.right = right;
    }

    public void run() {
        while(true) {
            eat();
        }
    }//run()

    public void eat() {
        synchronized(left) {
            System.out.println(eaterName + " takes up " + left + "(left)");

            synchronized(right) {
                System.out.println(eaterName + " takes up " + right + "(right)");
                System.out.println(eaterName + " is eating now.");
                System.out.println(eaterName + " put down " + right + "(right)");
            }//right
            System.out.println(eaterName + " put down " + left + "(left)");
        }//left
    }//eat()
}//class

