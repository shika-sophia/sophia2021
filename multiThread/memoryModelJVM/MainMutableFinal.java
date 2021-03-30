/**
 * @title multiThread / memoryModelJVM / MainMutableFinal.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-6
 * @content final: コンストラクタが完了するまでは finalの値も確定しない。
 * 				      特に自インスタンスを表す thisを
 * 				      代入やメソッドの引数でコンストラクタの外に出してはいけない。
 * @see List B-7 MainImmutableFinal
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM;

class MutableFinal {
    //finalなインスタンス・フィールド
    private final int x;
    //クラスフィールド
    private static MutableFinal lastInstance = null;

    public MutableFinal() {
        x = 123; //final初期化
        lastInstance = this; //staticフィールドに最新のインスタンスを代入
    }//constructor

    //lastInstance経由でフィールド xを取得して表示
    public static void printField() {
        if(lastInstance != null) {
            System.out.println(lastInstance.x);
        }
    }//printField()

}//class MutableFinal

public class MainMutableFinal {

    public static void main(String[] args) {
        //インスタンスするスレッド
        new Thread(() -> new MutableFinal()).start();

        //フィールドを表示するスレッド
        new Thread(() -> MutableFinal.printField()).start();

    }//main()

}//class

/*
123

【考察】 何も表示されない可能性があるプログラム
コンストラクタ終了までは finalの値は確定しない。
lastInstance = this;が代入される以前に
printField()で xを読みに行くと
x = 0, lastInstance = nullで、何も表示されない。
コンストラクタの外に thisを出したことが間違い。

コンストラクタを privateとし、
インスタンスは static create()というメソッドを作って行う。
@see List B-7 MainImmutableFinal
*/