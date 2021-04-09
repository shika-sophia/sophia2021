/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainFileAttribute.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p434 / List 9-24, 9-25
 * @content Files.getAttribute(), getAttributes()
 * @content java.nio.file.attribute
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class MainFileAttribute {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        Path path1 = Paths.get(dir + "data.txt");

        try {
            Object creationTime = Files.getAttribute(path1, "creationTime");
            Object lastModifiedTime = Files.getAttribute(path1, "lastModifiedTime");
            Object fileSize = Files.getAttribute(path1, "size");
            System.out.println("creationTime: " + creationTime);
            System.out.println("lastModifiedTime: " + lastModifiedTime);
            System.out.println("fileSize: " + fileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        Path path2 = Paths.get(dir + "MainFileStream.java");
        try {
            BasicFileAttributes attr =
                Files.readAttributes(path2, BasicFileAttributes.class);

            System.out.println("creation: " + attr.creationTime());
            System.out.println("modified: " + attr.lastModifiedTime());
            System.out.println("access: " + attr.lastAccessTime());
            System.out.println("fileKey: " + attr.fileKey());
            System.out.println("fileSize: " + attr.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- Files.getAtribute(Path, String) ----
creationTime: 2021-04-09T00:03:13.280662Z
lastModifiedTime: 2021-04-08T05:42:03.670741Z
fileSize: 10

//---- Files.getAtributes(Path, BasicFileAttributes) ----

creation: 2021-04-08T04:40:31.635637Z
modified: 2021-04-08T05:26:36.716756Z
access: 2021-04-09T00:04:40.276531Z
fileKey: null
fileSize: 2298

 */
