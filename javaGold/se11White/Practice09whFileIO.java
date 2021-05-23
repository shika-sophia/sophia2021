/**
 * @title javaGold / se11White / Practice09whFileIO.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles
 * @author shika
 * @date 2021-04-10
 */
/* Appendix 2021-04-10
 * @costTime 10:56 - 11:37 ( 40 分)
 * @correctRate 正答率 68.18 ％ ( 〇15問 / 全22問 )
 */
/* Appendix 2021-05-08
 * @costTime 20:50 - 21:26 ( 35 分)
 * @correctRate 正答率 59.09 ％ ( 〇13問 / 全22問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice09whFileIO {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-10 ======
 第９章 ioFile, nioFiles
〇 （1） D
    => readLine()は BufferedReaderのメソッド
         BufferedReaderと接続できるのは キャラクターストリームのみ。
        Ｘ System.in: バイナリーストリーム
        Ｘ FileReader: キャラクターだが コンストラクタの引数 File, Stringのみ
        〇 InputStreamReader: キャラクターストリーム。バイナリからキャラクタへの変換

〇 （2） B
    => Consoleクラス: コンソールの読み書きが可能となるクラス
                    コストラクタ private。
                    System.console()で Consoleインスタンスを取得。

〇 （3） E
    => ◆Console.readLine(String format, Object... args)
        題意は formatに普通の String, argsを省略した形
        文字列が待ち受け(=プロンプト)となり、単一行の読み込みをする。

〇 （4） B
    => ノードストリーム: 単独での利用可能
        FileInputStream / FileOutputStream
        フィルタストリーム: 他ストリームと連結して利用。単独不可。
        DataInputStream / DataOutputStream

〇 （5） C
    => Ｘ・OutputStreamは抽象クラスのためストリームを生成できない。
        Ｘ・フィルタストリームは コンストラクタの引数に直接Fileを渡せない。
        〇・ノードストリームの FileOutputStreamと連結して
            フィルターストリームの DataOutputStreamを利用。
        Ｘ・FileWriterは キャラクターストリーム。
            DataOutputStreamはバイナリーストリームのみ。

〇 （6） A
〇 （7） C
    => 出力ストリームで、ファイルが存在しないと、ファイルを新規作成する。

Ｘ （8） B -> D
    => java.ioの入力ストリームで、ファイルが存在しないと
    FileNotFoundExceptionを throw
    throws IOExceptionは FileNotFoundExceptionの superなので呼出元に転送。
    catch(Exception e) は IOExceptionの superなので catch。
    e.getClass(); 「class java.io.FileNotFoundException」と出力。
    最初に発生した例外のクラスが表示される。

〇 （9） C
〇 （10） A
    Path.getName(int): 0はルートの最初。ルートは含まず。
    Path.subpath(int begin, int end): 部分パスを返す(end含まず)。 0はルート含まず。

Ｘ （11） C -> D
    => Path.startsWith(String), endsWith(String): Stringと同様
        Path.relativize(Path): 引数との相対パスを返す。

Ｘ （12） D -> A
    => println(Path): ""で渡されたままを出力
        Path.nomalize(): 冗長部分を削除したパス。
    => 題意「C:/gold/../info/test/./../sample.txt」
        C
        ┗ gold
        ┗ info
            ┗ test
            ┗ sample.txt

        nomalize() -> C:/info/sample.txt

Ｘ （13） D? -> A
    ◆パス連結 Path.resolve(Path), resolve(String)
    「C:\\gold\\.」に resolve("dir1") -> C:/gold/./dir1
    「C:\\gold」に resolve("\\dir2") -> C:/dir2

    => *解答「c:/dir2」を出すには引数に絶対パスを渡す必要がある。
       *題意"\\dir2"は カレントのひとつ下の dir2の意。「./dir2」と同じ相対パス
       *問題文の誤植と判断して 問題文を resolve("C:\\dir2");なら解答通りの答えになる。

Ｘ （14） A? -> B
    => 「C:\\.\\gold\\test\\..\\sample.txt」
            C
            ┗ gold
                ┗ test
                ┗ sample.txt
    => Path.getNameCount(): 引数に渡されたパスのルートを除く要素の数
        getNameCount() 「.」「gold」「test」「..」「sample.txt」 -> 5
        nomalize() -> C:/gold/sample.txt
        nomalize().getNameCount() 「gold」「sample.txt」 -> 2

〇 （15） E?
    => Path.equals(Object):
         同一のパスなら true。 絶対パスと相対パスは false。
        Pathオブジェクト同士の比較。オブジェクトが違うと無条件で false。

       Path.isSamePath(Path, Path):
           絶対パスと相対パスの比較でも、同じ行き先を指していれば true。

〇 （16） C
    => Files.copy(Path source, Path target, StandaradCopyOption...)
        ◆StandardCopyOption
        StandardCopyOption.REPLACE_EXISTING: コピー先が存在する場合は上書き
        StandardCopyOption.COPY_ATTRIBUTES: ファイル属性もコピー
        StandardCopyOption.NOFOLLOW_LINKS: シンボリックリンクはたどらない

        REPLACE_EXISTING以外は上書き不可。-> 	FileAlreadyExistsException

〇 （17） A
    => Files.move(Path source, Path target, StandardCopyOption)
        ◆move()で可能な StandardCopyOption
        StandardCopyOption.REPLACE_EXISTING
        StandardCopyOption.ATOMIC_MOVE

        これ以外を指定すると java.lang.UnsupportedOperationException 〔runtime〕

Ｘ （18） A -> B
    => Files.move()で移動したので元の場所にはファイルが無くなる
        Files.delete()で元の場所の Pathを指定すると
        ファイルが存在しない java.nio.file.NoSuchFileException

    FileNotFoundExceptionは java.ioの例外

〇 （19） E
〇 （20） C
Ｘ （21） A, D -> A, B
    => newDirectory(Path, String) 第２引数で検索語を指定。
    => FileSystem.getPathMatcher(String) 引数でしていした検索パターンに合致するか
〇 （22） B

開始時刻 10:56
終了時刻 11:37
所要時間 40 分
正答率 68.18 ％ ( 〇15問 / 全22問 )
*/

/*
//====== 2021-05-08 ======
 ioFile, nioFiles [２回目]
〇 （1） D
〇 （2） B
〇 （3） E
    => Console.readLine(String format [, Object... args])
       System.printf(readLine("Gold"))
       readLine()内のformatが printf()で出力されていることに驚く。
       printf()は必要あるのかな。

Ｘ （4） D -> B
    => D: 実行時に例外の回答理由は
        *FileOutputStream(file)と引数に直接Fileをいれていたから、
        *FileXxxxStreamは バイナリーStreamの ノードStream (=単体で利用可)だから
        *これでいい。もしあかんならコンパイルエラーになるから実行時じゃない。

〇 （5） C
    =>  ◆バイナリーStream
    => ノードStream: FileOutputStream / FileInputStream 単体可
    => フィルターStream: DataOutputStream / DataInputStream 連結して利用
    OutputStream / InputStreamは抽象クラス。インスタンスは FileXxxxStreamクラスなどで行う。

〇 （6） A
    => ◆キャラクタStream
    => ノード: FileWriter / FileReader
    =>フィルタ: BufferedWriter / BufferedReader

〇 （7） C
Ｘ （8） B ->
    => throws句で呼出元へ IOExceptionを戻し
        catch(Exception e)で受けても、
        e.getClass()で呼び出されるのは最初の原因となった例外
        class java.io.FileNotFoundException

〇 （9） C
Ｘ （10） D -> A
    => D:コンパイルエラーの回答理由 Path.getName()は存在しないと思っていた。
    *  Path.getFileName(int)と同様のメソッド、ちゃんとある。
    *  Path Path.getName(int) intにあたるPathを返す。 0はルートに一番近い要素。ルート含まず。

〇 （11） D
Ｘ （12） D -> A
    => print(Path)は引数で渡した文字列をそのまま表示。
       Path.nomalize()で冗長部分をカット。ディレクトリ階層をちゃんと把握する。
   => 「C:\\gold\\..\\info\\test\\.\\..\\sample.txt」
           * C
           *  ┗ gold
           *  ┗ info
           *      ┗ test
           *      	   ┗ .
           *      ┗ sample.txt
           * C:/info/sample.txt

Ｘ （13） D -> A
    => resolve()で「.」はそのまま残る。
    => *解答「c:/dir2」を出すには引数に絶対パスを渡す必要がある。
       *題意"\\dir2"は カレントのひとつ下の dir2の意。「./dir2」と同じ相対パス
       *問題文の誤植と判断して 問題文を resolve("C:\\dir2");なら解答通りの答えになる。
    => Linux表記「/dir」はルート直下 dirの意の絶対パス。誤植ではない。

Ｘ （14） A -> B
    => Path.getNameCount(): 名前要素を集計。「.」「..」もカウント

Ｘ （15） B -> E
    => ◆boolean Path.equals(Object)
        *相対パスと絶対パスの比較は 文字列が異なるので false
        *Pathと File、オブジェクトの形違いは無条件に false
       => ◆boolean isSamePath(Path, Path)なら
           *相対パスと絶対パスが同じ場所を示していれば true

       => p1 = Paths.get("gold");       -> ./gold
          p2 = p1.getAbsolutePath();    -> C:/gold
          p3 = Path.of("C:\\", "gold"); -> C:/gold

〇 （16） C
〇 （17） A
Ｘ （18） D -> B
    => Files.move(Path source, Path target, StandardCopyOption...)
        * StandardCopyOption.REPLACE_EXISTINGなら
        * targetファイルが既に存在してる場合は、置き換わる。
        * ファイル名は 既存targetにリネーム。
        * move()によって移動したので、元の場所の delete()は
        * NoSuchFileException

〇 （19） E
〇 （20） C
Ｘ （21） C -> A, B
    => static DirectoryStream<Path>
    Files.newDirectoryStream(Path dir, String pattern)

    => boolean? FileSystem.getPathMatcher(String regex)
        *.jar -> 「.jar」で終わる
        *.* -> 「.」を含む
        *.{java, jar} -> 「.java」か「.jar」で終わる
        *.[java] -> 「java」のうち１文字とマッチする

〇 （22） B

開始時刻 20:50
終了時刻 21:26
所要時間 35 分
正答率 59.09 ％ ( 〇13問 / 全22問 )
*/

