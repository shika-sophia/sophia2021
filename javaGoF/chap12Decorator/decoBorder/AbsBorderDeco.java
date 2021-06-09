package javaGoF.chap12Decorator.decoBorder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbsBorderDeco extends AbsDisplayDeco {
    protected AbsDisplayDeco display;

    protected AbsBorderDeco(AbsDisplayDeco display) {
        this.display = display;
    }

    protected String insertBlank(String text) {
        int maxLength = display.getColumn();
        int textLength = text.length();
        int blank = maxLength - textLength;

        String blankStr =
            Stream.generate(() -> " ")
                .limit(blank)
                .collect(Collectors.joining());

        return text + blankStr;
    }//calcBlank()
}//class
