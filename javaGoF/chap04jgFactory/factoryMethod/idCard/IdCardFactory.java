package javaGoF.chap04jgFactory.factoryMethod.idCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javaGoF.chap04jgFactory.factoryMethod.framework.Factory;
import javaGoF.chap04jgFactory.factoryMethod.framework.Product;

public class IdCardFactory extends Factory {
    private List<String> ownerList = new ArrayList<>();
    private Map<Integer, String> ownerMap = new TreeMap<>();
    private static int id = 0;

    @Override
    public synchronized Product createProduct(String owner) {
        id++;
        return new IdCard(owner, id);
    }//createProduct()

    @Override
    public synchronized void registerProduct(Product product) {
        String owner = ((IdCard) product).getOwner();
        ownerList.add(owner);
        ownerMap.put(id, owner);
    }//registerProduct()

    public List<String> getOwnerList() {
        return ownerList;
    }

    public Map<Integer, String> getOwnerMap() {
        return ownerMap;
    }
}//class
