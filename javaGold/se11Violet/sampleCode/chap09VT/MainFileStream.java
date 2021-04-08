/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainFileStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p397 / List 9-1
 * @content FileInputStream, FileOutputStream
 * @author shika
 * @date 2021-04-08
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainFileStream {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            //データの書き込み
            outStream = new FileOutputStream(new File(dir + "data.txt"));
            outStream.write(0);
            outStream.write("abc".getBytes());
            outStream.write(99);

            //データの読み込み
            inStream = new FileInputStream(new File(dir + "data.txt"));
            int data = 0;
            while((data = inStream.read()) != -1) {
                System.out.print(data + " ");
            }//while

        } catch (FileNotFoundException e) {
            System.err.println("ファイルが見つかりません。");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                inStream.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//main()

}//class

/*
//---- console ----
0 97 98 99 99

//---- data.txt ----
 abcc

【考察】
OutputStreamでファイルが存在しないと、新規作成。
write(0)は半角スペースに置換。
write(byte[])は そのまま元の文字列になる。
write(99)は charの 'c'を書き込み、読み込みは 99のまま。
read()で読み込むと文字列ではなく、charの Unicode? = 整数を読み込む。

◆System.err.println(): <-註: 「out」ではなく「err」
ファイルが見つかりません。(赤字でコンソール出力)
Exception in thread "main" java.lang.NullPointerException

*/