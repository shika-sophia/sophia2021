/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainDataStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p405 / List 9-6
 * @content DataInputStream, DataOutputStream
 * @author shika
 * @date 2021-04-08
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainBuffered {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        try(var buffer = new BufferedReader(
                new FileReader(dir + "data4.txt"))){
            System.out.println(buffer.readLine());
            buffer.mark(256);
            System.out.println(buffer.readLine());
            System.out.println(buffer.readLine());
            buffer.reset();

            System.out.println(buffer.readLine());
            buffer.skip(2);
            System.out.println(buffer.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
orange
apple
banana
apple  <- mark(), reset()で appleから読み込み開始
nana   <- skip(2)により 最初の２文字を skip。
*/