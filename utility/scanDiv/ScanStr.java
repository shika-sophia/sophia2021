/**
 * @title utility / scanDiv / ScanStr.java
 * @see {@link AbsScan} explains these extended classes.
 *
 * @content StringのScan入力フォーム
 * @detail   ・１つの質問に、何個も回答がある場合
 *                -> questList.size() == 0にしておく
 *            ・何個も質問があり、１つの回答だけある場合
 *                -> questListに質問内容を入れておく
 *            ・多問多答のケースは扱わない
 *
 * @author shika
 * @date 2021-01-27
 */
package utility.scanDiv;

import java.util.List;
import java.util.Scanner;

public class ScanStr extends ScanConfirm{
    public void questStr(List<String> questList) {
        scan = new Scanner(System.in);

        //ひとつの質問で、回答数が決まっていない場合
        if(questList.isEmpty()) {
            System.out.print("" + SUFFIX);

            inputLoop:
            while(true) {
                int i = 1;
                System.out.printf("[ %d ] ", i);
                String inputStr = scan.nextLine();

                //input '0'でループ終了
                if(inputStr.equals("0") || inputStr.equals("０")) {
                    //終了していいかを確認[ Y / N ]
                    boolean isFin = questConfirm("");

                    if(isFin) {
                        break inputLoop;
                    }//if isFin

                }//if 0

                inListStr.add(String.format(
                    "[ %d ] %s", i, inputStr));
                i++;
            }//while inputLoop

        //何個も質問があり、回答が１つの場合
        } else {
            for(int i = 0; i < questList.size(); i++){
                System.out.print(questList.get(i) + SUFFIX);
                String inputStr = scan.nextLine();

                inListStr.add(String.format(
                    "[ %d ] %s", (i + 1), inputStr));
            }//for
        }//if-else questList.isEmpty()
    }//questStr

}//class
