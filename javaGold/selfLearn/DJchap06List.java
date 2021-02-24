package javaGold.selfLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DJchap06List {

    public static void main(String[] args) {
         List<Integer> list1 =
             new ArrayList<>(Arrays.asList(16, 24, 30 ,39));

        //不変リスト
         List<Integer> list2 = List.of(16, 24, 30, 39);

         List<Integer> list3 =
             IntStream.of(16, 24, 30, 39).boxed()
             .collect(Collectors.toList());

         System.out.println("list1: " + list1);
         System.out.println("list2: " + list2);
         System.out.println("list3: " + list3);
    }//main()

}//class

/*
list1: [16, 24, 30, 39]
list2: [16, 24, 30, 39]
list3: [16, 24, 30, 39]

List.of()メソッド内部で newしていると思われ、
List.of()で newしなくても List生成される。

collect(Collectors.toList())も同様。
*/