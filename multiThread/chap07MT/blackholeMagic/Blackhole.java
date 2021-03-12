package multiThread.chap07MT.blackholeMagic;

public class Blackhole {
    public void enter(Object obj) {
        System.out.println("Step1");
        magic(obj);
        System.out.println("Step2");

        synchronized (obj) {
            System.out.println("Step3 (never reached here)");
        }
    }//enter

    protected void magic(final Object obj) {
        //ここにコードを記述
    }
}//class
