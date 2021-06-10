package javaGoF.chap12Decorator.decoBorder;

public class LineBorderDeco extends AbsBorderDeco {
    private String lineStr;

    protected LineBorderDeco(AbsDisplayDeco display, String lineStr) {
        super(display);
        this.lineStr = lineStr;
    }

    @Override
    public int getColumn() {
        return display.getColumn();
    }

    @Override
    public int getRow() {
        return 1 + display.getRow() + 1;
    }

    @Override
    public String getText(int row) {
        if(row == 0 || row == (display.getRow() + 1)) {
            return buildLine(lineStr);
        } else {
            return display.getText(row - 1);
        }
    }//getText()

}//class
