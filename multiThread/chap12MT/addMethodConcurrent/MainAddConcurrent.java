/**
 * @title multiThread / chap12MT / addMethodConcurrent / MainAddConcurrent.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 ActiveObject / 練習問題 12-2 / サンプル２に add()の追加
 * @author shika
 * @date 2021-03-28
 */
package multiThread.chap12MT.addMethodConcurrent;

import multiThread.chap12MT.concurrentActiveObject.ActObjFactory;
import multiThread.chap12MT.concurrentActiveObject.IActObj;

public class MainAddConcurrent {

    public static void main(String[] args) {
        IActObj actObj = ActObjFactory.createActObj();

        try {
            new AddClientThread("Diana", actObj).start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("**** shutdown ****");
            actObj.shutdown();
        }
    }//main()

}//class

/*
Diana: 1 + 1 = 2
Diana: 1 + 2 = 3
Diana: 2 + 3 = 5
Diana: 3 + 5 = 8
Diana: 5 + 8 = 13
Diana: 8 + 13 = 21
Diana: 13 + 21 = 34
Diana: 21 + 34 = 55
Diana: 34 + 55 = 89
Diana: 55 + 89 = 144
Diana: 89 + 144 = 233
Diana: 144 + 233 = 377
Diana: 233 + 377 = 610
Diana: 377 + 610 = 987
Diana: 610 + 987 = 1597
Diana: 987 + 1597 = 2584
Diana: 1597 + 2584 = 4181
Diana: 2584 + 4181 = 6765
Diana: 4181 + 6765 = 10946
Diana: 6765 + 10946 = 17711
Diana: 10946 + 17711 = 28657
Diana: 17711 + 28657 = 46368
Diana: 28657 + 46368 = 75025
Diana: 46368 + 75025 = 121393
Diana: 75025 + 121393 = 196418
Diana: 121393 + 196418 = 317811
Diana: 196418 + 317811 = 514229
Diana: 317811 + 514229 = 832040
Diana: 514229 + 832040 = 1346269
Diana: 832040 + 1346269 = 2178309
Diana: 1346269 + 2178309 = 3524578
Diana: 2178309 + 3524578 = 5702887
Diana: 3524578 + 5702887 = 9227465
Diana: 5702887 + 9227465 = 14930352
Diana: 9227465 + 14930352 = 24157817
Diana: 14930352 + 24157817 = 39088169
Diana: 24157817 + 39088169 = 63245986
Diana: 39088169 + 63245986 = 102334155
Diana: 63245986 + 102334155 = 165580141
Diana: 102334155 + 165580141 = 267914296
Diana: 165580141 + 267914296 = 433494437
Diana: 267914296 + 433494437 = 701408733
Diana: 433494437 + 701408733 = 1134903170
Diana: 701408733 + 1134903170 = 1836311903
Diana: 1134903170 + 1836311903 = 2971215073
**** shutdown ****
Diana: 1836311903 + 2971215073 = 4807526976
class java.util.concurrent.RejectedExecutionException

*/