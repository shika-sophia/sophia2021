package javaGoF.chap20Flyweight.hugeNumber;

import java.util.List;
import java.util.stream.Collectors;

public class MainHugeNumber {

    public static void main(String[] args) {
        var factory = HugeNumberFactory.getInstance();

        final String target = "1212123";
        List<String> targetList = target.chars()     //IntStream 49, 50, 51, 49 ..
            .mapToObj(i -> String.valueOf((char) i)) //Stream<String>  1, 2, 3, 1 ...
            .map(Integer::valueOf)        //String -> Integer
            .map(factory::getNumberData)  //int index -> String hugeStr
            .collect(Collectors.toList());//List<String>に代入

        targetList.forEach(System.out::println);
        System.out.println(
            "poolMap.size(): " + factory.getPoolMap().size());
    }//main()

}//class

/*
poolMap.size(): 3

......##........
..######........
......##........
......##........
......##........
......##........
..##########....

....######......
..##......##....
..........##....
......####......
....##..........
..##............
..##########....

......##........
..######........
......##........
......##........
......##........
......##........
..##########....

....######......
..##......##....
..........##....
......####......
....##..........
..##............
..##########....

......##........
..######........
......##........
......##........
......##........
......##........
..##########....

....######......
..##......##....
..........##....
......####......
....##..........
..##............
..##########....

....######......
..##......##....
..........##....
......####......
..........##....
..##......##....
....######......


*/