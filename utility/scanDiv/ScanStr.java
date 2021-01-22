package utility.scanDiv;

import java.util.Scanner;

public class ScanStr extends ScanConfirm{
    public void questStr(String quest) {
        scan = new Scanner(System.in);

        //for(int i = 0; i < questList.size(); i++){
        System.out.print(quest + SUFFIX);

        String inputStr = scan.nextLine();

        inListStr.add(inputStr);

        // }//for
    }//questStr
}//class
