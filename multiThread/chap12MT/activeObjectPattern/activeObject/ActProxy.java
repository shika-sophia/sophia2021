package multiThread.chap12MT.activeObjectPattern.activeObject;

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

}//class
