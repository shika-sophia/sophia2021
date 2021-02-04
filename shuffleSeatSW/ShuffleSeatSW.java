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
            char alphabet = (char) (65313 + i); // \u0041ではなく &#65;
            oldList.add(String.valueOf(alphabet));
        }//for

        neoList.addAll(oldList);

        //System.out.println("oldList: " + oldList);
        //System.out.println("neoList: " + neoList);
    }//buildList()

    public void shuffleElement() {
        while(true) {
            Collections.shuffle(neoList);

            int matched = 0;
            for(int i = 0; i < oldList.size(); i++) {
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
oldList: [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]
neoList: [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]

oldList: [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]
neoList: [N, E, D, B, P, L, J, G, A, O, I, H, C, F, M, K]
*/