package multiThread.chap12MT.addMethod;

import multiThread.chap12MT.activeObjectPattern.activeObject.AbsRequest;
import multiThread.chap12MT.activeObjectPattern.activeObject.AbsResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.FutureResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.Servant;

public class AddRequest extends AbsRequest<String> {
    protected String x;
    protected String y;

    public AddRequest(
            Servant servant, FutureResult<String> future,
            String x, String y) {
        super(servant, future);
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        AbsResult<String> result = servant.add(x, y);
        future.setResult(result);
    }//execute()

}//class
