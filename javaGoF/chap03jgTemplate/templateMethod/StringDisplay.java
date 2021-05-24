package javaGoF.chap03jgTemplate.templateMethod;

import java.util.stream.Stream;

public class StringDisplay extends AbsDisplay {
    private String str;
    private int width;

    public StringDisplay(String str) {
        this.str = str;
        this.width = str.getBytes().length;
        //this.width = str.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        Stream.generate(() -> "-").limit(width)
              .forEach(System.out::print);
        System.out.println("+");
    }//printLine()

}//class

