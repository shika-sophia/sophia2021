package javaGoF.chap06JG.prototypeRV;

import java.util.stream.Stream;

import javaGoF.chap06JG.prototypeRV.frameworkRV.AbsProduct;

public class UnderlineRV extends AbsProduct {
    private char ulchar;

    public UnderlineRV(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String str) {
        int length = str.getBytes().length;
        System.out.printf("\" %s \" \n", str);
        Stream.generate(() -> String.valueOf(ulchar))
              .limit(length + 4)
              .forEach(System.out::print);
        System.out.println();
    }//use()

}//class
