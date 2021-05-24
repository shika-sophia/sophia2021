package javaGoF.chap06jgPrototype.prototype;

import java.util.stream.Stream;

import javaGoF.chap06jgPrototype.prototype.framework.Product;

public class Underline implements Product {
    private char ulchar;

    public Underline(char ulchar) {
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
