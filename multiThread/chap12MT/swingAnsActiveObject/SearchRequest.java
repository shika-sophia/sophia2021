package multiThread.chap12MT.swingAnsActiveObject;

import multiThread.chap12MT.activeObjectPattern.activeObject.AbsRequest;
import multiThread.chap12MT.activeObjectPattern.activeObject.AbsResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.FutureResult;
import multiThread.chap12MT.activeObjectPattern.activeObject.Servant;

public class SearchRequest extends AbsRequest<String> {
    private final String word;

    public SearchRequest(
            Servant servant, FutureResult<String> future, String word) {
        super(servant, future);
        this.word = word;
    }

    @Override
    public void execute() {
        AbsResult<String> result = servant.search(word);
        future.setResult(result);
    }//execute()
}//class
