/**
 * @title javaGold / selfLearn / DJchap09Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第９章 列挙型 / 練習問題 9.3
 * @author shika
 * @date 2021-03-08
 */
package javaGold.selfLearn;

public class DJchap09Enum {
    enum Weekday {
        SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }//enum

    public static void main(String[] args) {
        Weekday[] weekAry = Weekday.values();

        for(Enum<Weekday> weekEnum : weekAry) {
            System.out.println(
                weekEnum.ordinal() + ":" + weekEnum.name());
        }
    }//main()

}//class

/*
0:SUNDAY
1:MONDAY
2:TUESDAY
3:WEDNESDAY
4:THURSDAY
5:FRIDAY
6:SATURDAY
*/

