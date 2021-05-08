/**
 * @title javaGold / se08Black / Practice07bkFileIO.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第７章 ioFile
 * @author shika
 * @date 2021-05-08
 */
/* Appendix 2021-05-08
 * @costTime 05:35 - 06:10 ( 35 分)
 * @correctRate 正答率 74.19 ％ ( 〇23問 / 全31問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice07bkFileIO {

    public static void main(String[] args) {
        new PracticeEditor();
        //Console console = System.console();
        //System.out.println(console); //null
    }//main()

}//class
/*
//====== 2021-05-08 ======
 第７章 ioFile
Ｘ （1） B, E -> C, E
   => ◆ java.io.File
           ファイルとディレクトリを扱える
           ファイルの読み書きをするための機能はない。
           ファイルやサブディレクトリの作成、削除、変更といったイベントを監視する機能はない。
           C: シンボリックリンクなどUnix固有のファイルシステムは処理できない。
           E: ファイルの所有者、セキュリティ属性は設定できない。

〇 （2） C
〇 （3） C
〇 （4） C
〇 （5） B
    => ◆ GoF || Decoratorパターン || 装飾するもの
        *基本的な機能 Decoratedクラスに
        *様々な機能を付け加え、クラスを重層的にラッピングしていく
        *継承: コンパイル時に決まる静的な拡張機能
        *Decorator: 基本機能のクラスをコンストラクタの引数として、
        *           覆いかぶせるようにラッピングしていく動的な拡張機能
        *           様々な機能を柔軟に組み合わせできる。

〇 （6） B
〇 （7） A, B
〇 （8） C?
    => ◆Consoleクラス
        Console System.console() / static
        String Console.readLine()
        Eclipse未対応で Console nullが返る

〇 （9） D
    => char[] Console.readPassword() echo機能なく入力文字が表示されないで入力できる
       char[] Console.readPassword(String format, Object... args) 書式設定 format()と同じ

       => Arrays.fill(T[], T value)
          Arrays.fill(charAry, ' ' ) charAryを初期化
          *セキュリティ上、取得した passwordをなるべく早く破棄することが推奨される。

〇 （10） B, D
〇 （11） D
    => ◆ObjectOutputStream
        writeObject(Object)

        ObjectInputStream
        readObject
〇 （12） C
Ｘ （13） A -> D
    Fileの問題点解決のために java.nio.file.Pathインターフェイス
〇 （14） C
    => FileSystem FileSystem.getDefault()

〇 （15） B, D
    => Path FileSystems.getDefault().getPath()
    => Path Path.get(URI)
       Path Path.get(String, String...)

Ｘ （16） C -> D
    => Path File.toPath(File)
       File File.toFile(Path)

〇 （17） D
    => Path getRoot(): rootのみ
       Path getFileName([int]): 最下層のファイル/ディレクトリも対象。ルートのみは null。
       Path getNameCouunt(): ルート以外の名前要素合計。ルートのみは 0を返す

Ｘ （18） F -> B
    => Path Path.subpath(int start, int end)
        rootは含まず。endは含まず。ルートに最も近いのが 0
〇 （19） E
        Path resolve(Path/String)
        *相対パス -> 結合したパス
        *絶対パス -> 引数で渡されたパスそのものを返す
        *空 -> 自分自身のパスを返す

〇 （20） C?
    => Path Path.resolveSibling(Path/String)
        *相対パス -> 現在の親ディレクトリからの解決されたパス
        *絶対パス -> 渡されたパスそのものを返す
        *メソッド呼出側のPathが相対パス -> 引数で渡されたパスを返す。

〇 （21） D
〇 （22） D
〇 （23） B
Ｘ （24） A, B -> C, D
    => Files.copy()
        *デフォルトの挙動
        *コピー先にファイルが存在するとき、FileAlreadyExistsException
        *ファイル属性はコピーされない。
        *ディレクトリ内のファイルはコピーされない。
        *シンボリックリンクは、リンク先だけがコピー、リンクはコピーしない。

〇 （25） B, C, D
Ｘ （26） B? -> A
    => AttributeViewインターフェイス (ノートにまとめ)

〇 （27） D
    => static Object
        Files.getAttribute(Path, String attribute, LinkOption...)

Ｘ （28） B? -> C [Java7]
    => static Path
    Files.walkFileTree(Path, FileVisitor<? super Path>)
    Files.walkFileTree(Path, Set<FileVisitOption>,
                       int maxDepth, FileVisitor<? super Path>)

〇 （29） B
    => Stream<String> Files.lines(Path [, Charset])

〇 （30） A
    => Stream<Path> Files.list(Path)
         *指定したディレクトリ内のみ

Ｘ （31） C? -> B
    => Stream<Path> Files.walk(Path, FileVisitOption...)
       Stream<Path> Files.walk(Path, int maxDepth, FileVisitOption...)

開始時刻 05:35
終了時刻 06:10
所要時間 35 分
正答率 74.19 ％ ( 〇23問 / 全31問 )
*/

