package shuffleSeatSW;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStream {
    private final int BOUND = 16;      //席数
    private final int LARGE_A = 65313; //全角「Ａ」: &#65313;
    private List<String> oldList; //元の席順
    private List<String> neoList; //新しい席順

    TestStream() {
        oldList = new LinkedList<String>();
        neoList = new LinkedList<String>();
        run();
    }

    private void run() {
        oldList = IntStream.range(LARGE_A, LARGE_A + BOUND).boxed()
                .map(s -> String.valueOf((char)(int) s))
                .collect(Collectors.toList());
        neoList.addAll(oldList);

        //while(true) {
            Collections.shuffle(neoList);

        //}//while loop

        System.out.println("oldList: " + oldList);
        System.out.println("neoList: " + neoList);
    }//run()

    public static void main(String[] args) {
        new TestStream();
    }//main()

}//class

/*
//====== Test Result ======
＊iterate(0, i -> i++)
oldList: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

＊iterate(0, i -> ++i)
oldList: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

＊map(s -> String.valueOf((char)(int) s))
＊neoList.addAll(oldList);
oldList: [Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]
neoList: [Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]

＊oldList.add(0, "0");
oldList: [0, Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]
neoList: [Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]

＊Collections.shuffle(neoList);
oldList: [Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]
neoList: [Ｂ, Ｆ, Ｊ, Ｌ, Ｉ, Ｃ, Ｍ, Ｄ, Ｇ, Ｎ, Ｋ, Ａ, Ｏ, Ｈ, Ｅ, Ｐ]

*/