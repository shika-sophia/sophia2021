package javaGoF.chap06jgPrototype.prototypeRV.frameworkRV;

import javaGoF.chap06jgPrototype.prototype.framework.Product;

public abstract class AbsProduct implements Product {
    public abstract void use(String str);

    public Product createClone() {
        Product productClone = null;
        try {
            productClone = (Product) clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return productClone;
    }//createClone()

}//interface
