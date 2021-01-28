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

    public void questStr(List<String> questList) {
        scan = new Scanner(System.in);

        //多問多答 multiQuest-maltiAnswer
        for (int i = 0; i < questList.size(); i++) {
            System.out.printf("[ %d ] ", i + 1);
            System.out.print(questList.get(i) + SUFFIX + FINKEY);
            String inputStr = scan.nextLine();
            System.out.println();

            //input '0'でループ終了
            if (inputStr.equals("0") || inputStr.equals("０")) {
                //終了していいかを確認[ Y / N ]
                boolean isFin = questConfirm(
                    String.format("回答を終了しますか？ (回答数: %d)"
                        , inListStr.size()));

                if (isFin) {
                    break;
                } //if isFin
            } //if 0

            inListStr.add(String.format(
                "[ %d ] %s", (i + 1), inputStr));
        } //for
    }//questStr()
}//class
