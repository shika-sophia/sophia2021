/**
 * @title javaGold / se11Violet / Practice09vtFileIO.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第９章 ioFile, nioFiles
 * @author shika
 * @date 2021-04-11
 */
/* Appendix 2021-04-11
 * @costTime 08:32 - 09:23 ( 51 分)
 * @correctRate 正答率 39.13 ％ ( 〇9問 / 全23問 )
 */

/* Appendix 2021-05-09
 * @costTime 14:24 - 15:01 ( 36 分)
 * @correctRate 正答率 65.22 ％ ( 〇15問 / 全23問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice09vtFileIO {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-11 ======
 第９章 ioFile, nioFiles
Ｘ （1） B, D -> B, E
    => System.console()は Singleton
    => コンソールを利用できないときは nullを返す。

Ｘ （2） A -> D
   => String Console.readLine()
   => char[] Console.readPassword()

〇 （3） E
    => PrintWriter Console.writer()
    => void PrintWriter.append(String)
〇 （4） C, F
    => File[] file.listFiles(): fileで示されたディレクリ内のファイルを配列化
        ファイルが存在しない場合は 要素 null
    => void file.delete(): ファイルを削除。
        ファイルが存在しない場合は FileNotFoundException
        上記配列の要素が nullなら NullPointerException

Ｘ （5） B, C, F -> A, C, E
   => File.mkdir(File), mkdirs(File), renameTo(String)

〇 （6） A, D
    => System.in: in -> InputSteam
    => System.out / err: out/err -> PrintStream
Ｘ （7） A, C, D -> A, C, E
    => File(String)
       File(String parent, String child)
       File(File parent, String child)

    => Ｘ File()に ２つ以上の引数を取るコンストラクタなし。
        -> Paths.get(String, String...)
〇 （8） A
Ｘ （9） A, D -> D, E
    => java.io.Serializable
    => Serializableを付けるのが super, subだと どちらもシリアライズ可能だが、
        デシリアライズ時の挙動が異なる。

Ｘ （10） B, E -> A, C
    => 「setterで値が格納されていれば nullにならない」
        そりゃそうやろ。setter省略しといて、こんな問題あるかよ。
    => コンストラクタ, 初期化ブロックは、デシリアライズ時には呼び出されない。
    => transient: シリアライズ対象外のため、デシリアライズ後 null
       static: シリアライズ対象外だが、元クラスで初期化していれば static領域なので参照可。

Ｘ （11） A, D, E -> A, C, E
    => Path Paths.get()
        get(String)
        get(String, String...)の２種ある。

〇 （12） E
    => File[] File.listFiles()
    => Stream<Path> Files.list(Path)
    どちらも、指定されたディレクトリ内だけ検索。

Ｘ （13） C, D, F -> A, C, E
    => ◆java.nio.file (NIO2)
       A: シンボリックリンクをサポートしている。
       C: 単一のメソッドでディレクトリ・ツリー内を横断できる。Files.walk()
       E: システムに依存した属性をサポートする。
               DosFileAttributes, PosixFileAttributes

    => java.io.File
        ディレクトリ、ファイルの作成可。 mkdir(), mkdirs()
        ファイルの削除可。File.delete()
        タイムスタンプ可。 File.lastModified()
        ディレクトリ内の全てのファイル表示。File.listFiles()

Ｘ （14） D -> C
    => 題意「/tmp/.././home/../my.txt」
        C: | 「/」 root
        ┗ tmp
        ┗ .
             ┗ home
             ┗ my.txt

        path.nomalize() -> /my.txt とのこと。
        カレント内にあるファイルなので my.txtでいいのでは？
        /my.txtだと root直下に my.txtがあることになるけど・・
    => 「../」は 直前の homeの親ではなく
    カレントから見た親 つまり root
    root直下にあるで正解。
    C: | 「/」 root
        ┗ tmp
        ┗ .
             ┗ home
         ┗ my.txt

Ｘ （15） E -> B
    => normalize()は冗長部分を削除するが、
    引数の相対パスを絶対パスに変換しない。
    よって、Paths.get(".") -> path.getNameCount() -> 1

〇 （16） B, C
Ｘ （17） C -> A
    => Path.resolve()は pathを結合するが
    物理的にディレクリを作成するわけではない。

〇 （18） C
    => a: /food/../orange.txt 絶対パス
       b: ./lemon.txt 相対パス
       a.resove(b) -> /food/../orange.txt/./lemon.txt
           -> orange.txtの後ろにも、そのまま結合。
           こんなpathはないはずだけど、resolve()は機械的に結合する
       b.resolve(a) -> /food/../orange.txt
           -> aは絶対パスのため、resolve()は 引数のまま返し、
           b.resolve(a)の値も引数の絶対パスになる(bは無視される)

Ｘ （19） E -> C
    => BasicFileAttibutesは、属性値を読み取ることはできるが
     setXxxx()のように属性値を設定するメソッドは存在しない。
〇 （20） B, C
Ｘ （21） A -> D
    => p.isDirectory()の記述がコンパイルエラー
       Files.isDirectory(p)ならＯＫ。
       Filesって staticメソッドばかりだから、Filesのときは常にこの形

〇 （22） E
Ｘ （23） A -> C
    => Files.find(Path, int, Predicate<T>)
    第２引数は検索階層: 0のときは Pathで示された階層のみ
    Path.of("foo")なら fooのみ、1で foo内のファイルも検索対象

開始時刻 08:32
終了時刻 09:23
所要時間 51 分
正答率 39.13 ％ ( 〇9問 / 全23問 )
*/

/*
//====== 2021-05-09 ======
 ioFile, nioFiles [２回目]
〇 （1） B, E
〇 （2） D
Ｘ （3） D? -> E
  => PrintWriter Console.writer()

〇 （4） C, F
    => File.listFiles()でファイルのみ取得、delete()で削除。
    => pathが存在しないと null -> file.lengthが NullpPointerException
    foo(files[i])で 自己再帰呼出にはならんのかな。

〇 （5） A, C, E
〇 （6） A, D
〇 （7） A, C, E
〇 （8） A
〇 （9） D, E
Ｘ （10） B, E -> A, C
   => setterで値が格納されていれば nullでない。そりゃそうやろ。他も全部そうだよ。
   => デシリアライズでは、初期化ブロック { }と コンストラクタは働かないので、
           *ここで初期化していても値は入らない。
   => staticの値が残り続けるのは、同一実行のJVM内のみ。常に nullとはならない。

〇 （11） A, C, E
Ｘ （12） D -> E
    => File[] File.listFiles()
    => Stream<Path> Files.list()

〇 （13） A, C, E
〇 （14） C
Ｘ （15） D -> B
    => Path.nomalize()は相対パスを絶対パスに変換しない
        * 「.」の Path.getNameCount()は 1

〇 （16） B, C
    => シンボリックリンクは ファイル/ディレクトリに作成可。
    => Files.deleteIfExist(Path)は ディレクトリ内にファイルが存在しないときのみ削除。

〇 （17） A
〇 （18） C
Ｘ （19） E
    => BasicFileAttributesに setXxxx()は未定義。コンパイルエラー。

Ｘ （20） C, F -> B, C
    => Files.move()
        * 同名のファイルが存在してる場合、上書き rename
        * 同名のディレクトリが存在している場合、実行時例外
    => シンボリックリンクも普通のファイルとしてそのまま移動

Ｘ （21） A -> D
    => Files.isDirectory(Path)ならコンパイル成功。
        * Filesは全てが staticなので必ず引数に Pathを取る。
        *
〇 （22） E
Ｘ （23） B -> C
    => Files.find(Path, int maxDepth, BiPredicate<T, T>)
    maxDepthの値が 0のため、 fooのみ検索対象。-> 何も表示されない。C
    1の場合、foo/a.txt, foo/b.txtの要素があるため B

開始時刻 14:24
終了時刻 15:01
所要時間 36 分
正答率 65.22 ％ ( 〇15問 / 全23問 )
*/

