package javaGoF.chap12Decorator.decoBorder;

import java.util.ArrayList;
import java.util.List;

public class MultiTextDisplayDeco extends AbsDisplayDeco {
    private List<String> textList = new ArrayList<>();

    public void add(String text) {
        textList.add(text);
    }//add()

    @Override
    public int getColumn() {
        int maxLength =
            textList.stream()
                .mapToInt(s -> s.getBytes().length)
                .max()
                .getAsInt();
        return maxLength;
    }//getColumn()

    @Override
    public int getRow() {
        return textList.size();
    }

    @Override
    public String getText(int row) {
        return textList.get(row);
    }

//    //---- Test main() ----
//    public static void main(String[] args) {
//        var here = new MultiTextDisplayDeco();
//        here.add("A");
//        here.add("BCD");
//        here.add("EFGHI");
//
//        System.out.println("column: " + here.getColumn());
//        System.out.println("row: " + here.getRow());
//        here.show();
//    }//main()
}//class

/*
//---- Test main() Result ----
column: 5
row: 3
A
BCD
EFGHI
*/