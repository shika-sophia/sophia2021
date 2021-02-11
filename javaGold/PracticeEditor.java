package javaGold;

import java.util.List;

import utility.interfaceUT.CalcTimeData;
import utility.interfaceUT.CorrectData;
import utility.interfaceUT.ICalcCorrect;
import utility.interfaceUT.ICalcTime;

public class PracticeEditor
    implements IAnsNeedInstance, IReference, ICalcTime, ICalcCorrect {

    public PracticeEditor() {
        run();
    }

    public void run() {
        //---- 問題項目の入力 ----
        List<String> questList = scanExe.getQuestList();
        questList.add("問題の項目を");
        scanExe.multiAnsStr(questList);
        List<String> inListStr = scanExe.getInListStr();

        //---- 練習問題の回答 ----
        questList.clear();              //questListを初期化
        questList.addAll(inListStr);    //questListを更新
        scanExe.setQuestList(questList);//questListを保存

        CalcTimeData timeData = calcTime(null);
        scanExe.multiAnsStr(questList);
        timeData = calcTime(timeData.getStartTime());
        inListStr = scanExe.getInListStr();

        //---- 答え合わせ ----
        scanExe.singleAnsInt(inListStr);
        List<Integer> inListInt = scanExe.getInListInt();
        CorrectData correctData = zeroToString(inListInt);

        //---- 結果作成 ----
        String practiceResult = buildPracticeResult(
                questList, inListStr, timeData, correctData);

        //---- javaDoc 作成 ----
        String className = ioFileExe.getClassName();
        String reference = IReference.seekRef(className);
        String content = questList.toString();
        ioFileExe.buildJavaDoc(reference, content);

        //---- javaDoc 追加 ----
        String appendix = buildAppendix(timeData, correctData);

        //---- writeFile ----
        ioFileExe.buildFilePage(appendix + practiceResult);
    }//run()

    private String buildPracticeResult(
            List<String> questList, //問題項目
            List<String> inListStr, //回答
            CalcTimeData timeData,  //日時データ
            CorrectData correctData) { //正答データ
        List<String> correctList = correctData.getCorrectList();

        //---- タイトル(日付) ----
        var bld = new StringBuilder(300);
        bld.append("/*");
        bld.append("//====== ")
            .append(timeData.getStartDay())
            .append(" ====== \n");

        //---- 回答と〇× ----
        int count = 0;
        //quest:
        for(String quest : questList) {
            bld.append(quest).append("\n");

            answer:
            for(int i = count; i < inListStr.size(); i++) {
                if(i != 0 && inListStr.get(i).startsWith("[ 1 ]")) {
                    count = i;
                    break answer; //to next quest
                }
                bld.append(String.format("%s %s \n",
                    correctList.get(i), inListStr.get(i)));
            }//for inListStr
        }//for questList

        //---- timeData ----
        bld.append(timeData.getTimeResult());

        //---- correctData ----
        bld.append(correctData.getCorrectResult());
        bld.append("*/ \n");

        return bld.toString();
    }//buildPracticeResult()

    private String buildAppendix(
            CalcTimeData timeData, CorrectData correctData) {
        var bld = new StringBuilder(100);
        bld.append("/* Appendix \n");
        bld.append(" * @costTime ")
            .append(String.format("%s - %s ( %d 分) \n",
                formatTime(timeData.getStartTime()),
                formatTime(timeData.getLastTime()),
                timeData.getCostTime().toMinutes()));
        bld.append(" * @correctRate ").append(correctData).append("\n");
        bld.append(" */ \n");

        return bld.toString();
    }// buildAppendix()

}//class