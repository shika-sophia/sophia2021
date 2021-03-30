/**
 * @title multiThread / memoryModelJVM / MainImmutableFinal.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 付録Ｂ: JVMメモリモデル / List B-7
 * @content final: コンストラクタが完了するまでは finalの値も確定しない。
 * 				      特に自インスタンスを表す thisを
 * 				      代入やメソッドの引数でコンストラクタの外に出してはいけない。
 * @see List B-6 MainMutableFinal
 * @author shika
 * @date 2021-03-30
 */
package multiThread.memoryModelJVM;

class ImmutableFinal {
    private final int x;
    private static ImmutableFinal lastInstance;

    private ImmutableFinal() {
        x = 123;
    }//constructor

    public static void create() {
        lastInstance = new ImmutableFinal();
    }//create()

    public static void printField() {
        if(lastInstance != null) {
            System.out.println("x = " + lastInstance.x);
        }
    }//printField()
}//class ImmutableFinal

public class MainImmutableFinal {

    public static void main(String[] args) {
        new Thread(() -> ImmutableFinal.create()).start();
        new Thread(() -> ImmutableFinal.printField()).start();
    }//main()

}//class

/*
x = 123

【考察】
static時点(クラスロード時)に コンストラクタが呼ばれ、
lastInstanceに代入される。

printField()時には、必ず lastInstanceに代入されているので、
nullで無表示になることはない。
*/