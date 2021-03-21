package multiThread.chap10MT.swingExeCancel;

import java.util.stream.Stream;

public class ServiceSW {
    private static final int MAX = 50;
    private static ServiceSWThread th;

    public static void service() {
        System.out.print("Service");

        var actService = new Runnable() {
            public void run() {
                Stream.generate(() -> ".").limit(MAX)
                .peek(s -> {
                    if(isCancel()) {
                        th.interrupt();
                    }
                })
                .peek(s -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(System.out::print);
            }//run()
        };

        th = new ServiceSWThread(actService);
        th.start();

        System.out.println("done/");
    }//service()

    protected static boolean isCancel() {
        return th.isCancelRequest();
    }

    public static void cancel() {
        th.setCancelRequest();
    }//cancel()
}//class

/*
//###### multiThread / chap10MT / swingExeCancel / ServiceSW.java ######
Stream.generate(() -> ".").limit(MAX)
    .peek(s -> {
        if(isCancel()) {
            th.interrupt();
        }
    })
    .peek(s -> {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    })
    .forEach(System.out::print);
【結果】
Service..................................................done/
【考察】
この Stream処理は ちゃんと実行されるが Runnable.run()内に入れると
    Servicedone/
という結果になる。interrupt()されていないことは確認済。
Stream処理そのものがスキップされている感じ。
*/