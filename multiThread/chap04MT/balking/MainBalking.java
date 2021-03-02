/**
 * @title multiThread / chap04MT / balking / MainBalking.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第４章 Balking / ガード条件に合わなければ、すぐ帰る
 * @author shika
 * @date 2021-03-01
 */
package multiThread.chap04MT.balking;

public class MainBalking {

    public static void main(String[] args) {
        var data = new BalkingData("src\\multiThread\\chap04MT\\balking\\data.txt", "(empty)");
        new BalkingChangerThread("ChangerThread", data).start();
        new BalkingSaveThread("SaveThread", data).start();
    }//main()

}//class

/*
SaveThread calls doSave(), content = No.0
SaveThread calls doSave(), content = No.1
SaveThread calls doSave(), content = No.2
ChangerThread calls doSave(), content = No.3
SaveThread calls doSave(), content = No.4
ChangerThread calls doSave(), content = No.5
ChangerThread calls doSave(), content = No.6
SaveThread calls doSave(), content = No.7
SaveThread calls doSave(), content = No.8
ChangerThread calls doSave(), content = No.9
SaveThread calls doSave(), content = No.10

ChangerThread calls doSave(), content = No.11
SaveThread calls doSave(), content = No.12
ChangerThread calls doSave(), content = No.13
SaveThread calls doSave(), content = No.14
SaveThread calls doSave(), content = No.15
ChangerThread calls doSave(), content = No.16
SaveThread calls doSave(), content = No.17
ChangerThread calls doSave(), content = No.18
ChangerThread calls doSave(), content = No.19

＊data.txt
No.0 No.1 No.2 No.3 No.4 No.5 No.6 No.7 No.8 No.9 No.10
No.11 No.12 No.13 No.14 No.15 No.16 No.17 No.18 No.19

//====== 練習問題 4-2 (1) Balkingのデバックプリント ======
SaveThread calls doSave(), content = No.0
<< Balking return >>
SaveThread calls doSave(), content = No.1
<< Balking return >>
ChangerThread calls doSave(), content = No.2
SaveThread calls doSave(), content = No.3
<< Balking return >>
SaveThread calls doSave(), content = No.4
<< Balking return >>
ChangerThread calls doSave(), content = No.5
ChangerThread calls doSave(), content = No.6
SaveThread calls doSave(), content = No.7
<< Balking return >>

//====== 練習問題 4-2 (2) 無駄な書き込みを起こす ======
SaveThread calls doSave(), content =
No.0
ChangerThread calls doSave(), content =
No.0
ChangerThread calls doSave(), content = No.1
SaveThread calls doSave(), content = No.2
ChangerThread calls doSave(), content = No.2
SaveThread calls doSave(), content = No.3
ChangerThread calls doSave(), content = No.3
ChangerThread calls doSave(), content = No.4
SaveThread calls doSave(), content = No.5
<< Balking return >>
ChangerThread calls doSave(), content = No.6
SaveThread calls doSave(), content = No.7
ChangerThread calls doSave(), content = No.7
SaveThread calls doSave(), content = No.8
ChangerThread calls doSave(), content = No.8
ChangerThread calls doSave(), content = No.9
SaveThread calls doSave(), content = No.10

No.0 No.0 No.1 No.2 No.2 No.3 No.3 No.4 No.5 No.6
No.7 No.7 No.8 No.8 No.9 No.10

 */
