/**
 * @see SingleThreadedExecution
 */

package multiThread.chap01MT.singleThreadedExecution;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }//pass

    @Override
    public synchronized String toString() {
        return String.format(
            "No.%d: %s, %s",counter, name, address);
    }//toString()

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("###### BROKEN ###### " + toString());
        }
    }//check()

}//class

