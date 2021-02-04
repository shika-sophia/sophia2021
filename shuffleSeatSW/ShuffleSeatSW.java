package shuffleSeatSW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShuffleSeatSW {
    private int seatNum = 16; //メンバー人数
    List<String> oldList; //現在の座席順
    List<String> neoList; //シャッフル後の座席順

    ShuffleSeatSW(){
        oldList = new ArrayList<String>(seatNum);
        neoList = new ArrayList<String>(seatNum);
        buildList();
    }//constructor

    public void buildList() {
        for(int i = 0; i < seatNum; i++) {
            //半角「A」 \u0041ではなく &#65; -> 全角「Ａ」 &#65313;
            char alphabet = (char) (65313 + i);
            oldList.add(String.valueOf(alphabet));
        }//for

        neoList.addAll(oldList);
    }//buildList()

    public void shuffleElement() {
        while(true) {
            Collections.shuffle(neoList);

            int matched = 0;
            for(int i = 0; i < seatNum; i++) {
                if(oldList.get(i).equals(neoList.get(i))) {
                    matched++;
                }
            }//for

            if(matched == 0) {
                break;
            }
        }//while
    }//shuffleElement()

    public List<String> insertFix(List<String> list) {
        //挿入する固定値を定義
        Map<Integer, String> fixMap
            = new HashMap<Integer, String>(
            Map.of(1, "□", 3, "×",
                   7, "×",
                   9, "□", 11, "×",
                   16, "大鹿",
                   17, "＠", 19, "□",
                   20, "×", 21, "□")
            );

        //固定値の数を席数に追加
        int fixNum = fixMap.values().size();
        this.seatNum += fixNum;

        //一般形'list'に挿入
        for(Entry<Integer, String> fix : fixMap.entrySet()) {
            list.add(fix.getKey(), fix.getValue());
        }//for fixMap

        return list;
    }//insertFix()

    public static void main(String[] args) {
        var shuf = new ShuffleSeatSW();
        shuf.shuffleElement();

        shuf.oldList = shuf.insertFix(shuf.oldList);
        shuf.neoList = shuf.insertFix(shuf.neoList);

//    	var view = new ViewSeat();
//      view.buildJLabelAry(shuf.oldList);

        System.out.println("oldList: " + shuf.oldList);
        System.out.println("neoList: " + shuf.neoList);
    }//main()

}//class

/*
//====== Test shuffleElement() ======
int matched = Arrays.mismatch(
    oldList.toArray(), neoList.toArray());

【考察】
mismatch()は、要素が違っているindexを出力。完全一致なら -1。
出したい結果は、全て違っているListなので、これじゃない。
*/
/*
できた
oldList: [Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]
neoList: [Ｍ, Ｏ, Ｇ, Ａ, Ｂ, Ｐ, Ｋ, Ｉ, Ｎ, Ｅ, Ｃ, Ｆ, Ｈ, Ｊ, Ｄ, Ｌ]
*/

/*
//==== Test insertFix() ======
oldList: [Ａ, □, Ｂ, ×, Ｃ, Ｄ, Ｅ, ×, Ｆ, □, Ｇ, ×, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ, 大鹿, ＠, ×, □, □]
neoList: [Ｌ, □, Ｈ, ×, Ｎ, Ｋ, Ｂ, ×, Ｉ, □, Ｍ, ×, Ａ, Ｆ, Ｃ, Ｇ, Ｊ, Ｐ, Ｄ, Ｅ, Ｏ, 大鹿, ＠, ×, □, □]
【考察】
元のList.indexを超えると、ちゃんと挿入できなくなる問題

*/