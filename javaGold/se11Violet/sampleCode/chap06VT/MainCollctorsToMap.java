/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainCollectorsToMap.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p496 / List 10-37
 * @content 戻値 Collctor<T, ?, Map<K, V>>
 *          Collctors.toMap(Function<T,K> key,
 *                          Function<T,V> value,
 *                          [BinaryOparator<V> merge]) //キーが重複した場合に行う処理
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollctorsToMap {

    public static void main(String[] args) {
        System.out.println(
            Stream.of(
                new Person("山田太郎", "tyamada@example.com"),
                new Person("山田太郎", "tato-y@example.com"),
                new Person("佐藤久美", "satou@example.com"),
                new Person("鈴木花子", "suzuki@example.com"),
                new Person("山田太郎", "tytyty@example.com")
            )
            .collect(Collectors.toMap(
                Person::getName,
                Person::getEmail,
                (v1, v2) -> v1 + " / " + v2 //前の値と結合
                //(v1, v2) -> v2            //値を上書き
            ))//collect()
        );//println()
    }//main()

}//class

class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}//class Person

/*
＊キー重複の場合、値を結合
(v1, v2) -> v1 + " / " + v2
{佐藤久美=satou@example.com, 鈴木花子=suzuki@example.com,
 山田太郎=tyamada@example.com / tato-y@example.com / tytyty@example.com}

＊キー重複の場合、値を上書き
 (v1, v2) -> v2
 {佐藤久美=satou@example.com, 鈴木花子=suzuki@example.com, 山田太郎=tytyty@example.com}

第３引数 binaryOperator<V>は、Mapの値を V型で作る関数
*/