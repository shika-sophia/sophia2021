/**
 * @title utility / ioFileDiv / WriteFile.java
 * @content pathを指定し、そのファイルに書き込み
 * @reference 結城浩『Java言語プログラミングレッスン(下)』SB Creative,2012 / p237
 * @author shika
 * @date 2021-01-26
 */
package utility.ioFileDiv;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile extends ReadFile {

    public WriteFile() { }

    public WriteFile(String path, String writeText) {
        writePathFile(path, writeText);
    }

    public void writePathFile(String path, String writeText) {
        //書き込む前に現ファイルのバックアップ
        //readText = readPathFile(path);

        try(PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(path)))){
            //writer.println(readText);
            writer.println(writeText);

        } catch(FileNotFoundException e) {
            System.out.println(path + "が見つかりません。");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }//writePathFile()

}//class
