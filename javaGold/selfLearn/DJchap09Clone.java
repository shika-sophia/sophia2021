/**
 * @title javaGold / selfLearn / DJchap09Clone.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第９章 9.1 Object / List 9.10, 9.B / p402, p459
 * @content Cloneableを実装したクラス
 * @author shika
 * @date 2021-03-09
 */
package javaGold.selfLearn;

public class DJchap09Clone implements Cloneable {
    private String name;
    private int age;
    private String[] memo;

    public DJchap09Clone(String name, int age, String[] memo) {
        this.name = name;
        this.age = age;
        this.memo = memo;
    }

    @Override
    public DJchap09Clone clone() {
        DJchap09Clone here = null;
        try {
            here = (DJchap09Clone) super.clone();
            here.memo = this.memo.clone();

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }

        return here;
    }//clone()
}//class
