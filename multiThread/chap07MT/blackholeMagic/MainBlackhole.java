package multiThread.chap07MT.blackholeMagic;

public class MainBlackhole {

    public static void main(String[] args) {
        System.out.println("BEGIN");

        Object obj = new Object();
        Blackhole.enter(obj);

        System.out.println("END");
    }//main()

}//class
