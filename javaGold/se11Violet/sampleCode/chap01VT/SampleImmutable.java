/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / SampleImmutable.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第１章 Java Primary / p54
 * @content Immutable
 *          Mutable
 * @author shika
 * @date 2021-05-02
 */
package javaGold.se11Violet.sampleCode.chap01VT;

public class SampleImmutable {
    private final int x;
    private final int[] ary = {1, 2, 3};

    private SampleImmutable(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int[] getAry() {
        return ary;
    }

    //Immutableなので、フィールドを加算した新しいインスタンスを生成して返す。
    public SampleImmutable add(int y) {
        y += x;
        return new SampleImmutable(y);
    }

}//class


class Mutable {
    private int x;
    private int[] ary = {1, 2, 3};

    public Mutable(int x) {
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int[] getAry() {
        return ary;
    }

    public void add(int y) {
        x += y;
    }

    public Mutable getInstance() {
        return this;
    }
}//class Mutable
