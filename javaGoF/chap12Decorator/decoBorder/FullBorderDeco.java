package javaGoF.chap12Decorator.decoBorder;

import java.util.stream.Stream;

public class FullBorderDeco extends AbsBorderDeco {
    private String line;

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
            return buildLine();
        } else {
            return "|" + display.getText(row - 1) + "|";
        }
    }//getText()

    private String buildLine() {
        if (line == null) {
            var bld = new StringBuilder();

            bld.append("+");
            Stream.generate(() -> "-")
                .limit(display.getColumn())
                .forEach(bld::append);
            bld.append("+");

            line = bld.toString();
        }

        return line;
    }//buildLine()

}//class
