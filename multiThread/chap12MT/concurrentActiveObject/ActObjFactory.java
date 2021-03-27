package multiThread.chap12MT.concurrentActiveObject;

public class ActObjFactory {
    public static IActObj createActObj() {
        return new ActObjImpl();
    }
}//class
