/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainFindSearch.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p441 / List 9-30, 9-31
 * @content Files.list(): 対象のディレクトリのみ
 *          Files.find(): 条件検索
 * @see MainWalkSearch.java
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class MainFindSearch {

    public static void main(String[] args) {
        //---- Files.list() ----
        Path path1 = Paths.get("src/javaGold");
        try {
            Files.list(path1).forEach(System.out::println);
            System.out.println("------------");

            Files.list(path1)
            .filter(path -> !Files.isDirectory(path))
            .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //---- Files.find() ----
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        Path path2 = Paths.get(dir + "MainFilesBoolean.java");
        Path dirPath = Paths.get(dir);

        try {
            BasicFileAttributes attr = Files.readAttributes(path2, BasicFileAttributes.class);
            FileTime creationTime = attr.creationTime();
            long creationLong = creationTime.toMillis();
            System.out.println("creationTime: " + creationTime);
            System.out.println("creationLong: " + creationLong);

            Files.find(dirPath, 10, (file, attr2) ->
                file.toString().endsWith(".jpg")
                && attr2.creationTime().toMillis() > creationLong
            ).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main()

}//class

/*
//---- Files.list() ----
src\javaGold\AnswerEditor.java
src\javaGold\IAnsNeedInstance.java
src\javaGold\javaGoldAnalysis.txt
src\javaGold\PracticeEditor.java
src\javaGold\se11Silver
src\javaGold\se11Violet
src\javaGold\se11White
src\javaGold\selfLearn
src\javaGold\streamAnalysis.txt
src\javaGold\testExamin
------------
src\javaGold\AnswerEditor.java
src\javaGold\IAnsNeedInstance.java
src\javaGold\javaGoldAnalysis.txt
src\javaGold\PracticeEditor.java
src\javaGold\streamAnalysis.txt

//---- Files.find() ----
検索ディレクトリ: src / javaGold / se11Violet / sampleCode / chap09VT
検索条件: MainFilesBoolean 作成以後 && 末尾「.jpg」
creationTime: 2021-04-08T22:29:45.28981Z
creationLong: 1617920985289
src\javaGold\se11Violet\sampleCode\chap09VT\dataDir\imageMainDirectory.jpg
*/