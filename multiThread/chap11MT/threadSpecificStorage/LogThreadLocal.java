package multiThread.chap11MT.threadSpecificStorage;

public class LogThreadLocal {
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
        }

        return logTs;
    }//getLog()

}//class

