package javaGoF.chap12Decorator.decoBorder;

public class TextDisplayDeco extends AbsDisplayDeco {
    private String text;
    private int column;

    public TextDisplayDeco(String text) {
        this.text = text;
        this.column = text.getBytes().length;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public int getRow() {
        return 1;
    }

    @Override
    public String getText(int row) {
        if(row == 0) {
            return text;
        }

        return null;
    }//getText()

}//class
