package utility.scanDiv;

import java.awt.Toolkit;
import java.util.List;
import java.util.Scanner;

public class ScanConfirm extends AbsScan{

    public <T> String judgeFnKey(String input, List<T> list, int j) {
        //---- input '-99'でループ終了 ----
        if (input.equals("-99") || input.equals("ー９９")) {
            //終了していいかを確認[ Y / N ]
            boolean isFin = questConfirm(
                String.format("回答を終了しますか？ (回答数: %d)"
                    , list.size()));

            if (isFin) {
                return "Fin";
            } //if isFin
        } //if -99

        //---- input '-88' で戻る ----
        if (input.equals("-88") || input.equals("ー８８")) {
            if(j == 0) {
                beep();
                System.out.println("< ! > [戻る]は利用できません。");
                return "cantReverse";
            }

            //戻るでいいかを確認[ Y / N ]
            boolean isReverse = questConfirm(
                String.format(
                    "１つ前のデータは消えます。戻っていいですか？ (戻り先⇒ (%d))\n"
                    , j)); // j+1 が現在の問題番号

            if(isReverse) {
                return "Reverse";
            }
        }//if

        return "";
    }//judgeFinKey()

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
