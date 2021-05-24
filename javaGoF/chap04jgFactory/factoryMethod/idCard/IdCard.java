package javaGoF.chap04jgFactory.factoryMethod.idCard;

import javaGoF.chap04jgFactory.factoryMethod.framework.Product;

public class IdCard extends Product {
    private String owner;
    private int id;

    IdCard(String owner, int id) {
        this.owner = owner;
        this.id = id;
        System.out.printf("%s(ID %d) のカードを作ります。 \n", owner, id);
    }

    @Override
    public void use() {
        System.out.printf("%s(ID %d) のカードを使います。 \n", owner, id);
    }//use

    public String getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }
}//class
