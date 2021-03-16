/**
 * @title multiThread / chap09MT / webReader / MainWebReader.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第９章 Futureパターン / 練習問題 9-3
 * @author shika
 * @date 2021-03-16
 */
package multiThread.chap09MT.webReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import multiThread.chap09MT.webReader.content.AbsContent;
import multiThread.chap09MT.webReader.content.Retriever;

public class MainWebReader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        AbsContent content1 = Retriever.retrieve("http://www.yahoo.com/");
        AbsContent content2 = Retriever.retrieve("http://www.google.com/");
        AbsContent content3 = Retriever.retrieve("http://www.hyuki.com/");

        saveToFile("multiThread/cho09MT/content/yahoo.html", content1);
        saveToFile("multiThread/cho09MT/content/google.html", content2);
        saveToFile("multiThread/cho09MT/content/hyuki.html", content3);

        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + " msec");
    }//main()

    private static void saveToFile(String fileName, AbsContent content) {
        byte[] byteAry = content.getByteAry();

        try (var out = new FileOutputStream(fileName)){
            System.out.printf(
                "%s: Saving to %s", Thread.currentThread().getName(), fileName);

            for(int i = 0; i < byteAry.length; i++) {
                out.write(byteAry[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//saveToFile

}//class

