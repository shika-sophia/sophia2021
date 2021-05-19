/**
 * @title javaGold / se11Silver / Examin02SV.java
 * @reference 志賀澄人 『徹底攻略 Java SE11 Silver 問題集[1ZO-815]』 インプレス, 2019
 * @content  Silver総合問題２
 * @author shika
 * @date 2021-05-19
 */
/* Appendix 2021-05-19
 * @costTime 13:09 - 15:27 ( 137 分)
 * @correctRate 正答率 81.25 ％ ( 〇65問 / 全80問 )
 */
package javaGold.se11Silver;

import javaGold.PracticeEditor;

public class Examin02SV {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-19 ======
 Silver総合問題２
Ｘ （1） B -> D
    => 検査例外 checked exception
    *  throws IOExceptionより、
    *  catch(FileNotFoundException e)では catchできない。
    *  catch(IOException e)とする。
    *  IndexOutOfBoundsExceptionは unchecked(非検査例外)より
    *  catch()をしなくてもコンパイルは通る。

〇 （2） A, B, D
〇 （3） A
Ｘ （4） D, E, F -> C, E, F
    => D: (無記)パッケージprivateより、
    *     listは継承関係があっても同パッケージ内までしか参照できない。
    => C: CacheTrashクラスには add()の定義はないが、
    *     superを継承しているためこのクラスでも処理可能。

Ｘ （5） A -> C
    => this.valueとしないとローカルを優先しローカルvalueに代入したことになる

〇 （6） C
〇 （7） A
    => 数値型の変数をキャストなしで charに入れることはできない。

〇 （8） D
    => 自メソッドの再帰呼出は java.lang.StackOverflowError

〇 （9） E
〇 （10） A, E
Ｘ （11） E -> B
    => static { }を２回以上記述してもよい。

〇 （12） C, D
〇 （13） C
〇 （14） D
    => superは １階層上のメソッドまでアクセス可。
    *  「super.super」はコンパイルエラー。

〇 （15） B
〇 （16） D
〇 （17） A, E
    => ◆配列生成時の初期化子 { }
    *  配列の生成と要素の代入を同時にできる。
    *  newによるインスタンス生成と同時でないといけない。
    *  { } 初期化子内の要素数から類推して配列要素数を決めるため、
    *  new int[3]{ }のように [3]配列要素数を記入するとコンパイルエラー

〇 （18） E
Ｘ （19） D -> B
    => a / 5を bに加算代入。 aは 10のまま。計算ミス。

〇 （20） B
〇 （21） A
〇 （22） D
〇 （23） C
〇 （24） A
Ｘ （25） B -> D
    => (無記)パッケージprivate は 異なるパッケージからは参照不可。

Ｘ （26） B -> C
    => staticから 非staticメンバにはアクセス不可。

〇 （27） B
〇 （28） B
Ｘ （29） A -> D
    => finalフィールドの初期化
    *  引数なしのコンストラクターで finalフィールドを初期化しておらず、
    *  このコンストラクタの定義でコンパイルエラー。

〇 （30） C
〇 （31） A
    => Collection Map.values()

Ｘ （32） C -> B
    => defaultメソッドにより、インターフェイス内の実装メソッドは可能。

〇 （33） C
    => Object[]と プリミティブ型の配列には互換性がない。
    *  扱う集合が異なる。
    *  int[]の superは Object

〇 （34） A
〇 （35） D
    => JVMは あらかじめ決められた形でしかコードを読み込めない。
    *  別言語の違う形式に翻訳された(コンパイルされた)実行可能ファイルを読み込んで
    *  実行することはできない。
    *
    *  コンパイラは JVMで読み込める形式に翻訳するだけで、
    *  各プラットフォームで実行できるかを考慮しない。
    *  各プラットフォームで実行可能な形式に翻訳するのは JVMの役割。
    *
    *  Javaは必要に応じてクラスファイルをメモリに読み込む。

〇 （36） D
    => ラムダ式の val -> の時点で 型は省略していても変数の定義をしている。
    *  ローカル変数と同じ変数名を持つ変数を使うと二重定義のコンパイルエラー。

Ｘ （37） A -> C
    => 初期化されていないローカル変数を利用するとコンパイルエラー。
    *  Stringもローカルは初期化が必要。

〇 （38） E
〇 （39） D
    => continue;の次行のコードは到達不能コードでコンパイルエラー。

〇 （40） A
〇 （41） A
〇 （42） C
Ｘ （43） C, E -> C, D
    => ◆モジュールシステムについて
    C: 利用するモジュールはrequiresで宣言されてなければならない。
    D: モジュールを実行するとき、モジュールにクラスパスが通る
    *  モジュールに含まれるプログラムはモジュール内のディレクトリにアクセス可能。
    E: module-info.javaは空でもいい
〇 （44） A
〇 （45） B, D, E
〇 （46） C
〇 （47） A
〇 （48） D, E
〇 （49） C
〇 （50） C, D
〇 （51） C
〇 （52） D, G, H
〇 （53） A
〇 （54） A, E
〇 （55） E
〇 （56） B
Ｘ （57） C -> A
    => bin/～はクラスファイルの配置場所。
    * importでは、クラスファイルの場所ではなくて、ソースファイルの完全修飾名。
    * クラスファイルの配置場所は コンパイルや実行時の classpassで記述。

〇 （58） C
〇 （59） A
    => intと Integerの演算や比較
    *  自動的にアンボクシングされ、プリミティブ型同士として演算・比較される。
    *  int Integer.intValue(Integer)でアンボクシングする。
    *  「int == Integer」は int同士で値の判定

〇 （60） A
〇 （61） B
〇 （62） A
〇 （63） D, E
〇 （64） C
〇 （65） D
〇 （66） E
〇 （67） B
〇 （68） B, F
〇 （69） C
Ｘ （70） A, B -> A
    => B: new抜けとる

〇 （71） C, E
〇 （72） C
〇 （73） C
Ｘ （74） A? -> C
    => ◆ Object.clone()
    *  新しい配列を作り、その要素はシャローコピーで、
    *  元の配列の要素と、clone()された配列の要素は同じ参照を共有。
    *
    *  char[][] array2 = array1.clone();
    *  array1, array2の要素は同じ参照先を持っている。
    *  「==」は参照同一性を比較
    *  C: array1[1] == array2[1]; true
    *
    *  boolean Object.equals(Object)はデフォルトで参照同一性
    *  array1.equals(array2);は要素こそ同じ参照だが、配列は新しく作った別の配列。
    *  よって false。
    *
    *  char[] array3 = array1[1].clone();
    *  A: array1[1] == array3; false
    *  新しい配列を作り、要素はarray1[1]をコピー。
    *  array1は 二次元配列のため、array1[1]の要素は char[]
    *  array3の char[]は新しく作った別の配列。
    *
    *  B: array1[1] == array3[1]; compileError
    *  array1は char[][]なので要素は char[]、
    *  array3は char[]なので要素は char型
    *  char[]と charの比較はコンパイルエラー。

〇 （75） C
〇 （76） B, E
〇 （77） A
〇 （78） B
Ｘ （79） B -> A
    => clone()は同じ値を持った新しい配列を生成。
    *  クローン先の要素の変更が、クローン元に影響を与えることはない。

〇 （80） A

開始時刻 13:09
終了時刻 15:27
所要時間 137 分
正答率 81.25 ％ ( 〇65問 / 全80問 )
*/

