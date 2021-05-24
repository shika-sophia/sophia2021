/**
 * @title javaGoF / chap06JG / prototype / MainPrototype.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第６章 Prototype / List 6-1 ～ 6-5
 * @package ---- framework ----
 * @interface Product imlements Cloneable //Prototype
 * @class Manager //Map<String, Product>, register(), doClone()
 * @package ---- prototype default ----
 * @class MainPrototype //◆main()
 * @class MessageBox implemants Product //use(), createClone()
 * @class Underline implements Product  //use(), createClone()
 * @author shika
 * @date 2021-04-22
 */
package javaGoF.chap06jgPrototype.prototype;

import javaGoF.chap06jgPrototype.prototype.framework.Manager;
import javaGoF.chap06jgPrototype.prototype.framework.Product;

public class MainPrototype {

    public static void main(String[] args) {
        //---- define ----
        Manager manager = new Manager();
        Underline underline = new Underline('~');
        MessageBox asterBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');

        //---- register() ----
        manager.register("under", underline);
        manager.register("aster", asterBox);
        manager.register("slash", slashBox);

        //---- doClone() and use() ----
        Product p1 = manager.doClone("under");
        p1.use("Hello World");
        Product p2 = manager.doClone("aster");
        p2.use("Hello World");
        Product p3 = manager.doClone("slash");
        p3.use("Hello World");
        System.out.println();

        //---- Test print ----
        manager.getProtoMap()
            .entrySet()
            .stream()
            .map(set -> set.getKey() + " = " + set.getValue())
            .forEach(System.out::println);
    }//main()

}//class

/*
◆p1.usae()
" Hello World "
~~~~~~~~~~~~~~~

◆p2.use()
***************
* Hello World *
***************

◆p3.use()
///////////////
/ Hello World /
///////////////

aster = javaGoF.chap06jgPrototype.prototype.MessageBox@1d251891
slash = javaGoF.chap06jgPrototype.prototype.MessageBox@48140564
under = javaGoF.chap06jgPrototype.prototype.Underline@58ceff1
*/