/**
 * @title javaGold / selfLearn / DJchap07PCircle.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第７章 オブジェクト指向 基本 Class / 練習問題 7.3
 *
 * @refernce ◆【Java TIPS】 BigDecimalの注意点
 *           http://www.mitchy-world.jp/java/tips/tips04.htm
 *           ＊永遠に割り切れないよと例外が発生しちゃいました。
 *             そこで、少数何桁までにするか、切り上げ・切り下げ・四捨五入などを指定してやります。
 *             今回は少数10桁で四捨五入してみます。
 *           ＊BigDecimalは値によってはtoString()で指数表現（指数表記）になってしまいます。
 *             それを防ぎたい場合はtoPlainString()を使いましょう。
 * @author shika
 * @date 2021-03-02
 */
package javaGold.selfLearn;

import java.math.BigDecimal;

public class DJchap07CalcBMI {
    private static BigDecimal weightBd;
    private static BigDecimal heightBd;

    @SuppressWarnings("deprecation")
    public static BigDecimal getBmi() {
        return weightBd.divide(heightBd.multiply(heightBd)
                , 10, BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal factoryDecimal(double num) {
        String numStr = String.valueOf(num);
        var decimal = new BigDecimal(numStr);
        return decimal;
    }//factoryDecimal()

    public static void main(String[] args) {
        weightBd = factoryDecimal(62.3);
        heightBd = factoryDecimal(168.2);

        System.out.printf("BMI: %s \n", getBmi().toPlainString());
    }//main()

}//class

/*
BMI: 62.30

計算してない。
weight値がそのまま出てきている。

＊BigDecimalにしたら
Exception in thread "main" java.lang.ArithmeticException:
  Non-terminating decimal expansion;
  no exact representable decimal result.
    at java.base/java.math.BigDecimal.divide(BigDecimal.java:1722)
    at javaGold.selfLearn.DJchap07CalcBMI.getBmi(DJchap07CalcBMI.java:17)
    at javaGold.selfLearn.DJchap07CalcBMI.main(DJchap07CalcBMI.java:30)

この例外永遠に割り切れないと出る例外

＊非推奨 ROUND_HALF_UPを付けたら成功
divide(heightBd.multiply(heightBd)
    , 10, BigDecimal.ROUND_HALF_UP);
BMI: 0.0022020951
*/