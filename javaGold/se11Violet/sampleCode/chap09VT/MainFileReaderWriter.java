/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainMainFileReaderWriter.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p402 / List 9-4
 * @content FileReader, FileWriter
 * @author shika
 * @date 2021-04-08
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainFileReaderWriter {
    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        try(var writer = new FileWriter(new File(dir + "data3.txt"));
            var reader = new FileReader(new File(dir + "data3.txt")); ) {

            writer.write("田中");
            writer.flush();

            int data = 0;
            while((data = reader.read()) != 0) {
                System.out.print((char)data + " ");
            }//while
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- console ----
田 中

//---- data3.txt ----
田中

【考察】 FileReader / FileWriter
char単位で読み書きする キャラクターストリーム。
入出力の文字コードは自動的に UTF-8に変換される。
-> OS依存コードを気にせず、日本語を書き込める。
*/