/**
 * @title multiThread / chap03MT / guardedSuspention / Request.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第３章 GuardedSuspention / List 3-1
 * @author shika
 * @date 2021-02-27
 */
package multiThread.chap03MT.guardedSuspention;

public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Request: " + name + "]";
    }//toString()

    public String getName() {
        return name;
    }

}//class

