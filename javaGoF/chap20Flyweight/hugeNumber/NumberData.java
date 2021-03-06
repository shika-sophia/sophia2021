package javaGoF.chap20Flyweight.hugeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberData {
    private List<int[]> hexAryList = new ArrayList<>(Arrays.asList(
        new int[] {0x0fc0, 0x3030, 0x3030, 0x3030, 0x3030, 0x3030, 0x0fc0}, //0
        new int[] {0x0300, 0x3f00, 0x0300, 0x0300, 0x0300, 0x0300, 0x3ff0}, //1
        new int[] {0x0fc0, 0x3030, 0x0030, 0x03c0, 0x0c00, 0x3000, 0x3ff0}, //2
        new int[] {0x0fc0, 0x3030, 0x0030, 0x03c0, 0x0030, 0x3030, 0x0fc0}, //3
        new int[] {0x00c0, 0x03c0, 0x0cc0, 0x30c0, 0x3ff0, 0x00c0, 0x03f0}, //4
        new int[] {0x3ff0, 0x3000, 0x3000, 0x3fc0, 0x0030, 0x3030, 0x0fc0}, //5
        new int[] {0x0fc0, 0x3030, 0x3000, 0x3fc0, 0x3030, 0x3030, 0x0fc0}, //6
        new int[] {0x3ff0, 0x3030, 0x0030, 0x00c0, 0x0300, 0x0300, 0x0300}, //7
        new int[] {0x0fc0, 0x3030, 0x3030, 0x0fc0, 0x3030, 0x3030, 0x0fc0}, //8
        new int[] {0x0fc0, 0x3030, 0x3030, 0x0ff0, 0x0030, 0x3030, 0x0fc0}, //9
        new int[] {0x0000, 0x0000, 0x0000, 0x3ff0, 0x0000, 0x0000, 0x0000}  //-
    ));

    public List<int[]> getHexAryList() {
        return hexAryList;
    }

    public String showNumber(int[] hexAry) {
        final int MAX_LENGTH = 16;
        var bld = new StringBuilder();

        for(int row : hexAry) {
            String rowStr = Integer.toBinaryString(row);
            String addZero = Stream.generate(() -> "0")
                .limit(MAX_LENGTH - rowStr.length())
                .collect(Collectors.joining());
            String str = (addZero + rowStr)
                .replace("0", ".").replace("1", "#");

            bld.append(str + "\n");
        }//for

        //System.out.println(bld.toString());
        //.out.println();
        return bld.toString();
    }//showNumber()

//    //====== Test main() ======
//    public static void main(String[] args) throws ParseException {
//        var here = new NumberData();
//        here.hexAryList.forEach(ary -> here.showNumber(ary));
//    }//main()
}//class

/*
for(int i = 0; i < 16; i++) {
    String bin = Integer.toBinaryString(i);
    String hex = Integer.toHexString(i);
    System.out.printf("%04s: %s \n", bin, hex);
}//for
0: 0
1: 1
10: 2
11: 3
100: 4
101: 5
110: 6
111: 7
1000: 8
1001: 9
1010: a
1011: b
1100: c
1101: d
1110: e
1111: f
 */
/*
public static void main(String[] args) throws ParseException {
    final int MAX_LENGTH = 16;
    int[] hex0 =
        {0x0fc0, 0x3030, 0x3030, 0x3030, 0x3030, 0x3030, 0x0fc0};

    var bld = new StringBuilder();
    for(int row : hex0) {
        String rowStr = Integer.toBinaryString(row);
        String addZero = Stream.generate(() -> "0")
            .limit(MAX_LENGTH - rowStr.length())
            .collect(Collectors.joining());
        String str = (addZero + rowStr)
            .replace("0", ".").replace("1", "#");

        bld.append(str + "\n");
    }//for

    System.out.println(bld.toString());
}//main()

....######......
..##......##....
..##......##....
..##......##....
..##......##....
..##......##....
....######......


......##........
..######........
......##........
......##........
......##........
......##........
..##########....


....######......
..##......##....
..........##....
......####......
....##..........
..##............
..##########....


....######......
..##......##....
..........##....
......####......
..........##....
..##......##....
....######......


........##......
......####......
....##..##......
..##....##......
..##########....
........##......
......######....


..##########....
..##............
..##............
..########......
..........##....
..##......##....
....######......


....######......
..##......##....
..##............
..########......
..##......##....
..##......##....
....######......


..##########....
..##......##....
..........##....
........##......
......##........
......##........
......##........


....######......
..##......##....
..##......##....
....######......
..##......##....
..##......##....
....######......


....######......
..##......##....
..##......##....
....########....
..........##....
..##......##....
....######......


................
................
................
..##########....
................
................
................

*/