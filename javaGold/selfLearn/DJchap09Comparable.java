/**
 * @title javaGold / selfLearn / DJchap09Comparable.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第９章 9.1 Object / List 9.8 / p400 //章末問題 [4]①
 * @content Comparableを実装したクラス // toString()
 * @author shika
 * @date 2021-03-09
 */
package javaGold.selfLearn;

public class DJchap09Comparable implements Comparable<DJchap09Comparable>{
    private String firstName;
    private String lastName;

    public DJchap09Comparable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(DJchap09Comparable obj) {
        if(this.lastName.equals(obj.lastName)) {
            return this.firstName.compareTo(obj.firstName);
        } else {
            return this.lastName.compareTo(obj.lastName);
        }
    }//compareTo()

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }//toString()

}//class
