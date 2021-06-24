package javaGoF.chap19State.depositBox;

public interface IContextDeposit {
    public abstract void setClock(int hour);
    public abstract void changeState(IStateSecurity state);
    public abstract void callCenter(String msg);
    public abstract void recordLog(String msg);
}//interface
