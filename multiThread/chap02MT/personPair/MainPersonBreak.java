/**
 * @title multiThread / chap02MT / personPair / MainPersonBreak.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable / 練習問題 2-6, List A2-5, A2-6
 * @content PersonMutable, PersonImmutableの対になったクラスの unsafeを検証。
 * @author shika
 * @date 2021-02-26
 */
package multiThread.chap02MT.personPair;

public class MainPersonBreak {

    public static void main(String[] args) {
        var mutable = new PersonMutable("start", "start");
        new PersonBreakThread(mutable).start();
        new PersonBreakThread(mutable).start();
        new PersonBreakThread(mutable).start();

        for (int i = 0; true; i++) {
            mutable.setPerson("" + i, "" + i);
        }
    }//main()

}//class MainPersonBreak

/*
//====== 修正前 ======
Thread-1 **** BROKEN **** [PersonImmutable: 31161832, 31161831]
Thread-0 **** BROKEN **** [PersonImmutable: 31161622, 31161621]
Thread-1 **** BROKEN **** [PersonImmutable: 31163106, 31163105]
Thread-2 **** BROKEN **** [PersonImmutable: 31162905, 31162904]
Thread-2 **** BROKEN **** [PersonImmutable: 31163668, 31163667]
Thread-2 **** BROKEN **** [PersonImmutable: 31163841, 31163840]
Thread-2 **** BROKEN **** [PersonImmutable: 31163979, 31163978]
Thread-1 **** BROKEN **** [PersonImmutable: 31163495, 31163494]
Thread-1 **** BROKEN **** [PersonImmutable: 31164335, 31164334]
Thread-1 **** BROKEN **** [PersonImmutable: 31164516, 31164515]
Thread-1 **** BROKEN **** [PersonImmutable: 31164652, 31164651]
Thread-1 **** BROKEN **** [PersonImmutable: 31164840, 31164839]
Thread-0 **** BROKEN **** [PersonImmutable: 31163291, 31163290]

//====== 修正箇所 PersonImmutable ======
//    //BROKENの出たコンストラクタ
//    public PersonImmutable(PersonMutable person) {
//        this.name = person.getName();
//        this.address = person.getAddress();
//    }

    //修正後のコンストラクタ
    public PersonImmutable(PersonMutable person) {
        synchronized(person) {
            this.name = person.getName();
            this.address = person.getAddress();
        }
    }

//====== 修正後 ======
(BROKEN 表示出ず）

PersonBreakTread.run()で、
新たな PersonImmutableインスタンスを作り続け、
PersonMutableを引数としている。
この PersonMutableの name, addressは常に変更されているので、
    person.getName()
    person.getAddress()
の間に別スレッドによる変更が入る可能性がある。

この２つのgetterをまとめて１つのクリティカルセクション(synchronized)にする必要がある。
*/