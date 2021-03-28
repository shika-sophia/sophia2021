package multiThread.chap12MT.addMethod;

import multiThread.chap12MT.activeObjectPattern.activeObject.AbsResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.ActObj;

public class AddClientThread extends Thread {
    private final ActObj actObj;
    private String x = "1";
    private String y = "1";

    public AddClientThread(String name, ActObj actObj) {
        super(name);
        this.actObj = actObj;
    }

    public void run() {
        try {
            while(true) {
                //戻り値のある呼出
                AbsResult<String> result = actObj.add(x, y);
                Thread.sleep(100);
                String z = result.getResultValue();
                System.out.printf("%s: %s + %s = %s \n",
                    Thread.currentThread().getName(), x, y, z);
                x = y;
                y = z;
            }//while loop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
