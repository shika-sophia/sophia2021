package shuffleSeatSW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleSeatSW {
    List<String> oldList;
    List<String> neoList;

    ShuffleSeatSW(){
        oldList = new ArrayList<String>(
                Arrays.asList("後藤","濱田","中西","門脇","加藤",
                              "中谷","吉田","藤本","波部","宗像",
                              "吉見","西岡","西居","赤尾","辻林",
                              "廣野","大鹿"));
        neoList = new ArrayList<String>(oldList);
    }//constructor

    public static void main(String[] args) {
        var shuf = new ShuffleSeatSW();
        Collections.shuffle(shuf.neoList);

        var view = new ViewSeat();
        view.buildJLabelAry(shuf.oldList);

        //System.out.println("oldList: " + shuf.oldList);
        //System.out.println("neoList: " + shuf.neoList);
    }//main()

}//class

/*
oldSeat: [後藤, 濱田, 中西, 門脇, 加藤, 中谷, 吉田, 藤本,
                  波部, 宗像, 吉見, 西岡, 西居, 赤尾, 辻林, 廣野, 大鹿]

neoSeat: [廣野, 門脇, 辻林, 吉見, 宗像, 濱田, 大鹿, 後藤,
                   吉田, 西居, 中谷, 赤尾, 西岡, 藤本, 加藤, 中西, 波部]
*/