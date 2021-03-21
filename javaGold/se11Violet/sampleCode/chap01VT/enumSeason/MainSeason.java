/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / enumSeason / MainSeason.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本 / enum
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content enum例文 〔DJ: 9.3.2 / p432 / DJ-121〕
 * @author shika
 * @date 2021-03-22
 */
package javaGold.se11Violet.sampleCode.chap01VT.enumSeason;

public class MainSeason {

    public static void main(String[] args) {
        //System.out.println(SeasonConstructor.SPRING.toJpName());

        for(SeasonConstructor season : SeasonConstructor.values()) {
            System.out.printf("code: %d, name: %s \n",
                season.toSeasonCode(), season.toJpName());
        }//for season
        System.out.println();

        for(SeasonAbstract season : SeasonAbstract.values()) {
            season.show();
        }
    }//main()

}//class

/*
code: 0, name: 春
code: 1, name: 夏
code: 2, name: 秋
code: 3, name: 冬

春は あけぼの
夏は夜
秋は夕暮れ
冬は つとめて

*/