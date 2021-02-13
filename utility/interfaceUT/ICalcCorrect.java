/**
 * @title utility / interfaceUT / ICalcCorrect.java
 * @contrnt List<Integer> -> 回答数, 正答数, 正答率
 * @contrnt (0, 1) -> ("〇","×") -> List<String>
 * @reference 【Java】プログラムの実行時間の計測方法
 *             https://qiita.com/t_t238/items/79adff198a22dd76340b
 * @reference 浮動小数点数内部表現シミュレーター
 *             https://tools.m-bsys.com/calculators/ieee754.php
 * @author shika
 * @date 2021-02-10
 */

package utility.interfaceUT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface ICalcCorrect {

    public default CorrectData zeroToString(List<Integer> inListInt) {
        int answerNum = inListInt.size();
        int correctNum =(int) inListInt.stream()
            .filter(z -> z == 0)
            .count();
        double correctRate = (double) correctNum / answerNum * 100;

        List<String> correctList = new ArrayList<>(inListInt.size());
        correctList = inListInt.stream()
            .map(z -> {
                if(z == 0) return "〇";
                if(z == 1) return "Ｘ";
                return "";
            })
            .collect(Collectors.toList());

        String correctResult = String.format("正答率 %.2f ％ ( 〇%d問 / 全%d問 )",
                correctRate, correctNum, answerNum);

        CorrectData data = new CorrectData(
            answerNum, correctNum, correctRate, correctResult, correctList);
        return data;
    }//zeroToString()

//    //====== Test System.nanoTime() / 各メソッドの処理時間を計測 ======
//    public default double calcCostTime(double start) {
//        double end = 0d;
//        //double now = System.nanoTime();
//        double now = System.currentTimeMillis();
//
//        if (start == 0d) {
//            start = now;
//            return start;
//        } else {
//            end = now;
//        }
//
//        BigDecimal startBd = standBigDecimal(start);
//        BigDecimal endBd = standBigDecimal(end);
//        BigDecimal costTime = endBd.subtract(startBd);
//        System.out.println("costTime: " + costTime);
//
//        return 0d;//利用しないダミー
//    }//calcCostTime()
//
//    private BigDecimal standBigDecimal(double num) {
//        BigDecimal bdc = new BigDecimal(String.valueOf(num));
//        return bdc;
//    }//standBigDecimal()
//
//    //====== Test main() ======
//    public static void main(String[] args) {
//        class Tester implements ICalcCorrect { }
//        var tester = new Tester();
//
//        List<Integer> inListInt= new ArrayList<>(
//            Arrays.asList(0, 0, 1, 1, 0, 0));
//
//        double start = tester.calcCostTime(0d);
//        var data = tester.zeroToString(inListInt);
//        //var data = tester.zeroToStringSTM(inListInt);
//        tester.calcCostTime(start);
//
//        System.out.println("answerNum: " + data.answerNum);
//        System.out.println("correctNum: " + data.correctNum);
//        System.out.printf("correctRate: %.2f \n", data.correctRate);
//        System.out.println("correctList: " + data.correctList);
//    }//main()
}//interface

/*
//====== Test zeroToString() ======
answerNum:5
correctNum:3
correctRate: 60.00
correctList[〇, 〇, ×, ×, 〇]
costTime: 3.91224E+7 = 39122400 (nanoSecond)
costTime: 4E+1 = 40 (miliSecond)

//====== Test zeroToStringSTM() ======
answerNum: 5
correctNum: 3
correctRate: 60.00
correctList: [〇, 〇, ×, ×, 〇]

answerNum: 6
correctNum: 4
correctRate: 66.67
correctList: [〇, 〇, ×, ×, 〇, 〇]
costTime: 5.30811E+7 = 53081100 (nanoSecond)
costTime: 48 (miliSecond)

//====== 考察 ======
従来型メソッドの処理時間
    costTime: 3.91224E+7 = 39122400 (nanoSecond)
    costTime: 4E+1 = 40 (miliSecond)

Strem型メソッドの処理時間
    costTime: 5.30811E+7 = 53081100 (nanoSecond)
    costTime: 48 (miliSecond)

Stream型のが遅いやん。対数メモリなので差がよくわからず。
浮動小数点数シミュレーター(URL上記)をお借りして、10進数化。
やっぱり Stream少し遅い。
 */
/*
    //###### zeroToString() as prototype ######
    //旧来の式のみのメソッド -> Streamを使って同様の動作をするメソッドを作ってみた(上記)
    public default CorrectData zeroToString(List<Integer> inListInt) {
        int answerNum = inListInt.size();
        List<String> correctList = new ArrayList<>(inListInt.size());

        int correctNum = 0;
        for(int zeroOne : inListInt) {
            if(zeroOne == 0) {
                correctNum++;
                correctList.add("〇");
            } else if (zeroOne == 1) {
                correctList.add("×");
            }
        }//for

        double correctRate = (double)correctNum / answerNum * 100;
        String correctResult = String.format("正答率 %.2f ％ ( 〇%d問 / 全%d問 )",
            correctRate, correctNum, answerNum);
        CorrectData data = new CorrectData(
            answerNum, correctNum, correctRate, correctResult, correctList);
        return data;
    }//zeroToString()
*/