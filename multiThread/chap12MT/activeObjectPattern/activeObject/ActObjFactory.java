package multiThread.chap12MT.activeObjectPattern.activeObject;

public class ActObjFactory {
    public static ActObj createActObj() {
        Servant servant = new Servant();
        ActQueue queue = new ActQueue();
        SchedulerThread scheduler = new SchedulerThread(queue);
        ActProxy proxy = new ActProxy(scheduler, servant);

        scheduler.start();
        return proxy;
    }//createActObj()
}//class
