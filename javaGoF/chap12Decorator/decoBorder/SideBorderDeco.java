package javaGoF.chap12Decorator.decoBorder;

public class SideBorderDeco extends AbsBorderDeco {
    private String sideDeco;

    public SideBorderDeco(
            AbsDisplayDeco display, String sideDeco) {
        super(display);
        this.sideDeco = sideDeco;
    }

    @Override
    public int getColumn() {
        return 1 + display.getColumn() + 1;
    }

    @Override
    public int getRow() {
        return display.getRow();
    }

    @Override
    public String getText(int row) {
        String text = insertBlank(display.getText(row));
        return sideDeco + text + sideDeco;
    }

}//class
