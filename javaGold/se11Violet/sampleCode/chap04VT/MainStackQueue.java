/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainStackQueue.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第６章 Collection / p266
 * @content Queueインターフェイス, Stackクラス
 * @content 元のインターフェイス、クラスのメソッドを使ってみる
 * @author shika
 * @date 2021-04-01
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class MainStackQueue {

    public static void main(String[] args) {
        //---- Stack ----
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(15);
        stack.push(null);
        stack.push(30);

        System.out.println("stack: " + stack);
        System.out.println("stack.pop(): " + stack.pop());
        System.out.println("stack.peek(): " + stack.peek());
        System.out.println("stack.pop(): " + stack.pop());
        System.out.println("stack.peek(): " + stack.peek());
        System.out.println("stack: " + stack);
        System.out.println();

        //---- Queue ----
        final int BOUND = 3;
        Queue<Integer> queue = new ArrayBlockingQueue<>(BOUND);
        queue.add(10);
        queue.add(15);
        queue.add(30);
        //queue.add(null);//NullPointerException
        //queue.add(45);  //IllegalStateException: Queue full
        queue.offer(45);  //queue: [10, 15, 30]

        System.out.println("queue: " + queue);
        System.out.println("queue.element(): " + queue.element());
        System.out.println("queue.peek(): " + queue.peek());
        System.out.println("queue.poll(): " + queue.poll());
        System.out.println("queue.remove(): " + queue.remove());
        System.out.println("queue: " + queue);
        System.out.println("queue.remove(): " + queue.remove());
        //System.out.println("queue.remove(): " + queue.remove());//NoSuchElementException
        System.out.println("queue.poll(): " + queue.poll());

    }//main()

}//class

/*
//====== Stack ======
stack: [10, 15, null, 30]
stack.pop(): 30
stack.peek(): null
stack.pop(): null
stack.peek(): 15
stack: [10, 15]

【考察】 Stack.push()で要素を重ねる = addFirst()
pop(): 最初(Stackは最後に重ねた要素)を取り出して削除 = removeFirst()
peek():最初を検査して戻す(削除しない) = peekFirst()

上記のように push()で次々に重ねていき、
最初 pop()で 最後に入れた 30を取り出し削除。
次に peek()で検査、 nullがそのまま表示。削除しないのでその次も null
pop()で nullを取り出し削除。

//====== Queue ======
型 Queue のインスタンスを生成できません
ArrayBlockingQueue extends AbstractQueue implements BlockingQueue
-- Queue --//-- Deque --
add()      //addLast()
offer()    //offerLast()
queue: [10, 15, 30]
queue.element(): 10 //getFirst()
queue.peek(): 10    //peekFirst()
queue.poll(): 10    //pollFirst()
queue.remove(): 15  //removeFirst()
queue: [30]
queue.remove(): 30
//queue.remove(): //NoSuchElementException
queue.poll(): null

【考察】
Queueはインターフェイスで、実装クラス Queueというのはない。
ArrayBlockingQueueで代用。コンストラクタで要素数を指定(=配列と同じぽい)
普通は Queue,Stackの実装クラスである ArrayDequeを利用。

nullの add()は 実行時に NullPointerException
要素数を超えて add()すると、IllegalStateException: Queue full
要素数を超えても offer()だと例外は出ず、falseで要素は追加されず。

取り出し検査 get()は未定義 = element(), peek()を使う。
取り出し削除 remove(), poll()を利用

要素がないのに取り出そうとすると、element(), remove()は
NoSuchElementExceptionが throwされる。
peek(), poll()は nullを表示。

*/