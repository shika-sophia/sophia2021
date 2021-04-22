package javaGoF.chap06JG.prototypeRV;

import java.util.stream.Stream;

import javaGoF.chap06JG.prototypeRV.frameworkRV.AbsProduct;

public class MessageBoxRV extends AbsProduct {
    private char decochar;

    public MessageBoxRV(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String str) {
        int length = str.getBytes().length;
        decorateLine(length);
        System.out.printf("%1$s %2$s %1$s \n", decochar, str);
        decorateLine(length);
    }//use()

    private void decorateLine(int length) {
        Stream.generate(() -> String.valueOf(decochar))
              .limit(length + 4)
              .forEach(System.out::print);
        System.out.println();
    }//decorateBox()

}//class
