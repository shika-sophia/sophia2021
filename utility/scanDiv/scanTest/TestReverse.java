package utility.scanDiv.scanTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.scanDiv.ScanStr;

public class TestReverse {

    public static void main(String[] args) {
        var scanDiv = new ScanStr();

        List<String> questList = new ArrayList<>(
            Arrays.asList("◆練習問題", "◆章末問題"));

        scanDiv.multiAnsStr(questList);

        System.out.println("inLstStr:" + scanDiv.getInListStr());
    }//main()
}//class

/*
//====== Test judgeFnKey(), multiAnsStr() ======
◆練習問題 [-99:終了][-88:戻る]
(1) A
(2) B
(3) C
(4) -88
１つ前のデータは消えます。戻っていいですか？ (戻り先⇒ (3))
 [Y] YES / [N] NO y

(3) C -> D
(4) -99
回答を終了しますか？ (回答数: 3) [Y] YES / [N] NO y

◆章末問題 [-99:終了][-88:戻る]
(1) -88
< ! > [戻る]は利用できません。
(1) D
(2) E
(3) -99
回答を終了しますか？ (回答数: 5) [Y] YES / [N] NO y

inLstStr:[（1） A, （2） B, （3） C -> D, （1） D, （2） E]
*/