package javaGoF.chap19State.depositBox;

public class DayState implements IStateSecurity {
    //==== Singleton ====
    private static DayState singleton = new DayState();
    private DayState() { }
    public static IStateSecurity getInstance() {
        return singleton;
    }

    //==== State ====
    @Override
    public void doClock(IContextDeposit context, int hour) {
        if(hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }//doClock()

    @Override
    public void doUse(IContextDeposit context) {
        context.recordLog("金庫使用 (昼間)");
    }

    @Override
    public void doAlarm(IContextDeposit context) {
        context.callCenter("<!> 非常ベル (昼間)");
    }

    @Override
    public void doPhone(IContextDeposit context) {
        context.callCenter("通常の電話 (昼間)");
    }

    public String toString() {
        return "[昼間]";
    }
}//class
