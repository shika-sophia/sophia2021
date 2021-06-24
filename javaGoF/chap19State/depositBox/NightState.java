package javaGoF.chap19State.depositBox;

public class NightState implements IStateSecurity {
    //==== Singleton ====
    private static NightState singleton = new NightState();
    private NightState() { }
    public static IStateSecurity getInstance() {
        return singleton;
    }

    //==== State ====
    @Override
    public void doClock(IContextDeposit context, int hour) {
        if(9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }//doClock()

    @Override
    public void doUse(IContextDeposit context) {
        context.callCenter("<!> 非常: 夜間の金庫使用");
    }

    @Override
    public void doAlarm(IContextDeposit context) {
        context.callCenter("<!> 非常ベル (夜間)");
    }

    @Override
    public void doPhone(IContextDeposit context) {
        context.callCenter("夜間の通話録音");
    }

    public String toString() {
        return "[夜間]";
    }
}//class
