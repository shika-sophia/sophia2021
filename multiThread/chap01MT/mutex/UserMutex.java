package multiThread.chap01MT.mutex;

public class UserMutex extends Thread {
    private final GateMutex gate;
    private final String myName;
    private final String myAddress;

    public UserMutex(GateMutex gate, String myName, String myAddress) {
        this.gate = gate;
        this.myName = myName;
        this.myAddress = myAddress;
    }

    public void run() {
        System.out.println(myName + "BEGIN");
        while(true) {
            try {
                gate.pass(myName, myAddress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//run()
}//class

