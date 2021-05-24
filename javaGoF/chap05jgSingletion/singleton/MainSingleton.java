/**
 * @title javaGoF / chap05JG / MainSingleton.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第５章 Singleton / List 5-1, 5-2
 * @content 唯一のインスタンスであることを保証する
 * @author shika
 * @date 2021-04-17
 */
package javaGoF.chap05jgSingletion.singleton;

public class MainSingleton {

    public static void main(String[] args) {
        System.out.println("main(): start");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if(obj1 == obj2) {
            System.out.println("obj1 と obj2は同一インスタンスです。");
        } else if(obj1 != obj2){
            System.out.println("obj1 と obj2は別のインスタンスです。");
        }
        System.out.println("main(): end");
    }//main()

}//class

/*
main(): start
obj1 と obj2は同一インスタンスです。
main(): end

*/