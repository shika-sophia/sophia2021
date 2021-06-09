package javaGoF.chap12Decorator.decoBorder;

import java.util.stream.Stream;

public class LineBorderDeco extends AbsBorderDeco {
    private String lineStr;
    private String line;

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
            return buildLine();
        } else {
            return display.getText(row - 1);
        }
    }//getText()

    private String buildLine() {
        if(line == null) {
            var bld = new StringBuilder();
            Stream.generate(() -> lineStr)
                .limit(display.getColumn())
                .forEach(bld::append);
            line = bld.toString();
        }

        return line;
    }//buildLine()

}//class
