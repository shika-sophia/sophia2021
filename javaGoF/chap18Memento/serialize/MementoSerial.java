package javaGoF.chap18Memento.serialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MementoSerial implements Serializable {
    int money;
    List<String> fruitList;

    //narrow instance
    public int getMoney() {
        return money;
    }

    //wide instance
    MementoSerial(int money){
        this.money = money;
        this.fruitList = new ArrayList<String>();
    }//constructor


    //wide instance
    void addFruit(String fruit) {
        fruitList.add(fruit);
    }

    //wide instance
    List<String> getFruitList(){
        return new ArrayList<String>(fruitList);
    }
}//class
