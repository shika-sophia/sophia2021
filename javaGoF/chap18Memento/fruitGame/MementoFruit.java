package javaGoF.chap18Memento.fruitGame;

import java.util.ArrayList;
import java.util.List;

public class MementoFruit {
    int money;
    List<String> fruitList;

    //narrow instance
    public int getMoney() {
        return money;
    }

    //wide instance
    MementoFruit(int money){
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
