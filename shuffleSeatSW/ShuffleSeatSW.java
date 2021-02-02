package shuffleSeatSW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleSeatSW {
    List<String> member;

    ShuffleSeatSW(){
        member = new ArrayList<>(
                Arrays.asList("後藤","濱田","中西","門脇","加藤",
                              "中谷","吉田","藤本","波部","宗像",
                              "吉見","西岡","西居","赤尾","辻林",
                              "廣野","大鹿"));
    }//constructor

    public static void main(String[] args) {
        var shuf = new ShuffleSeatSW();
        Collections.shuffle(shuf.member);

        var view = new ViewSeat();

        //System.out.println(shuf.member);
    }//main()

}//class
