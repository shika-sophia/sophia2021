package javaGoF.chap12Decorator.decoBorder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return insertBlank(textList.get(row));
    }

    private String insertBlank(String text) {
        int blank = getColumn() - text.length();;

        String blankStr =
            Stream.generate(() -> " ")
                .limit(blank)
                .collect(Collectors.joining());

        return text + blankStr;
    }//insertBlank()

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