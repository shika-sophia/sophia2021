package javaGoF.chap19State.depositBox;

public class LunchState implements IStateSecurity {
    //==== Singleton ====
    private static LunchState singleton = new LunchState();
    private LunchState() { }
    public static IStateSecurity getInstance() {
        return singleton;
    }

    //==== State ====
    @Override
    public void doClock(IContextDeposit context, int hour) {
        if(hour == 14) {
            context.changeState(DayState.getInstance());
        }
    }//doClock()

    @Override
    public void doUse(IContextDeposit context) {
        context.callCenter("<!> 非常: 昼食時の金庫使用");
    }

    @Override
    public void doAlarm(IContextDeposit context) {
        context.callCenter("<!> 非常ベル (昼食時)");
        context.changeState(EmergencyState.getInstance());
    }

    @Override
    public void doPhone(IContextDeposit context) {
        context.callCenter("昼食時の通話録音");
    }

    public String toString() {
        return "[昼食時]";
    }
}//class
