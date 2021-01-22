package utility.scanDiv;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ScanInt extends ScanStr {
    private List<Integer> prevList;
    private List<Integer> lastList;

    {
        prevList = new ArrayList<Integer>();
        lastList = new ArrayList<Integer>();
    }

    public ScanInt(int prev, int last) {
        prevList.add(prev);
        lastList.add(last);
    }

    public void questInt(String quest) {

        //for(int i = 0; i < questList.size(); i++){
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
            //if(prevList.get(i) <= inputInt
            //    && inputInt <= lastList.get(i)){
            //    ;
            //} else {
            //    continue;
            //}

            inListInt.add(inputInt);
        }//while
   // }//for

    }//questStr
}//class
