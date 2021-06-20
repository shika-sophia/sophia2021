package javaGoF.chap17Observer.numberObserver;

public class IncrementNumberGenerator
        extends AbsNumberGenerator {
    private int number;
    private int begin;
    private int end;
    private int step;

    public IncrementNumberGenerator(
            int begin, int end, int step) {
        this.begin = begin;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for(number = begin; number < end; number += step) {
            notifyObserver();
        }//for
    }//execute()

}//class
