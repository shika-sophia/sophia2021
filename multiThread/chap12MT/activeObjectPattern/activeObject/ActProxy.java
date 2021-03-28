package multiThread.chap12MT.activeObjectPattern.activeObject;

import multiThread.chap12MT.addMethod.AddRequest;
import multiThread.chap12MT.swingAnsActiveObject.SearchRequest;

class ActProxy implements ActObj {
    private final SchedulerThread scheduler;
    private final Servant servant;

    public ActProxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public AbsResult<String> makeString(int count, char fillchar){
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(
            new MakeRequest(servant, future, count, fillchar));

        return future;
    }//makeString()

    @Override
    public void showString(String str) {
        scheduler.invoke(new ShowRequest(servant, str));
    }//showString()

    @Override
    public AbsResult<String> add(String x, String y) {
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(
            new AddRequest(servant, future, x, y));

        return future;
    }//add()

    @Override
    public AbsResult<String> search(String word) {
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(new SearchRequest(servant, future, word));
        return future;
    }//serch()

}//class
