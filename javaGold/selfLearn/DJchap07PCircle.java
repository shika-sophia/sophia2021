/**
 * @title javaGold / selfLearn / DJchap07PCircle.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第７章 オブジェクト指向 基本 Class / 練習問題 7.2
 * @author shika
 * @date 2021-03-02
 */
package javaGold.selfLearn;

public class DJchap07PCircle {
    private final double PI = Math.PI; //円周率
    private double radius;             //半径

    public DJchap07PCircle() {
        this(1d);
    }

    public DJchap07PCircle(double radius) {
        this.radius = radius;
    }

    //円の面積
    public double getArea() {
        return radius * radius * PI;
    }//getArea()

    public double getLength() {
        return 2 * radius * PI;
    }

    public static void main(String[] args) {
        //var here = new DJchap07PCircle();
        var here = new DJchap07PCircle(6.4);
        System.out.println("円周率 π = " + here.PI);
        System.out.printf("半径 %.1f の円の面積: %.2f \n",
                here.radius, here.getArea());
        System.out.printf("半径 %.1f の円の円周: %.2f \n",
                here.radius, here.getLength());
    }//main()

}//class

/*
円周率 π = 3.141592653589793
半径 6.4 の円の面積: 128.68
半径 6.4 の円の円周: 40.21

円周率 π = 3.141592653589793
半径 1.0 の円の面積: 3.14
半径 1.0 の円の円周: 6.28
*/