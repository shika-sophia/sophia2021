package javaGoF.chap17Observer.swingObserver;

import java.util.ArrayList;
import java.util.List;

import javaGoF.chap17Observer.numberObserver.AbsNumberGenerator;
import javaGoF.chap17Observer.numberObserver.INumberObserver;

public class DataListObserver implements INumberObserver {
    private List<Integer> dataList = new ArrayList<>();

    @Override
    public void update(AbsNumberGenerator generator) {
        dataList.add(generator.getNumber());
    }//update()

    public List<Integer> getDataList() {
        return dataList;
    }
}//class
