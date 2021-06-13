/**
 * @title javaGoF / chap13Visitor / MainVisitor.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第13章 Visitor / List 13-1 ～ 13-8, 練習問題
 * @content データ構造と処理の分離。entryElementは Composite改。
 *          Compositeの printList()の処理を
 *          Directory.accept() -> ShowVisitor.visit()で行う
 * @content 練習問題 13-1
 *          FindVisitorを追加。検索語を含むファイルを抽出。
 * @content 練習問題 13-2
 *          FileSizeVisitorを追加。
 *          各Entryのサイズを Mapに(name,size)と格納。検索可能にする。
 * @content 練習問題 13-3
 *          ElemementList extends IElementVisit を追加。
 *            add(AbsEntryVisit), accept(AbsVisitor)機能
 *          AbsVisitorに visit(AbsEntryVisit)を追加。
 *            visit(File), visit(Directory)の振り分け
 * @content 練習問題 13-4
 *          Stringが finalの理由
 *
 * @class MainVisitor / ◆main()
 * @class MainElementList / ◆main() ElementListVisit用
 *
 * @package ---- entryElement ----
 * @interface IElementVisit / abstract accept(Visitor)
 * @class AbsEntryVisit implements IElementVisit
 *        / abstract getName(), getSize()
 *        add(){ throw } , iterator(){ throw }, toString() ||Template||
 * @class ElementListVisit implements IElementVisit
 *        / List<AbsEntryVisit> elementList /
 *        add(AbsEntryVisit), accept(AbsVisitor)
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
 *        / abstract visit(File), abstract visit(Directory)
 *        visit(AbsEntryVisit)
 * @class ShowVisitor extends AbsVisitor
 *        / String currentDir /
 *        visit(File), visit(Directory)
 * @class FindVisitor extends AbsVisitor
 *        / String findKey, List<AbsEntryVisit> findList /
 *        visit(File), visit(Directory), getFindList()
 * @class FileSizeVisitor extends AbsVisitor
 *        / Map<String,Integer> sizeMap /
 *        visit(File), visit(Directory),
 *        getFileSize(AbsEntryVisit), getFileSize(String)
 *        getSizeMap(), showSize()
 *
 * @author shika
 * @date 2021-06-11 ～ 06-13
 */
package javaGoF.chap13Visitor;

import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.FileTreatException;
import javaGoF.chap13Visitor.entryElement.FileVisit;
import javaGoF.chap13Visitor.visitor.FileSizeVisitor;
import javaGoF.chap13Visitor.visitor.FindVisitor;
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
             hanako.add(new FileVisit("diary.html", 300));
             taro.add(new FileVisit("game.txt", 400));
             taro.add(new FileVisit("gameMemo.html", 500));

             rootDir.accept(new ShowVisitor());
             System.out.println();

             //---- 練習問題 13-1 FindVisitor
             String findKey = ".html";
             var finder = new FindVisitor(findKey);
             rootDir.accept(finder);

             System.out.printf("[%s] files are: \n", findKey);
             finder.getFindList().forEach(System.out::println);
             System.out.println();

             //---- 練習問題 13-2 FileSizeVistor ----
             var sizeVisitor = new FileSizeVisitor();
             rootDir.accept(sizeVisitor);
             sizeVisitor.showSize();
             System.out.println();

             //---- Appendix ----
             //getFileSize(String)
             String seekSize = "root";
             System.out.printf("%s size: %d \n",
                 seekSize,
                 sizeVisitor.getFileSize(seekSize));

             //getFileSize(AbsEntryVisit)
             System.out.printf("%s size: %d \n",
                 yuki.getName(),
                 sizeVisitor.getFileSize(yuki));

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

//---- 練習問題 13-1 FindVisitor ----
[.html] files are:
diary.html (300)
gameMemo.html (500)

//---- 練習問題 13-2 FileSizeVisitor ----
//Map<String, Integer> sizeMap
temp: 0
yuki: 300
bin: 30000
JavaGoF.java: 100
latex: 20000
game.txt: 400
MultiThread.java: 200
hanako: 300
vi: 10000
root: 31500
gameMemo.html: 500
diary.html: 300
taro: 900
user: 1500

//---- Appendix ----
root size: 31500
yuki size: 300

【考察】 練習問題 13-2
AbsEntry.getName()を keyとした検索用の HashMapなので順不同。

Directory.getSize()を書き換えとの題意だったが、
entryListを他に持って行って、サイズ集計するぐらいなら、
そのDirectoryのサイズ集計は
従来どうりこのDirectoryクラスの getSize()で行ったほうがいいと思う。
もしDirectory.getSize()を変更するなら、
ここの処理を FileSizeVisitor.visit(Directory)に委譲する記述にする。

従来通りだと FileSizeVisitorを利用する機会がない。
表示は AbsEntry.toString(){ getSize() }を利用しているので、
表示する機会もない。
FileSizeVisitorは、もともと要らないのでは。

一応 main()で Map一覧を出してみた。
main()で利用するなら、
    sizeVisitor.getFileSize(String);
と記述して、ファイル/ディレクトリ名からサイズを調べる検索用。

//==== 練習問題 13-3 ====
@see MainElementList
@see ElementListVisit

//==== 練習問題 13-4 ====
問 The Open-Closed Principle 「拡張には開き、修正には閉じる」というクラス設計の原則
Stringは finalクラスで拡張にも閉じているが、なぜか、その理由を説明せよ。

(回答) My Answer
Immutable 不変であることの利点
・他クラスと共有時やマルチスレッド環境で、
オブジェクトの状態を途中で変えられる心配をしなくて済む。
・不変であることを保証することで、たくさんのクラスやスレッドで共有しやすくなる。

Stringはクラスだけでなく、生成する Stringの値も不変オブジェクト。

=> 【解答】 Text Answer
効率のため。
Javaの文字列を扱う基本的なクラスとして重要な役割を担っているので、
ユーザーによって改変されることを未然に防止している。
不変オブジェクトにすることで、処理スピードの向上やメモリ量の最適化を行う。
*/