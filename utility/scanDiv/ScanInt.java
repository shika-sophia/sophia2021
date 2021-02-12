package utility.scanDiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ScanInt extends ScanStr {
    private List<Integer> preList;
    private List<Integer> lastList;

    //====== initializer, constructor ======
    {
        preList = new ArrayList<Integer>();
        lastList = new ArrayList<Integer>();
    }

    public ScanInt() {
        super();
    }

    public ScanInt(int pre, int last) {
        preList.add(pre);
        lastList.add(last);
    }

    public ScanInt(Integer[] preAry, Integer[] lastAry) {
        Collections.addAll(this.preList, preAry);
        Collections.addAll(this.lastList, lastAry);
    }

    public ScanInt(List<Integer> preList, List<Integer> lastList) {
        this.preList = preList;
        this.lastList = lastList;
    }

    public void singleAnsInt(List<String> questList) {
        inListInt.clear();
        for(int i = 0; i < questList.size(); i++){
            System.out.print(questList.get(i) + SUFFIX);
            inputLoop(i, -1);
        }//for
    }//singleAnsInt()

    public void multiAnsInt(List<String> questList) {
        inListInt.clear();
        //quest:
        for(int i = 0; i < questList.size(); i++){
            System.out.print(questList.get(i) + SUFFIX);

            answerLoop:
            for (int j = 0;  ; j++) {
                boolean isFin = inputLoop(i, j);

                if (isFin) {
                    break answerLoop;
                } //if isFin
            }//for j answerLoop
        }//for i quest
    }//multiAnsInt()

    public boolean inputLoop(int i, int j) {
        while (true) {
            scan = new Scanner(System.in);

            int inputInt = 0;
            try {
                //singleAns
                if(j == -1) {
                    ;
                //multiAns
                } else {
                    System.out.printf("[ %d ] ", j + 1);
                }
                inputInt = scan.nextInt();

            //---- 不正値チェック(非整数) ----
            } catch (InputMismatchException e) {
                System.out.println("< ! > 整数で" + SUFFIX);
                beep(); //ScanConfirm.beep()
                continue;
            }

            //---- 不正値チェック(範囲外) ----
            if(preList.get(i) <= inputInt
                && inputInt <= lastList.get(i)
                || inputInt == -99){
                ;
            } else {
                System.out.printf("< ! > %d ～ %d の範囲で" + SUFFIX,
                    preList.get(i), lastList.get(i));
                System.out.println();
                beep(); //ScanConfirm.beep()
                continue;
            }

            //---- input '-99'で answerLoop終了 ----
            if (inputInt == -99) {
                //終了していいかを確認[ Y / N ]
                boolean isFin = questConfirm(
                    String.format("回答を終了しますか？ (回答数: %d)"
                        , inListInt.size()));
                return isFin;
            } //if -99

            inListInt.add(inputInt);
            break;
        }//while

        return false;
    }//inputLoop()

    //====== getter, setter ======
    public List<Integer> getPreList() {
        return preList;
    }

    public void setPreList(Integer[] preAry) {
        Collections.addAll(this.preList, preAry);
    }

    public void setPreList(List<Integer> preList) {
        this.preList = preList;
    }

    public List<Integer> getLastList() {
        return lastList;
    }

    public void setLastList(Integer[] lastAry) {
        Collections.addAll(this.lastList, lastAry);
    }

    public void setLastList(List<Integer> lastList) {
        this.lastList = lastList;
    }
}//class
