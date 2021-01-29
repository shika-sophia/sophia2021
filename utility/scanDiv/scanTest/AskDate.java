package utility.scanDiv.scanTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.scanDiv.ScanInt;

public class AskDate {

    public static void main(String[] args) {
        List<String> questList = new ArrayList<>(
            Arrays.asList("年を", "月を", "日を"));

        //数値の限界値を設定
        List<Integer> preList = new ArrayList<>(
            Arrays.asList(0, 1, 1));
        List<Integer> lastList = new ArrayList<>(
                Arrays.asList(4000, 12, 31));

        var scanExe = new ScanInt(preList, lastList);
        scanExe.singleAnsInt(questList);

        List<Integer> inListInt = scanExe.getInListInt();

        for(int i = 0; i < questList.size(); i++) {
            System.out.printf("%s: %d \n", questList.get(i).replace("を", ""), inListInt.get(i));
        }
    }//main()

}//class

/*
年を入力して下さい。年
< ! > 整数で入力して下さい。
2020

月を入力して下さい。13
< ! > 1 ～ 12 の範囲で入力して下さい。
12

日を入力して下さい。31

年: 2020
月: 12
日: 31

//###### scanTest.AskDate / 2021-01-30 ######
◆日数の限界値問題
List<Integer> lastList = new ArrayList<>(
                Arrays.asList(4000, 12, 31));
この設定だと、2月31日も入力されてしまう。
月ごとの限界日数は、月の入力があってから、LocalDateなどで求めるが
リストに限界値を入れてインスタンスするので、このクラスに月の値が来るのは
ScanIntが全部終わった後になってからだ。
 */
