/**
 * @title multiThread / memoryModelJVM / MainVolatile.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-5
 * @content volatile: volatileフィールドの代入だけでなく、
 * 					  それ以前に記述された volatileを付記していない変数の変更も
 * 					  すべてのスレッドに見えるようになる。
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM;

class WithVolatile {
    private int x = 0;
    private volatile boolean flag = false;

    public void write() {
        x = 123;
        flag = true;
    }//write()

    public void read() {
        if(flag) {
            System.out.println("x = " + x);
        }//if
    }//read()
}//class WithVolatile

public class MainVolatile {

    public static void main(String[] args) {
        final WithVolatile obj = new WithVolatile();

        //書くスレッド
        new Thread(() -> obj.write()).start();

        //読むスレッド
        new Thread(() -> obj.read()).start();
    }//main()

}//class

/*
x = 123

【考察】 volatile以前の代入が reorderで実行順序が入れ替わることはない。
このプログラムは必ず「x = 123」が表示され、
reorderがあった場合の「x = 0」が表示されることはない。

代入の記述順は重要で、
    flag = true;
    x = 123;
と代入の順序を入れ替えて記述すると

「volatile以前の代入が 全てのスレッドに見える」という機能を果たせず、
x = 123は 他スレッドから見えてない可能性が残るので注意。
*/