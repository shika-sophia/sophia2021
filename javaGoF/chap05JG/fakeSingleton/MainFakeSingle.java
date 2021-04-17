/**
 * @title javaGoF / chap05JG / MainFakeSingleton.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第５章 Singleton / 練習問題 5-3
 * @content 題意の FakeSingletonは ThreadSafeではないというのを MultiThreadで検証。
 *          Thread干渉しやすいように、お題のクラスに Thread.sleep()だけ入れました。
 *
 *          本来は getInStance()を synchronizedにすればＯＫ。
 *          それと classが finalではないので、
 *          継承して Overrideしてインスタンス生成しまくりみたいなこともできる。
 *
 * @author shika
 * @date 2021-04-17
 */

package javaGoF.chap05JG.fakeSingleton;

public class MainFakeSingle {

    public static void main(String[] args) {
        System.out.println("main(): start");
        new RushThread().start();
        new RushThread().start();
        new RushThread().start();
        new RushThread().start();
        new RushThread().start();
        System.out.println("main(): end");
    }//main()

}//class

class RushThread extends Thread {

    public RushThread() { }

    public void run() {
        var fake = FakeSingleton.getInstance();
        System.out.println(
            fake.getClass() +":ID " + FakeSingleton.getId());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fake =FakeSingleton.getInstance();
        System.out.println(
            fake.getClass() +":ID " + FakeSingleton.getId());
    }//run()
}//class RushThread

/*
//---- primitive getInstance() ----
main(): start
main(): end
FakeSingleton(0) インスタンス生成
FakeSingleton(0) インスタンス生成
FakeSingleton(0) インスタンス生成
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 3
FakeSingleton(0) インスタンス生成
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 4
FakeSingleton(0) インスタンス生成
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 5
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 2
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 2
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 5
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 5
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 5
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 5
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 5

//---- synchronized getInstance() ----
main(): start
main(): end
FakeSingleton(0) インスタンス生成
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1
class javaGoF.chap05JG.fakeSingleton.FakeSingleton:ID 1

【考察】
後段の synchronized getInstnce() が本来あるべき姿。
インスタンスは１回きりで、その後は同じインスタンスを返す。

前段は synchronizedのない元のままの getInstance()
インスタンスは 5回もやって、IDの違うインスタンスができていることがわかる。
*/