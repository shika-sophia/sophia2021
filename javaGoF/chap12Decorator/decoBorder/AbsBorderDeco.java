package javaGoF.chap12Decorator.decoBorder;

import java.util.stream.Stream;

public abstract class AbsBorderDeco extends AbsDisplayDeco {
    protected AbsDisplayDeco display;
    protected String line;

    protected AbsBorderDeco(AbsDisplayDeco display) {
        this.display = display;
    }

    protected String buildLine(String lineStr) {
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
