/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainObjectStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / List 9-7
 * @content ObjectInputStream / ObjectOutputStream
 * 			シリアライズ、デシリアライズを用いた読み書き
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

class Employee implements Serializable {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}//class Employee

public class MainObjectStream {

    public static void main(String[] args) {
        Employee emp = new Employee(100, "Tanaka");

        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        try(ObjectOutputStream outStream =
                new ObjectOutputStream(
                    new FileOutputStream(dir + "dataObj.txt"));
            ObjectInputStream inStream =
                new ObjectInputStream(
                    new FileInputStream(dir + "dataObj.txt"));){
            //Serialize and write to file
            outStream.writeObject(emp);

            //Deserialize and read from file
            Employee empRead = (Employee) inStream.readObject();
            System.out.println("ID: " + empRead.getId());
            System.out.println("name: " + empRead.getName());

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
//---- console ----
ID: 100
name: Tanaka

//---- dataObj.txt ----
(文字化け) 原因: ObjectOutputStream, FileOutputStramは バイナリーストリーム
?? ? sr 0javaGold.se11Violet.sampleCode.
chap09VT.Employee?=?a??ka ?I ?idL ?namet
?Ljava/lang/String;xp  dt?Tanaka
 */

