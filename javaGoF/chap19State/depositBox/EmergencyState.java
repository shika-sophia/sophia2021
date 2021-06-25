package javaGoF.chap19State.depositBox;

import utility.scanDiv.ScanConfirm;

public class EmergencyState implements IStateSecurity {
    //==== Singleton ====
    private static EmergencyState singleton = new EmergencyState();
    private EmergencyState() { }
    public static IStateSecurity getInstance() {
        return singleton;
    }

    @Override
    public void doClock(IContextDeposit context, int hour) {
        if(hour == 9) {
            var scn = new ScanConfirm();
            boolean isNomal = scn.questConfirm("非常時を解除しますか？");

            if(isNomal) {
                context.changeState(DayState.getInstance());
            }
        }
    }//doClock()

    @Override
    public void doUse(IContextDeposit context) {
        context.callCenter("<!> 非常: 非常時の金庫使用");
    }

    @Override
    public void doAlarm(IContextDeposit context) {
        context.callCenter("<!> 非常ベル (非常時)");
    }

    @Override
    public void doPhone(IContextDeposit context) {
        context.callCenter("非常時の電話");
    }

    public String toString() {
        return "[<!>非常時]";
    }
}//class
