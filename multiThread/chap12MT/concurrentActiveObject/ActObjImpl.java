package multiThread.chap12MT.concurrentActiveObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//IActObjインターフェイスの実装クラス
public class ActObjImpl implements IActObj {
    private final ExecutorService exeService =
            Executors.newSingleThreadExecutor();

    //====== 戻り値のある呼出 ======
    @Override
    public Future<String> makeStr(final int count, final char fillchar) {
        //リクエストの定義
        class MakeRequest implements Callable<String> {
            public String call() {
                char[] buffer = new char[count];

                for(int i = 0; i < count; i++) {
                    buffer[i] = fillchar;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//for

                return new String(buffer);
            }//call()
        }//class MakeRequest

        //リクエストの発行
        return exeService.submit(new MakeRequest());
    }//makeStr()

    //====== 戻り値のない呼出 ======
    @Override
    public void showStr(final String str) {
        //リクエストの定義
        class ShowRequest implements Runnable {
            public void run() {
                System.out.println("showStr(): " + str);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//run()
        }//class ShowRequest

        //リクエストの発行
        exeService.execute(new ShowRequest());
    }//showStr()

    @Override
    public void shutdown() {
        exeService.shutdown();
    }//shutdown()

}//class
