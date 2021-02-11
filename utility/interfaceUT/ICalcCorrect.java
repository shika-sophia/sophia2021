/**
 * @title utility / interfaceUT / ICalcCorrect.java
 * @contrnt List<Integer> -> 回答数, 正答数, 正答率
 * @contrnt (0, 1) -> ("〇","×") -> List<String>
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
                if(z == 1) return "×";
                return "";
            })
            .collect(Collectors.toList());

        CorrectData data = new CorrectData(
            answerNum, correctNum, correctRate, correctList);
        return data;
    }//zeroToString(()

//    //====== Test main() ======
//    public static void main(String[] args) {
//        class Tester implements ICalcCorrect { }
//        var tester = new Tester();
//
//        List<Integer> inListInt= new ArrayList<>(
//            Arrays.asList(0, 0, 1, 1, 0, 0));
//
//        var data = tester.zeroToString(inListInt);
//        //var data = tester.zeroToStringSTM(inListInt);
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

//====== Test zeroToStringSTM() ======
answerNum: 5
correctNum: 3
correctRate: 60.00
correctList: [〇, 〇, ×, ×, 〇]

answerNum: 6
correctNum: 4
correctRate: 66.67
correctList: [〇, 〇, ×, ×, 〇, 〇]
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

        CorrectData data = new CorrectData(
            answerNum, correctNum, correctRate, correctList);
        return data;
    }//zeroToString()
*/