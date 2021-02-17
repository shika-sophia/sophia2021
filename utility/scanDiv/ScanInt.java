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
            System.out.print(questList.get(i));
            String fnFlag = inputLoop(i, -1);

            if (fnFlag.equals("Fin")) {
                break;
            } //if Fin

            if(fnFlag.equals("cantReverse")) {
                i--;
                continue;
            }//if cantReverse

            if(fnFlag.equals("Reverse")) {
                //直近のリスト要素を削除
                inListInt.remove(inListInt.size() - 1);
                i -= 2; // j-2して上で +1される -> j-1で１つ戻る
                continue;
            }//if Reverse

            inListInt.add(Integer.parseInt(fnFlag));
        }//for
    }//singleAnsInt()

    public void multiAnsInt(List<String> questList) {
        inListInt.clear();
        //quest:
        for(int i = 0; i < questList.size(); i++){
            System.out.print(questList.get(i) + FINKEY);

            answerLoop:
            for (int j = 0;  ; j++) {
                String fnFlag = inputLoop(i, j);

                if (fnFlag.equals("Fin")) {
                    break answerLoop;
                } //if Fin

                if(fnFlag.equals("cantReverse")) {
                    j--;
                    continue answerLoop;
                }//if cantReverse

                if(fnFlag.equals("Reverse")) {
                    //直近のリスト要素を削除
                    inListInt.remove(inListInt.size() - 1);
                    j -= 2; // j-2して上で +1される -> j-1で１つ戻る
                    continue answerLoop;
                }//if Reverse

                inListInt.add(Integer.parseInt(fnFlag));
            }//for j answerLoop
        }//for i quest
    }//multiAnsInt()

    public String inputLoop(int i, int j) {
        String fnFlag = "";

        while (true) {
            scan = new Scanner(System.in);

            int inputInt = 0;
            try {
                //singleAns
                if(j == -1) {// -1は singleAnsInt()からの flag
                    j = i;   // judgeFnKey()で[戻る]にしないため iを代入
                //multiAns
                } else {
                    System.out.printf("（%d） ", j + 1);
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
                || inputInt == -88
                || inputInt == -99){
                ;
            } else {
                System.out.printf("< ! > %d ～ %d の範囲で" + SUFFIX,
                    preList.get(i), lastList.get(i));
                System.out.println();
                beep(); //ScanConfirm.beep()
                continue;
            }

            //---- inputInt -> inputSt ----
            String inputStr = String.valueOf(inputInt);

            //---- [終了][戻る]の判定 ----
            fnFlag = judgeFnKey(inputStr, inListInt, j);

            if(fnFlag.equals("")) {
                fnFlag = inputStr; //NoFlag なら inputを代入
            }
            break;
        }//while

        return fnFlag;
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
