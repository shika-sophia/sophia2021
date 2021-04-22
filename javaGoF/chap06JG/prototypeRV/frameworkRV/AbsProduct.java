package javaGoF.chap06JG.prototypeRV.frameworkRV;

import javaGoF.chap06JG.prototype.framework.Product;

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
