package multiThread.chap07MT.blackholeMagic;

public class BlackholeWait extends Blackhole {

    //====== ロックを取って無限ループするスレッド ======
    //Threadの名前を ガード条件として使う
    @Override
    public void magic(final Object obj) {
        Thread thread = new Thread() {
            public void run() {
                //objのロックを取る
                synchronized(obj) {
                    synchronized(this) {
                        //ロックを取ったのでガード条件を変更
                        this.setName("Locked");
                        //objのロックを取ったことを通知
                        this.notifyAll();
                    }//this

                    //objロックのスレッドは無限ループで返さない
                    while(true) { }
                }//obj
            }//run()
        };//Thread()

        synchronized(thread) {
            thread.setName("");
            thread.start();

            //GuardedSuspesion Pattern
            while(thread.getName().equals("")) {
                try {
                    thread.wait(); //新しいスレッドがロックを取るのを待つ

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }//sybchronized thread
    }//magic()
}//class
