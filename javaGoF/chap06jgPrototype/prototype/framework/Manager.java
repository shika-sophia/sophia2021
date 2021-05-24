package javaGoF.chap06jgPrototype.prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String,Product> protoMap = new HashMap<>();

    public void register(String name, Product proto) {
        protoMap.put(name, proto);
    }//register()

    public Product doClone(String protoName) {
        Product proto = protoMap.get(protoName);
        return proto.createClone();
    }//doClone()

    public Map<String, Product> getProtoMap() {
        return protoMap;
    }

}//class
