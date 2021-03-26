package multiThread.chap12MT.activeObjectPattern.activeObject;

class MakeRequest extends AbsRequest<String> {
    private final int count;
    private final char fillchar;

    public MakeRequest(
            Servant servant, FutureResult<String> future, int count, char fillchar) {
        super(servant, future);
        this.count = count;
        this.fillchar = fillchar;
    }

    @Override
    public void execute() {
        AbsResult<String> result = servant.makeString(count, fillchar);
        future.setResult(result);
    }//execute()

}//class
