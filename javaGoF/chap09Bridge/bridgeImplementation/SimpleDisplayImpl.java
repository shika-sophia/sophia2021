package javaGoF.chap09Bridge.bridgeImplementation;

import java.util.stream.Stream;

public class SimpleDisplayImpl extends AbsDisplayImpl {
    private String str; //表示する
    private String line;//文字列幅の区切り横線
    private int width;  //文字列のバイト単位の幅

    public SimpleDisplayImpl() { }

    public SimpleDisplayImpl(String str) {
        this.str = str;
        this.width = str.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        if(line == null) {
            var bld = new StringBuilder();
            bld.append("+");
            Stream.generate(() -> "-")
                  .limit(width)
                  .forEach(bld::append);
            bld.append("+");

            line = bld.toString();
        }//if

        System.out.println(line);
    }//printLine()

    //---- setter ----
    protected void setStr(String str) {
        this.str = str;
        this.width = str.getBytes().length;
    }
}//class
