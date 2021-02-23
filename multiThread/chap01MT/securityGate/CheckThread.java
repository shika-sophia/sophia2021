package multiThread.chap01MT.securityGate;

public class CheckThread extends Thread {
    private final UnSecurityGate gate;

    public CheckThread(UnSecurityGate gate) {
        this.gate = gate;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            gate.enter();
            gate.exit();
        }
    }//run()

}//class
