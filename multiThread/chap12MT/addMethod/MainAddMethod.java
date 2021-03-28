/**
 * @title multiThread / chap12MT / addMethod / MainAddMethod.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 ActiveObject / 練習問題 12-2 / add()の追加
 * @author shika
 * @date 2021-03-28
 */
package multiThread.chap12MT.addMethod;

import multiThread.chap12MT.activeObjectPattern.activeObject.ActObj;
import multiThread.chap12MT.activeObjectPattern.activeObject.ActObjFactory;


public class MainAddMethod {

    public static void main(String[] args) {
        ActObj actObj = ActObjFactory.createActObj();
        new AddClientThread("Diana", actObj).start();
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

*/