package multiThread.chap12MT.activeObjectPattern;

import multiThread.chap12MT.activeObjectPattern.activeObject.ActObj;

public class ShowClientThread extends Thread {
    private final ActObj actObj;

    public ShowClientThread(String name, ActObj actObj) {
        super(name);
        this.actObj = actObj;
    }

    public void run() {
        try {
            for(int i = 0; true; i++) {
                String str = Thread.currentThread().getName() + ": " + i;
                //戻り値のない呼び出し
                actObj.showString(str);
                Thread.sleep(200);
            }//for loop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
