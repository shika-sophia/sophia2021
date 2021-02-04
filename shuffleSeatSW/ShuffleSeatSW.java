package shuffleSeatSW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleSeatSW {
    private final int BOUND = 16; //メンバー人数
    List<String> oldList; //現在の座席順
    List<String> neoList; //シャッフル後の座席順

    ShuffleSeatSW(){
        oldList = new ArrayList<String>(BOUND);
        neoList = new ArrayList<String>(BOUND);
        buildList();
    }//constructor

    public void buildList() {
        for(int i = 0; i < BOUND; i++) {
            // 半角「A」 \u0041ではなく &#65; -> 全角「Ａ」 &#65313;
            char alphabet = (char) (65313 + i);
            oldList.add(String.valueOf(alphabet));
        }//for

        neoList.addAll(oldList);
    }//buildList()

    public void shuffleElement() {
        while(true) {
            Collections.shuffle(neoList);

            int matched = 0;
            for(int i = 0; i < BOUND; i++) {
                if(oldList.get(i).equals(neoList.get(i))) {
                    matched++;
                }
            }//for

            if(matched == 0) {
                break;
            }
        }//while
    }//shuffleElement()

    public static void main(String[] args) {
        var shuf = new ShuffleSeatSW();
        shuf.shuffleElement();

//    	var view = new ViewSeat();
//        view.buildJLabelAry(shuf.oldList);

        System.out.println("oldList: " + shuf.oldList);
        System.out.println("neoList: " + shuf.neoList);
    }//main()

}//class

/*
int matched = Arrays.mismatch(
    oldList.toArray(), neoList.toArray());

【考察】
mismatch()は違っている indexを出力。完全一致なら -1。
出したい結果は全て違っているList なので、これじゃない。
*/
/*
できた
oldList: [Ａ, Ｂ, Ｃ, Ｄ, Ｅ, Ｆ, Ｇ, Ｈ, Ｉ, Ｊ, Ｋ, Ｌ, Ｍ, Ｎ, Ｏ, Ｐ]
neoList: [Ｍ, Ｏ, Ｇ, Ａ, Ｂ, Ｐ, Ｋ, Ｉ, Ｎ, Ｅ, Ｃ, Ｆ, Ｈ, Ｊ, Ｄ, Ｌ]
*/