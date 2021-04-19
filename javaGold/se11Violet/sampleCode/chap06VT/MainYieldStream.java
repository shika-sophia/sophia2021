/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainYieldStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2 StreamAPI / p480 / List 10-12
 * @content Arrays.stream(T[]), List.stream(), Map.entrySet().stream()
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainYieldStream {

    public static void main(String[] args) {
        //Array yield to Stream
        var ary = new String[] {"とら","パンサー","ねずみ","うま"};
        Arrays.stream(ary).forEach(s -> System.out.print(s + ", "));
        System.out.println();

        //List yeild to Stream
        var list = new ArrayList<String>(
            Arrays.asList("tiger","panter","mouse","horse"));
        list.stream().forEach(s -> System.out.print(s + ", "));
        System.out.println();

        //Map yield to Stream
        var map = new HashMap<String,String>();
        for(int i = 0; i < ary.length; i++) {
            map.put(list.get(i), ary[i]);
        }//for
        map.entrySet().stream().forEach(s -> System.out.print(s + ", "));
    }//main()

}//class

/*
とら, パンサー, ねずみ, うま,
tiger, panter, mouse, horse,
horse=うま, mouse=ねずみ, tiger=とら, panter=パンサー,
*/