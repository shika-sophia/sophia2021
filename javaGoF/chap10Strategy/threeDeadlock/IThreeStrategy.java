package javaGoF.chap10Strategy.threeDeadlock;

public interface IThreeStrategy {
    public abstract ThreeHand nextHand();
    public abstract void study(boolean win);
}//interface
