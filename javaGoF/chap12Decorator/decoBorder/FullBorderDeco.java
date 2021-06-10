package javaGoF.chap12Decorator.decoBorder;

public class FullBorderDeco extends AbsBorderDeco {

    public FullBorderDeco(AbsDisplayDeco display) {
        super(display);
    }

    @Override
    public int getColumn() {
        return 1 + display.getColumn() + 1;
    }

    @Override
    public int getRow() {
        return 1 + display.getRow() + 1;
    }

    @Override
    public String getText(int row) {
        if (row == 0 || row == display.getRow() + 1 ) {
            return "+" + buildLine("-") + "+";
        } else {
            return "|" + display.getText(row - 1) + "|";
        }
    }//getText()

}//class
