/**
 * node = [program
 *   [[repeat 4 [[repeat 3 [go, right, go, left]], right]]]]
 */

package javaGoF.chap23Interpreter.practiceNode;

import java.util.ArrayList;
import java.util.List;

public class ParseOrder {
    private List<String> orderList = new ArrayList<>();

    public List<String> parseStr(String order) {
        if(order.startsWith("[program")) {
            order = order.replace("[program [", "");
            order = order.substring(0, order.lastIndexOf("]"));
        }
        System.out.println("order: " + order);

        boolean flag = false;
        if(order.startsWith("[repeat")) {
            do {
                int times = 0;
                order = order.replace("[repeat ", "");
                times = Integer.parseInt(
                    order.substring(0, order.indexOf(" ")));

                order = order.replaceFirst("[0-9]+ ", "");
                if(order.startsWith("[repeat")) {
                    flag = true;
                    continue;
                }

                String primitive = order.substring(
                        order.indexOf("["), order.indexOf("]"));
                orderList.add("repeat" + times + primitive);
                order.replace(primitive, "");
            } while (flag);
        }//if repeat

        System.out.println("order: " + order);
        System.out.println("orderList: " + orderList);
        return orderList;
    }//parseStr()

    //====== Test main() ======
    public static void main(String[] args) {
        String sample =
            "[program [[repeat 4 [[repeat 3 [go, right, go, left]], right]]]]";
        var here = new ParseOrder();
        here.parseStr(sample);
    }//main()
}//class

/*
order: [repeat 4 [[repeat 3 [go, right, go, left]], right]]]
order: [3 [go, right, go, left]], right]]]
orderList: [repeat4[3 [go, right, go, left]
*/