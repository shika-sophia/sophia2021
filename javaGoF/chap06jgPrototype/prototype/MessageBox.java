package javaGoF.chap06jgPrototype.prototype;

import java.util.stream.Stream;

import javaGoF.chap06jgPrototype.prototype.framework.Product;

public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
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

    @Override
    //use as 'proto.createClone()' in Manager.java
    public Product createClone() {
        Product productClone = null;
        try {
            productClone = (Product) clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return productClone;
    }//createClone()

}//class
