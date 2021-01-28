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

    //====== input Loop ======
    public void questInt(String quest) {

        for(int i = 0; i < questList.size(); i++){
            while (true) {
                scan = new Scanner(System.in);

                System.out.print(quest + SUFFIX);

                int inputInt = 0;
                try {
                    inputInt = scan.nextInt();

                //---- 不正値チェック(非整数) ----
                } catch (InputMismatchException e) {
                    System.out.println("< ! > 整数で" + SUFFIX);
                    continue;
                }

                //---- 不正値チェック(範囲外) ----
                if(preList.get(i) <= inputInt
                    && inputInt <= lastList.get(i)){
                    ;
                } else {
                    System.out.printf("< ! > %d ～ %d の範囲で" + SUFFIX,
                        preList.get(i), lastList.get(i));
                    System.out.println();
                    continue;
                }

                inListInt.add(inputInt);
                break;
            }//while
        }//for

    }//questStr
}//class
