
package multiThread.chap11MT.nonSpecificStrorage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogNonTS {
    private static PrintWriter writer = null;
    private static String path;

    static {
        path = "src/multiThread/chap11MT/nonSpecificStrorage/logNonTS.txt";

        try {
            writer = new PrintWriter(new FileWriter(path));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//static initalizer

    //ログを書く
    public static void printLog(String str) {
        writer.println(str);
    }

    //ログを閉じる
    public static void close() {
        writer.println("==== End of Log ====");
        writer.close();
    }
}//class

