/**
 * @title multiThread / memoryModelJVM / MainReorder.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-1, B-3
 * @content reorder: JVMの最適化により、実行順序が入れ替わる可能性
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM;

class Reorder {
    private int x = 0;
    private int y = 0;

    public void write() {
        x = 100;
        y = 50;
    }//write()

    public void read() {
        if(x < y) {
            System.out.println("x < y");
        }
    }//read()
}//class Reorder

public class MainReorder {

    public static void main(String[] args) {
        final Reorder reorder = new Reorder();

        //書くスレッド
        new Thread(() -> reorder.write()).start();

        //読むスレッド
        new Thread(() -> reorder.read()).start();
    }//main()

}//class

/*
【考察】 このプログラムによって「 x < y 」が表示されることはあるか
普通にプログラムの記述通りに順次実行されるなら、上記の結果になることはないが、
JVMの reorderによって、 x = 100; の代入と y = 50;の代入の実行順が入れ替わった場合、
x = 0, y = 100の状態で if文の評価をされると 「 x < y 」はありうる。

実際に何回か実行してみたが、私のJVMでは「 x < y 」とならなかった。
マルチスレッド時のデータレース(= 競合)を防ぐなら
write(), read()に synchronizedが必要。
*/