/**
 * @title javaGoF / chap06JG / prototypeRV / MainPrototypeRV.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第６章 Prototype / List 6-1 ～ 6-5, 練習問題 6-1
 * @inheritence 【継承関係】 <・・implements / <--extends
 *      Cloneable <・・ Product <・・ AbsProduct <-- MessageBoxRV, UnderlineRV
 *
 * @package ---- frameworkRV ----
 * @interface Product implements Cloneable
 * @class AbsProduct implements Product
 *                //Prototype, createClone()
 * @class Manager //Map<String, Product>, register(), doClone()
 *
 * @package ---- prototypeRV default ----
 * @class MainPrototypeRV //◆main()
 * @class MessageBoxRV extends AbsProduct //use()
 * @class UnderlineRV extends AbsProduct  //use()
 *
 * @content 重複していた creatClone()を一本化 -> AbsProductへ移動
 * @author shika
 * @date 2021-04-22
 */
package javaGoF.chap06JG.prototypeRV;

import javaGoF.chap06JG.prototype.framework.Manager;
import javaGoF.chap06JG.prototype.framework.Product;

public class MainPrototypeRV {

    public static void main(String[] args) {
        //---- define ----
        Manager manager = new Manager();
        UnderlineRV underlineRV = new UnderlineRV('~');
        MessageBoxRV asterBox = new MessageBoxRV('*');
        MessageBoxRV slashBox = new MessageBoxRV('/');

        //---- register() ----
        manager.register("under", underlineRV);
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
" Hello World "
~~~~~~~~~~~~~~~

***************
* Hello World *
***************

///////////////
/ Hello World /
///////////////

aster = javaGoF.chap06JG.prototypeRV.MessageBoxRV@48140564
slash = javaGoF.chap06JG.prototypeRV.MessageBoxRV@58ceff1
under = javaGoF.chap06JG.prototypeRV.UnderlineRV@7c30a502

【考察】
MessageBox, Underlineに ２つ同じメソッド createClone()があったのを改善。
両クラスの親である AbsProductを作り、そこに createClone()を実装。
interfaceのままだと、clone()が未定義となり(= Objectクラスを継承していない)
defaultメソッドでも実装できなかったが、
abstract class 抽象クラスに変更すると、createClone()そのまま実装できた。

createClone()内の Product型
Managerクラス内の Product型
MainPrototype内の Product型
上記は いずれも AbsProduct implements Product, Cloneable
とすることで、superの superとして Product型として同一視して扱える。

なので、Managerクラスは、なにも変更することなく、既存のクラスのまま使える。
MessageBoxRV, UnderlineRVは createClone()を削除するにあたり、
クラス名を変更したので、Mainは RVで作り直す必要があった。

【継承関係】 <・・implements / <--extends
Cloneable <・・ Product <・・ AbsProduct <-- MessageBoxRV, UnderlineRV
というクラス図となり、Prototypeは AbsProduct
インスタンスの型は Product
Cloneableは Productで継承しているので 全てのサブクラスに継承される。
createClone()は AbsProductにのみ記述しているが、これもサブクラスに継承され、
Product型の中身であるオブジェクトの型 new MessageBoxRV, new UnderlineRV
に合わせて、createClone()が型を選択してくれる。(ポリモーフィズム[=多態性]の機能)

Test printで Map<String, Product>の各要素を出力した。
ポリモーフィズムは意図どうり機能しており、
Prototypeは AbsProductからの RVクラスであることを示している。

aster = javaGoF.chap06JG.prototypeRV.MessageBoxRV@48140564
slash = javaGoF.chap06JG.prototypeRV.MessageBoxRV@58ceff1
under = javaGoF.chap06JG.prototypeRV.UnderlineRV@7c30a502

*/