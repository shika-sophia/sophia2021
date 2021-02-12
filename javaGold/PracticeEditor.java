package javaGold;

import java.util.List;
import java.util.stream.Collectors;

import utility.interfaceUT.CorrectData;
import utility.interfaceUT.ICalcCorrect;
import utility.interfaceUT.ICalcTime;
import utility.interfaceUT.TimeData;

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
        inListStr = inListStr.stream()
            .map(s -> s.replace("[ \\d ]", ""))
            .collect(Collectors.toList());

        questList.addAll(inListStr);    //questListを更新
        scanExe.setQuestList(questList);//questListを保存

        TimeData timeData = calcTime(null);
        scanExe.multiAnsStr(questList);
        timeData = calcTime(timeData.getStartTime());
        inListStr = scanExe.getInListStr();

        //---- 答え合わせ ----
        System.out.println("*** 答え合わせ *** \n");
        prepairRange(inListStr);
        scanExe.singleAnsInt(inListStr);
        List<Integer> inListInt = scanExe.getInListInt();
        CorrectData correctData = zeroToString(inListInt);

        //---- 結果作成 ----
        String practiceResult = buildPracticeResult(
                questList, inListStr, timeData, correctData);

        //---- javaDoc 作成 ----
        String className = ioFileExe.getClassName();
        boolean isRepeat = ioFileExe.readPathFile(
                    ioFileExe.getFilePath()).contains("/**");
        //初回なら javaDoc作成
        if(!isRepeat) {
            String reference = IReference.seekRef(className);
            String content = questList.toString();
            ioFileExe.buildJavaDoc(reference, content);
        }

        //---- javaDoc 追加 ----
        String appendix = buildAppendix(timeData, correctData);
        ioFileExe.appendJavaDoc(appendix);

        //---- writeFile ----
        ioFileExe.buildFilePage(practiceResult);
    }//run()

    private void prepairRange(List<String> list) {
        int questNum = list.size();
        Integer[] preAry = new Integer[questNum];
        Integer[] lastAry = new Integer[questNum];

        for(int i = 0; i < questNum; i++) {
            preAry[i] = 0;
            lastAry[i] = 1;
        }//for

        scanExe.setPreList(preAry);
        scanExe.setLastList(lastAry);
    }//prepairRange()

    private String buildPracticeResult(
            List<String> questList, //問題項目
            List<String> inListStr, //回答
            TimeData timeData,  //日時データ
            CorrectData correctData) { //正答データ
        List<String> correctList = correctData.getCorrectList();

        //---- タイトル(日付) ----
        var bld = new StringBuilder(300);
        bld.append("/* \n");
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
                if(i != count && inListStr.get(i).startsWith("[ 1 ]")) {
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
        bld.append(correctData.getCorrectResult()).append("\n");
        bld.append("*/ \n");

        return bld.toString();
    }//buildPracticeResult()

    private String buildAppendix(
            TimeData timeData, CorrectData correctData) {
        var bld = new StringBuilder(100);
        bld.append("/* Appendix \n");
        bld.append(" * @costTime ")
            .append(String.format("%s - %s ( %d 分) \n",
                formatTime(timeData.getStartTime()),
                formatTime(timeData.getLastTime()),
                timeData.getCostTime().toMinutes()));
        bld.append(" * @correctRate ").append(correctData.getCorrectResult()).append("\n");
        bld.append(" */ \n");

        return bld.toString();
    }// buildAppendix()

}//class
