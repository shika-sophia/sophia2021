/**
 * @title utility / scanDiv / ScanStr.java
 * @see {@link AbsScan} explains these extended classes.
 * @content StringのScan入力フォーム
 * @author shika
 * @date 2021-01-27
 */
package utility.scanDiv;

import java.util.List;
import java.util.Scanner;

public class ScanStr extends ScanConfirm {
    public ScanStr() {
        scan = new Scanner(System.in);
    }

    //====== 多問一答 multiQuest-singleAnswer ======
    public void singleAnsStr(List<String> questList) {
        inListStr.clear();
        for (int i = 0; i < questList.size(); i++) {
            System.out.println(questList.get(i) + FINKEY);
            String inputStr = scan.nextLine();

            inListStr.add(inputStr);
        }//for i
    }//singleAnsStr()

    //====== 多問多答 multiQuest-multiAnswer ======
    public void multiAnsStr(List<String> questList) {
        inListStr.clear();
        //quest:
        for (int i = 0; i < questList.size(); i++) {
            System.out.println(questList.get(i) + FINKEY);

            answerLoop:
            for(int j = 0;  ; j++) {
                System.out.printf("[ %d ] ", j + 1);
                String inputStr = scan.nextLine();

                //input '0'でループ終了
                if (inputStr.equals("-99") || inputStr.equals("ー９９")) {
                    //終了していいかを確認[ Y / N ]
                    boolean isFin = questConfirm(
                        String.format("回答を終了しますか？ (回答数: %d)"
                            , inListStr.size()));

                    if (isFin) {
                        break answerLoop;
                    } //if isFin
                } //if 0

                inListStr.add(String.format(
                    "[ %d ] %s", (j + 1), inputStr));
            }//for j answerLoop
        } //for i quest
    }//multiAnsStr()
}//class
