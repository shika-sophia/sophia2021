/**
 * @title javaGoF / chap13Visitor / MainVisitor.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第13章 Visitor / List 13-1 ～ 13-8
 * @content データ構造と処理の分離。entryElementは Composite改。
 *          Compositeの printList()の処理を
 *          Directory.accept() -> ShowVisitor.visit()で行う
 *
 * @class MainVisitor / ◆main()
 *
 * @package ---- entryElement ----
 * @interface IElementVisit / abstract accept(Visitor)
 * @class AbsEntryVisit implements IElementVisit
 *        / abstract getName(), getSize()
 *        add(){ throw } , iterator(){ throw }, toString() ||Template||
 * @class FileTreatException extends RuntimeException
 * @class FileVisit extends AbsEntryVisit
 *        / String name, int size /
 *        getName(), getSize(), accept()
 * @class DirectoryVisit extends AbsEntryVisit
 *        / String name, List<AbsEntryVisit> entryList /
 *        getName(), getSize(), add(), iterator(), accept()
 *
 * @package ---- visitor ----
 * @class AbsVisitor
 *        / abstract visit(File), visit(Directory)
 * @class ShowVisitor
 *        / String currentDir /
 *        visit(File), visit(Directory)
 *
 * @author shika
 * @date 2021-06-11
 */
package javaGoF.chap13Visitor;

import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileTreatException;
import javaGoF.chap13Visitor.entryElement.FileVisit;
import javaGoF.chap13Visitor.visitor.ShowVisitor;

public class MainVisitor {

    public static void main(String[] args) {
         try {
             System.out.println("Making root entry...");
             var rootDir = new DirectoryVisit("root");
             var binDir = new DirectoryVisit("bin");
             var tempDir = new DirectoryVisit("temp");
             var userDir = new DirectoryVisit("user");
             rootDir.add(binDir);
             rootDir.add(tempDir);
             rootDir.add(userDir);
             binDir.add(new FileVisit("vi", 10000));
             binDir.add(new FileVisit("latex", 20000));
             rootDir.accept(new ShowVisitor());
             System.out.println();

             System.out.println("Making user entry...");
             var yuki = new DirectoryVisit("yuki");
             var hanako = new DirectoryVisit("hanako");
             var taro = new DirectoryVisit("taro");
             userDir.add(yuki);
             userDir.add(hanako);
             userDir.add(taro);
             yuki.add(new FileVisit("JavaGoF.java", 100));
             yuki.add(new FileVisit("MultiThread.java", 200));
             hanako.add(new FileVisit("diary.txt", 300));
             taro.add(new FileVisit("game.txt", 400));
             taro.add(new FileVisit("gameMemo.html", 500));
             rootDir.accept(new ShowVisitor());

         } catch (FileTreatException e) {
             e.printStackTrace();
         }
    }//main()

}//class

/*
Making root entry...
/root (30000)
/root/bin (30000)
/root/bin/vi (10000)
/root/bin/latex (20000)
/root/temp (0)
/root/user (0)

Making user entry...
/root (31500)
/root/bin (30000)
/root/bin/vi (10000)
/root/bin/latex (20000)
/root/temp (0)
/root/user (1500)
/root/user/yuki (300)
/root/user/yuki/JavaGoF.java (100)
/root/user/yuki/MultiThread.java (200)
/root/user/hanako (300)
/root/user/hanako/diary.txt (300)
/root/user/taro (900)
/root/user/taro/game.txt (400)
/root/user/taro/gameMemo.html (500)

*/