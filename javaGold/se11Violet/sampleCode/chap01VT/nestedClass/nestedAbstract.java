/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / nestedClass / nestedAbstract.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / p36
 * @content List 1-27 / ネストクラスの抽象・インターフェイス
 * @author shika
 * @date 2021-03-23
 */
package javaGold.se11Violet.sampleCode.chap01VT.nestedClass;

public class nestedAbstract {
    abstract class AbsClass {
        abstract void foo();
    }

    class SubClass extends AbsClass {
        void foo() { }
    }

    static interface IStatic {
        public abstract void bar();
    }

    static class SubStatic implements IStatic {
        public void bar() { }
    }
}//class

