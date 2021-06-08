/**
 * @title javaGoF / chap11Composite / entryFile / MainEntryFile.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第11章 Composite / List 11-1 ～ 11-5
 * @content 容器と中身の同一視。Directoryも Fileも Entryとして扱う。
 *
 * @class MainEntryFile / ◆main()
 * @class AbsEntryComposite
 *        / abstract getName(), abstract getSize()
 *          add(Entry), printList(), #abstract printList(String), toString()
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

            //練習問題 11-2 / File, Directoryの絶対パス表示
            System.out.println("---- absolute path ----");
            AbsEntryComposite.getAbsolute("JavaGoF.java");
            AbsEntryComposite.getAbsolute("hanako");

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

//===== 練習問題 11-2 ======
public static void getAbsolute(final String entryName) {
    allList.stream()
        .filter(list ->
            list.stream()
                .anyMatch(e -> e.getName().contains(entryName)))
        .forEach(list ->
                list.stream()
                    .forEach(e -> e.printList(entryName))
        );

}//getAbsolute()

absolute path:
JavaGoF.java/JavaGoF.java (100)
JavaGoF.java/MultiThread.java (200)

【考察】
失敗だ。再考すべし。

//==== 練習問題 11-2 再 ====
//---- AbsEntryComposite ----
public static List<String> allList = new ArrayList<>();

public static void getAbsolute(String entryName) {
    allList.stream()
        .map(s -> s.substring(0, s.lastIndexOf(" (" )))
        .filter(s -> s.endsWith(entryName))
        .forEach(System.out::println);
}//getAbsolute

//---- MainEntryFile ----
System.out.println("---- absolute path ----");
AbsEntryComposite.getAbsolute("JavaGoF.java");
AbsEntryComposite.getAbsolute("hanako");

---- absolute path ----
/root/user/yuki/JavaGoF.java
/root/user/hanako

【考察】
各 File, Directoryの絶対パスは、すでに コンソールに出力してるので、
コンソールに出力したものを全て allListに格納し、
getAbsolute(String entryName)で File, Directoryを指定後、
allListの各要素からファイルサイズの 「(300)」などを除去。
指定した entryNameで終了するものを検索し、出力。

endsWith(entryName)を contains(entryName)にすると
Directory指定時に Directory自身と、その Directory配下のファイルも
表示されるので、endsWith()が良い。

練習問題 11-2 【解答】
AbsEntryに、Entry parentを定義。
Directory.add(entry)時に、parent = this;も行う。
各Directoryインスタンスには、それぞれの parent(= this)の値を保持しているので

AbsEntry.getFullName()において、
while(parent != null)になるまで、parentを追い、
StringBuffer.insert(0, "/" + entry.getName());で
Stringの先頭に parentのnameを挿入。
rootは parent == nullで終了。
それを表示。

*/

