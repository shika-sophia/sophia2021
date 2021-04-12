/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainSerialNormal.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / List 9-9
 * @content Serializableの継承。
 *          Serializableの実装するクラスによって結果に変化があるプログラム。
 * @see List 9-8 / MainSerialExtends.java
 * @author shika
 * @date 2021-04-12
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperNomal {
    int a;
    public SuperNomal() {
        a = 10;
        System.out.println("SuperNormal");
    }
}//class SuperSerial

class SubSerial extends SuperNomal implements Serializable {
    int b;
    public SubSerial() {
        b = 10;
        System.out.println("SubSerial");
    }
}//class SubNormal

public class MainSerialNormal {

    public static void main(String[] args) {
        SubSerial sub = new SubSerial();
        sub.a = 100;
        sub.b = 100;

        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        try(ObjectOutputStream outStream =
                new ObjectOutputStream(
                    new FileOutputStream(dir + "dataSerial.txt"));
            ObjectInputStream inStream =
                new ObjectInputStream(
                    new FileInputStream(dir + "dataSerial.txt"));){
            //Serialize and write to file
            outStream.writeObject(sub);

            //Desreialize and read from file
            SubSerial subRead = (SubSerial) inStream.readObject();
            System.out.println("subRead.a = " + subRead.a);
            System.out.println("subRead.b = " + subRead.b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- MainSerialExtends ----
SuperSerial
SubNormal
subRead.a = 100
subRead.b = 100

//---- MainSerialNormal ----
SuperNormal
SubSerial
SuperNormal <- デシリアライズ時に superを再インスタンス
subRead.a = 10 <- 上記の再インスタンスにより、フィールドは superで再初期化
subRead.b = 100

*/