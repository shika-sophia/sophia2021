package multiThread.chap12MT.activeObjectPattern.activeObject;

public abstract class AbsRequest<T> {
    protected final Servant servant;
    protected final FutureResult<T> future;

    protected AbsRequest(
            Servant servant, FutureResult<T> future) {
        this.servant = servant;
        this.future = future;
    }

    public abstract void execute();
}//class
