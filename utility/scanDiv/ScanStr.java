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

            //---- [終了][戻る]の判定 ----
            String fnFlag = judgeFnKey(inputStr, inListStr, i);

            if (fnFlag.equals("Fin")) {
                break;
            } //if Fin

            if(fnFlag.equals("cantReverse")) {
                i--;
                continue;
            }//if cantReverse

            if(fnFlag.equals("Reverse")) {
                //直近のリスト要素を削除
                inListStr.remove(inListStr.size() - 1);
                i -= 2; // j-2して上で +1される -> j-1で１つ戻る
                continue;
            }//if Reverse

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
                System.out.printf("(%d) ", j + 1);
                String inputStr = scan.nextLine();

                //---- [終了][戻る]の判定 ----
                String fnFlag = judgeFnKey(inputStr, inListStr, j);

                if (fnFlag.equals("Fin")) {
                    break answerLoop;
                } //if Fin

                if(fnFlag.equals("cantReverse")) {
                    j--;
                    continue answerLoop;
                }//if cantReverse

                if(fnFlag.equals("Reverse")) {
                    //直近のリスト要素を削除
                    inListStr.remove(inListStr.size() - 1);
                    j -= 2; // j-2して上で +1される -> j-1で１つ戻る
                    continue answerLoop;
                }//if Reverse

                //---- inListStrに登録 ----
                inListStr.add(String.format(
                    "（%d） %s", (j + 1), inputStr));
            }//for j answerLoop
        } //for i quest
    }//multiAnsStr()
}//class
