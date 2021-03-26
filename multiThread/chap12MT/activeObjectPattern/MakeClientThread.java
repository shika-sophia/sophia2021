package multiThread.chap12MT.activeObjectPattern;

import multiThread.chap12MT.activeObjectPattern.activeObject.AbsResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.ActObj;

public class MakeClientThread extends Thread {
    private final ActObj actObj;
    private final char fillchar;

    public MakeClientThread(String name, ActObj actObj) {
        super(name);
        this.actObj = actObj;
        this.fillchar = name.charAt(0);
    }

    public void run() {
        try {
            for(int i = 0; true; i++) {
                //Futureパターン: 戻り値のある呼び出し
                AbsResult<String> result = actObj.makeString(i, fillchar);
                Thread.sleep(10);
                String value = result.getResultValue();
                System.out.printf("%s: value = %s \n",
                    Thread.currentThread().getName(), value);
            }//for loop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
