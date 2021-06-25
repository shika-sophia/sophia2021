package javaGoF.chap19State.depositBox;

public interface IStateSecurity {
    public abstract void doClock(IContextDeposit context, int hour); //状態遷移
    public abstract void doUse(IContextDeposit context);  //金庫使用
    public abstract void doAlarm(IContextDeposit context);//非常ベル
    public abstract void doPhone(IContextDeposit context);//通常電話

}//interface