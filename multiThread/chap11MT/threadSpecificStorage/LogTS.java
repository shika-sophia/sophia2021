package multiThread.chap11MT.threadSpecificStorage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogTS {
    private PrintWriter writer = null;

    public LogTS(String fileName) {
        String path = "src/multiThread/chap11MT/threadSpecificStorage/" + fileName;

        try {
            this.writer = new PrintWriter(new FileWriter(path));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//constructor

    //ログを書く
    public void printLog(String str) {
        writer.println(str);
    }

    //ログを閉じる
    public void close() {
        writer.println("==== End of Log ====");
        writer.close();
    }
}//class
