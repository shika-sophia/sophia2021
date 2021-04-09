/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainFilesBoolean.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p432 / List 9-20
 * @content Files.exists(),
 * 			isDirectory(), isRegularFile(), isReadable()
 *          isSameFile()
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFilesBoolean {
    public static void main(String[] args) {
       String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
       Path path1 = Paths.get(dir + "data.txt"); //sophia2021からの相対path
       Path path2 = Paths.get(                   //C:からの絶対path
           "C:/Program Files/pleiades/workspace-web/sophia2021/"
           + dir + "data.txt");

       System.out.format("exists(): %b%n", Files.exists(path1));
       System.out.format("isDirectory(): %b%n", Files.isDirectory(path1));
       System.out.format("isRegularFile(): %b%n", Files.isRegularFile(path1));
       System.out.format("isReadable(): %b%n", Files.isReadable(path1));

       try {
           //isSameFile(): 相対pathと 絶対pathを比較 -> 同一ファイルかを評価
           System.out.format("isSameFile(): %b%n", Files.isSameFile(path1, path2));

           //Path と Fileの互換
           File file1 = path1.toFile();
           Path path3 = file1.toPath();
           System.out.format("isSameFile(): %b%n", Files.isSameFile(path1, path3));

       } catch (IOException e) {
           e.printStackTrace();
       }
   }//main()
}//class

/*
exists(): true
isDirectory(): false
isRegularFile(): true
isReadable(): true
isSameFile(): true
isSameFile(): true
*/