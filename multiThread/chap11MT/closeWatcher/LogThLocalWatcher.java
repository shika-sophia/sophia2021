package multiThread.chap11MT.closeWatcher;

import multiThread.chap11MT.threadSpecificStorage.LogTS;

public class LogThLocalWatcher {
    private static final ThreadLocal<LogTS>
        logCollection = new ThreadLocal<LogTS>();

    //ログを書く
    public static void printLog(String str) {
        getLog().printLog(str);
    }

    //ログを閉じる
    public static void close() {
        getLog().close();
    }

    //スレッド固有のログを取得
    private static LogTS getLog() {
        LogTS logTs = logCollection.get();

        //スレッド呼び出しが初めてなら新規作成
        if (logTs == null) {
            logTs = new LogTS(
                Thread.currentThread().getName() + "_log.txt"); //fileName
            logCollection.set(logTs);
            startWatcher(logTs);
        }

        return logTs;
    }//getLog()

    //スレッドの終了を待つ Watcherスレッドを起動する
    private static void startWatcher(LogTS logTs) {
        //終了を監視されるほうのスレッド
        final Thread target = Thread.currentThread();

        //Watcherスレッド
        final Thread watcher = new Thread(() -> {
            System.out.println("startWatcher() for " + target.getName() + ": BEGIN");

            try {
                target.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logTs.close();
            System.out.println("startWatcher() for " + target.getName() + ": END");
        });//watcher

        watcher.start();
    }//startWatcher()

}//class

