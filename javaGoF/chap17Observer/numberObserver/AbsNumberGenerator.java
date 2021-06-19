package javaGoF.chap17Observer.numberObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsNumberGenerator {
    List<INumberObserver> observerList = new ArrayList<>();

    public void addObserver(INumberObserver observer) {
        observerList.add(observer);
    }

    public void deleteObserver(INumberObserver observer) {
        observerList.remove(observer);
    }

    public void notifyObserver() {
        observerList.forEach(obs -> obs.update(this));
    }

    public abstract int getNumber();
    public abstract void execute();
}//class
