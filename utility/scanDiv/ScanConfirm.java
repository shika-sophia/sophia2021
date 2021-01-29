package utility.scanDiv;

import java.awt.Toolkit;
import java.util.Scanner;

public class ScanConfirm extends AbsScan{

    public boolean questConfirm(String quest) {
        //---- scanSub ----
        scanSub = new Scanner(System.in);
        beep();
        System.out.print(quest + CONFIRMKEY);
        String inputYN = scanSub.next();
        System.out.println();

        //---- judge inputYN ----
        switch (inputYN) {
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

    //====== beep音 ======
    public void beep() {
        Toolkit.getDefaultToolkit().beep();
    }//beep()

//    //====== Test main() ======
//    public static void main(String[] args) {
//        var scanCfm = new ScanConfirm();
//        boolean isFin = scanCfm.questConfirm("いいですか");
//
//        System.out.println(isFin);
//    }//main()
}//class

/*
いいですか [Y] YES / [N] NO y

true

いいですか [Y] YES / [N] NO あ

false

*/