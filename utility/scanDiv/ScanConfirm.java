package utility.scanDiv;

import java.util.Scanner;

public class ScanConfirm extends AbsScan{

    public boolean questConfirm(String quest) {
        //---- scanSub ----
        scanSub = new Scanner(System.in);
        System.out.print(quest + SUFFIX);

        String input = scanSub.next();

        //---- judge input ----
        switch (input) {
        case "y":
        case "Y":
        case "ｙ":
        case "Ｙ":
        case "0":
        case "０":
            return true;

        default:
            ;
        }//switch

        return false;
    }//questConfirm()
}//class
