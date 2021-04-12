package javaGoF.chap03JG.templateMethod;

public class CharDisplay extends AbsDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    // 「<<ch>>」の形で表示
    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }

}//class
