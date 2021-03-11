package multiThread.chap07MT.blackholeMagic;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step1");
        magic(obj);
        System.out.println("Step2");

        synchronized (obj) {
            System.out.println("Step3 (never reached here)");
        }
    }//enter

    private synchronized static void magic(Object obj) {

    }//magic()
}//class
