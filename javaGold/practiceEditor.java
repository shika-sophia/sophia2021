package javaGold;

import java.util.List;

import utility.interfaceUT.CalcTimeData;
import utility.interfaceUT.CorrectData;
import utility.interfaceUT.ICalcCorrect;
import utility.interfaceUT.ICalcTime;

public class practiceEditor
    implements IAnsNeedInstance, IReference, ICalcTime, ICalcCorrect {

    public practiceEditor() {
        run();
    }

    public void run() {
        //---- 問題項目の入力 ----
        List<String> questList = scanExe.getQuestList();
        questList.add("問題の項目を");
        scanExe.multiAnsStr(questList);
        List<String> inListStr = scanExe.getInListStr();

        //---- 練習問題の回答 ----
        questList.clear();
        questList.addAll(inListStr);

        CalcTimeData timeData = calcTime(null);
        scanExe.multiAnsStr(questList);
        timeData = calcTime(timeData.getStartTime());
        inListStr = scanExe.getInListStr();

        //---- 答え合わせ ----
        questList.clear();
        questList.addAll(inListStr);
        scanExe.singleAnsInt(questList);
        List<Integer> inListInt = scanExe.getInListInt();
        CorrectData correctData = zeroToString(inListInt);

        //---- 結果作成 ----
        String result = buildResult(inListStr, inListInt, timeData, correctData);
    }//run()

    private String buildResult(
            List<String> inListStr,
            List<Integer> inListInt,
            CalcTimeData timeData,
            CorrectData correctData) {
        var bld = new StringBuilder(300);

        return bld.toString();
    }//buildResult()

    public static void main(String[] args) {

    }//main()

}//class
