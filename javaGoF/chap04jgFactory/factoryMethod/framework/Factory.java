package javaGoF.chap04jgFactory.factoryMethod.framework;

public abstract class Factory {

    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);

        return p;
    }//create()

    public abstract Product createProduct(String owner);
    public abstract void registerProduct(Product product);
}//class
