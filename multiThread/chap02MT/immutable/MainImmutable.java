/**
 * @title multiThread / chap02MT / immutable / MainImmutable.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable
 *
 * @class MainImmutable //main(), new PersonFinal, Thread.start()
 * @class PersonFinal   //final class, final name, final address
 * @class PersonThread extends Thread // Thread.run()
 *
 * @author shika
 * @date 2021-02-25
 */
package multiThread.chap02MT.immutable;

public class MainImmutable {

    public static void main(String[] args) {
        PersonFinal alice = new PersonFinal("Alice","Alaska");
        new PersonThread(alice).start();
        new PersonThread(alice).start();
        new PersonThread(alice).start();
    }//main()
}//class

/*
Thread-0[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-2[Person name: Alice, address: Alaska]
Thread-0[Person name: Alice, address: Alaska]
Thread-1[Person name: Alice, address: Alaska]
Thread-1[Person name: Alice, address: Alaska]
*/

