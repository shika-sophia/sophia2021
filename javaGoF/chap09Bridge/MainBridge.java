/**
 * @title javaGoF / chap09Bridge / MainBridge.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第９章 Bridge / List 9-1 ～ 9-5
 * @content 機能の階層と実装の階層を分離し、
 *          フィールド impl に実装の階層をのせ、Bridge(=橋)とする。
 *
 * @class MainBridge / ◆main()
 * @package ---- bridgeFunction / 機能の階層 ----
 * @class BridgeDisplay / impl / open(),print(),close(),display()
 * @class CountDisplay extends BridgeDisplay / multiDisplay()
 *
 * @package ---- bridgeImplementation / 実装の階層 ----
 * @class AbsDisplayImpl
 * @class SimpleDisplayImpl
 *
 * @author shika
 * @date 2021-06-03
 */
package javaGoF.chap09Bridge;

import javaGoF.chap09Bridge.bridgeFunction.BridgeDisplay;
import javaGoF.chap09Bridge.bridgeFunction.CountDisplay;
import javaGoF.chap09Bridge.bridgeImplementation.SimpleDisplayImpl;

public class MainBridge {

    public static void main(String[] args) {
        BridgeDisplay d1 = new BridgeDisplay(
                new SimpleDisplayImpl("Hello Japan"));
        BridgeDisplay d2 = new CountDisplay(
                new SimpleDisplayImpl("Hello World"));
        CountDisplay d3 = new CountDisplay(
                new SimpleDisplayImpl("Hello Universe"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }//main()

}//class

/*
+-----------+
|Hello Japan|
+-----------+
+-----------+
|Hello World|
+-----------+
+--------------+
|Hello Universe|
+--------------+
+--------------+
|Hello Universe|
|Hello Universe|
|Hello Universe|
|Hello Universe|
|Hello Universe|
+--------------+

 */

