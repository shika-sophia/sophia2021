/**
 * @title javaGold / se11Violet / sampleCode / chap04VT / MainGeneric.java
 * @reference YM: 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第４章 Collectionとジェネリクス / p154
 * @reference DJ: 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第９章 Generics / p453 / List 9.44, 9.45
 * @content DJ-453には、<? extends T>に add()不可とある。
 *          YM-154には、add()可とある。どちらが正しいか検証。
 * @author shika
 * @date 2021-04-01
 */
package javaGold.se11Violet.sampleCode.chap04VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainGeneric {

    public void show(List<? extends Parent> list) {
        //list.add(new Parent("波平"));

        for(var p : list) {
            System.out.println(p.getName());
        }
    }//show()
    public static void main(String[] args) {
        List<Parent> parentList = new ArrayList<>(
            Arrays.asList(
                new Parent("サザエ"),
                new Parent("マスオ"),
                new Parent("フネ")
            )
        );

        List<Child> childList = new ArrayList<>(
            Arrays.asList(
                new Child("ワカメ"),
                new Child("タラ")
            )
        );

        var here = new MainGeneric();
        here.show(parentList);
        here.show(childList);
    }//main()

}//class

class Parent {
    private String name;

    Parent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}//class Parent

class Child extends Parent {
    Child(String name) {
        super(name);
    }
}//class Child

/*
//====== show(List<Parent>) ======
サザエ
マスオ
フネ

このとき当然ながら、show(childList)はコンパイルエラー。

//---- list.add(new Parent("波平")); ----
サザエ
マスオ
フネ
波平

//====== show(List<? extends Parent> list) ======
//---- show(parentList), show(childList) ----
サザエ
マスオ
フネ
ワカメ
タラ

メソッドの引数を <? extends Parent>
下限ワイルドカードに変更、派生クラスもＯＫとする。
show(parentList)も
show(childList)も受け取ることができる。

//---- list.add(new Parent("波平")); ----
<? extends Parent>に変えると、listへの変更は不可になる。

型 List<? extends Parent> のメソッド add(<? extends Parent>) は
引数 (Parent) に適用できません

【考察】
DJの説明通り、メソッドの引数 show(List<? extends Parent) list)のとき
list.add()するとコンパイルエラーになる。

これは、配列の共変(= 派生クラスは 基底クラスの配列の要素に入れることができる性質)
の問題をジェネリックに持ち込まないため。
配列の共変によって、Object[]に String, Integerなどが代入でき、
型安全が崩れる問題を ジェネリックで解決したかったから導入された仕様。

*/