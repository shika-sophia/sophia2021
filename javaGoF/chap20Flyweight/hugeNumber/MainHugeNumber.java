/**
 * @title javaGoF / chap20Flyweight / hugeNumber / MainHugeNumber.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第20章 Flyweight / インスタンスを共有する。
 *          huge:[英] 巨大な -> hugeStr: 横16 × 縦 8の ascii文字
 *
 *          テキスト仕様は txtファイルに元データを書き、
 *          それを FileReaderで読み込ませて、
 *          必要に応じて HugeNumberクラスを poolMapで保存する。
 *
 * @content 自作 version
 *          NumberDataに binaryデータの16進数表記で表示のデータ int[]を用意。
 *          その int[]を 集合した List<int[]>を作る。
 *          必要に応じて、各 int[]から StringBuilderで hugeStrを作成。
 *          テキスト仕様と大きく違うクラス構成になってしまった。
 *
 * @class MainHugeNumber / ◆main()
 * @class NumberData
 * @class HugeNumber
 * @class HugeNumberFactory
 *
 * @author shika
 * @date 2021-06-26
 */
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

