/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainDataStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p401 / List 9-3
 * @content DataInputStream, DataOutputStream
 * @author shika
 * @date 2021-04-08
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainDataStream {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        try (var dos = new DataOutputStream(
                new FileOutputStream(dir + "data2.txt"));
             var dis = new DataInputStream(
                new FileInputStream(dir + "data2.txt"));
        ) {
            dos.writeInt(100);
            //dos.writeBytes("Tanka");
            dos.writeUTF("Tanka");
            dos.writeUTF("田中");

            System.out.println(dis.readInt());
            //System.out.println(dis.readByte());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- console ----
100
Tanka
田中

//---- data2.txt ----
d ?Tanaka 田中

【考察】
＊writeBytes()でも 英数字は書き込めるけど readByte()で読み込めない。

＊Tanakaの文字列の前に「?マークの付いた変換不能みたいな表示」が data2.txtのほうにはある。

＊readByte()時の例外表示
100
0
java.io.EOFException
    at java.base/java.io.DataInputStream.readFully(DataInputStream.java:202)
    at java.base/java.io.DataInputStream.readUTF(DataInputStream.java:614)
    at java.base/java.io.DataInputStream.readUTF(DataInputStream.java:569)
    at javaGold.se11Violet.sampleCode.chap09VT.MainDataStream.main(MainDataStream.java:34)

 */
