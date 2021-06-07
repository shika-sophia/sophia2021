/**
 * @title javaGoF / chap11Composite / entryFile / MainEntryFile.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第11章 Composite / List 11-1 ～ 11-5
 * @content 容器と中身の同一視。Directoryも Fileも Entryとして扱う。
 *
 * @class MainEntryFile / ◆main()
 * @class AbsEntryComposite
 *        / abstract getName(), abstract getSize()
 *          add(Entry), printList(), #printList(String), toString()
 * @class FileTreatException extends RuntimeException 〔in AbsEntryComposite$1〕
 * @class DirectoryComposite extends AbsEntryComposite
 *        / name, entryList /
 *        / getName(), getSize(), add(Entry), #printList(String)
 * @class FileComposite extends AbsEntryComposite
 *        / name, size / getName(), getSize(), #printList(String)
 *
 * @author shika
 * @date 2021-06-07
 */
package javaGoF.chap11Composite.entryFile;

public class MainEntryFile {

    public static void main(String[] args) {
        try {
            System.out.println("Making root entry...");
            var rootDir = new DirectoryComposite("root");
            var binDir = new DirectoryComposite("bin");
            var tempDir = new DirectoryComposite("temp");
            var userDir = new DirectoryComposite("user");
            rootDir.add(binDir);
            rootDir.add(tempDir);
            rootDir.add(userDir);
            binDir.add(new FileComposite("vi", 10000));
            binDir.add(new FileComposite("latex", 20000));
            rootDir.printList();
            System.out.println();

            System.out.println("Making user entry...");
            var yuki = new DirectoryComposite("yuki");
            var hanako = new DirectoryComposite("hanako");
            var taro = new DirectoryComposite("taro");
            userDir.add(yuki);
            userDir.add(hanako);
            userDir.add(taro);
            yuki.add(new FileComposite("JavaGoF.java", 100));
            yuki.add(new FileComposite("MultiThread.java", 200));
            hanako.add(new FileComposite("diary.txt", 300));
            taro.add(new FileComposite("game.txt", 400));
            taro.add(new FileComposite("gameMemo.html", 500));
            rootDir.printList();

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

