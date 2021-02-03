package shuffleSeatSW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleSeatSW {
    List<String> oldList; //現在の座席順
    List<String> neoList; //シャッフル後の座席順

    ShuffleSeatSW(){
        oldList = new ArrayList<String>(
            Arrays.asList("後藤","濱田","中西","門脇",
                          "加藤","中谷","吉田","藤本",
                          "波部","宗像","吉見","西岡",
                          "西居","赤尾","辻林","廣野"));
        neoList = new ArrayList<String>(oldList);
    }//constructor

    public void shuffleElement() {
        while(true) {
            Collections.shuffle(neoList);

            int matched = 0;
            for(int i = 0; i < oldList.size(); i++) {
                if(oldList.get(i) == neoList.get(i)) {
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
oldList: [後藤, 濱田, 中西, 門脇, 加藤, 中谷, 吉田, 藤本, 波部, 宗像, 吉見, 西岡, 西居, 赤尾, 辻林, 廣野]
neoList: [赤尾, 加藤, 中谷, 廣野, 西居, 波部, 藤本, 吉見, 宗像, 西岡, 吉田, 中西, 濱田, 門脇, 後藤, 辻林]
0
oldList: [後藤, 濱田, 中西, 門脇, 加藤, 中谷, 吉田, 藤本, 波部, 宗像, 吉見, 西岡, 西居, 赤尾, 辻林, 廣野]
neoList: [後藤, 廣野, 波部, 吉田, 中西, 宗像, 西居, 辻林, 加藤, 門脇, 西岡, 赤尾, 藤本, 濱田, 中谷, 吉見]
1
【考察】
mismatch()は違っている indexを出力。完全一致なら -1。
出したい結果は全て違っているList なので、これじゃない。
*/
/*
できた
oldList: [後藤, 濱田, 中西, 門脇, 加藤, 中谷, 吉田, 藤本, 波部, 宗像, 吉見, 西岡, 西居, 赤尾, 辻林, 廣野]
neoList: [門脇, 廣野, 宗像, 中西, 西岡, 西居, 赤尾, 吉見, 後藤, 藤本, 加藤, 中谷, 濱田, 波部, 吉田, 辻林]
*/