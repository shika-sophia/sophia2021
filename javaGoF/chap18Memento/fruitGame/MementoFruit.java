package javaGoF.chap18Memento.fruitGame;

import java.util.ArrayList;
import java.util.List;

public class MementoFruit {
    int money;
    List<String> fruitList;

    //wide instance
    MementoFruit(int money){
        this.money = money;
        this.fruitList = new ArrayList<String>();
    }//constructor

    //narrow instance
    public int getMoney() {
        return money;
    }

    //wide instance
    void addFruit(String fruit) {
        fruitList.add(fruit);
    }

    //narrow instance
    List<String> getFruitList(){
        return new ArrayList<String>(fruitList);
    }
}//class
