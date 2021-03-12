package multiThread.chap07MT.blackholeMagic;

public class BlackholeJoin extends Blackhole {
    //====== threadはロックを取ってから、自分自身の終了を永遠に待つ ======
    @Override
    public void magic(final Object obj) {
        Thread thread = new Thread() {
            public void run() {
                synchronized(obj) {
                    synchronized(this) {
                        this.notifyAll();
                    }//this

                    try {
                        this.join();

                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }//obj
            }//run()
        };//Thread()

        synchronized (thread) {
            thread.start();

            try {
                thread.wait(); //新しいスレッドがロックを取るのを待つ

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//thread
    }//magic
}//class
