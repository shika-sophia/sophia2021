/**
 * @title multiThread / chap01MT / singleTreadedExecution / SingleThreadedExecution.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content List 1-1, 1-2, 1-3, 1-4 / p52-54 / synchronized
 *
 * @class SingleThreadedExecution // ◆EntryPoint main()で各インスタンス
 * @class Gate                    // pass(), check()の定義。
 * @class UserThread extends Thread //ユーザーのコンストラクタ。 pass()の呼び出し。
 *
 * @author shika
 * @date 2021-02-23
 */
package multiThread.chap01MT.singleThreadedExecution;

public class SingleThreadedExecution {

    public static void main(String[] args) {
        System.out.println("Testing Gate, hit [CTRL]+[C] to exit.");

        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }//main()

}//class

/*
//====== Test not synchronized ======
    :
###### BROKEN ###### No.427606872: Chris, Canada
###### BROKEN ###### No.427608502: Alice, Alaska
###### BROKEN ###### No.427608503: Alice, Alaska
###### BROKEN ###### No.427609808: Alice, Alaska
###### BROKEN ###### No.427610044: Alice, Alaska
###### BROKEN ###### No.427610045: Alice, Alaska
###### BROKEN ###### No.427615524: Chris, Canada
###### BROKEN ###### No.427615624: Alice, Alaska
###### BROKEN ###### No.427616443: Alice, Alaska
###### BROKEN ###### No.427617033: Bobby, Brazil
###### BROKEN ###### No.427617198: Alice, Alaska
###### BROKEN ###### No.427617566: Bobby, Brazil
###### BROKEN ###### No.427617802: Bobby, Brazil
###### BROKEN ###### No.427618157: Bobby, Brazil
    :
//====== Test synchronized Gate.pass(), toString() ======
Testing Gate, hit [CTRL]+[C] to exit.
AliceBEGIN
BobbyBEGIN
ChrisBEGIN

*/