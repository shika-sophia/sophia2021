package utility.scanDiv.scanTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utility.scanDiv.ScanInt;

public class TestReverse {

    public static void main(String[] args) {
        var scanDiv = new ScanInt();

        List<String> questList = new ArrayList<>(
            Arrays.asList("◆練習問題", "◆章末問題"));

        scanDiv.multiAnsStr(questList);

        System.out.println("*** 答え合わせ ***");
        //---- preList, lastList ----
        int questNum = scanDiv.getInListStr().size();
        List<Integer> preList = scanDiv.getPreList();
        List<Integer> lastList = scanDiv.getLastList();

        //要素数questNumに、全て 0, 1 を代入
        preList = Stream.generate(() -> (Integer) 0)
                .limit(questNum)
                .collect(Collectors.toList());
        lastList = Stream.generate(() -> (Integer) 1)
                .limit(questNum)
                .collect(Collectors.toList());
        scanDiv.setPreList(preList);
        scanDiv.setLastList(lastList);

        //---- scan ----
        scanDiv.singleAnsInt(scanDiv.getInListStr());

        System.out.println("preList:" + preList);
        System.out.println("lastList:" + lastList);
        System.out.println("inListStr:" + scanDiv.getInListStr());
        System.out.println("inListInt:" + scanDiv.getInListInt());
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
/*
//====== Test judgeFnKey(), singleAnsInt() as reverse ======
◆練習問題 [-88:戻る][-99:終了]
(1) A
(2) B
(3) C
(4) -88
１つ前のデータは消えます。戻っていいですか？ (戻り先⇒ (3))
 [Y] YES / [N] NO y

(3) C -> D
(4) -99
回答を終了しますか？ (回答数: 3) [Y] YES / [N] NO y

◆章末問題 [-88:戻る][-99:終了]
(1) D
(2) E
(3) -99
回答を終了しますか？ (回答数: 5) [Y] YES / [N] NO y

*** 答え合わせ ***
（1） A0
（2） B-88
１つ前のデータは消えます。戻っていいですか？ (戻り先⇒ (1))
 [Y] YES / [N] NO y

（1） A-88
< ! > [戻る]は利用できません。
（1） A 1
（2） B0
（3） C -> D0
（1） D1
（2） E0
preList:[0, 0, 0, 0, 0]
lastList:[1, 1, 1, 1, 1]
inListStr:[（1） A, （2） B, （3） C -> D, （1） D, （2） E]
inListInt:[1, 0, 0, 1, 0]
 */